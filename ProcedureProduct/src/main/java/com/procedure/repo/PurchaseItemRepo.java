package com.procedure.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.procedure.model.PurchaseItem;
import com.procedure.model.Purchases;
import com.procedure.model.Products;

@Repository
public class PurchaseItemRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    // Method to find all purchase items
    public List<PurchaseItem> findAll() {
        String sql = "SELECT pi.id, pi.quantity, p.purchase_id, pr.product_id, pr.product_name " +
                     "FROM purchase_item pi " +
                     "JOIN purchases p ON pi.purchase_id = p.purchase_id " +
                     "JOIN products pr ON pi.product_id = pr.product_id";
        
        return jdbcTemplate.query(sql, new PurchaseItemRowMapper());
    }
    
    // Method to find all purchases
    public List<Purchases> findAllPurchases() {
        String sql = "SELECT p.purchase_id FROM purchases p";
        
        return jdbcTemplate.query(sql, new PurchasesRowMapper());
    }

    // RowMapper for PurchaseItem
    private static class PurchaseItemRowMapper implements RowMapper<PurchaseItem> {
        @Override
        public PurchaseItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            PurchaseItem purchaseItem = new PurchaseItem();
            purchaseItem.setId(rs.getInt("id"));
            purchaseItem.setQuantity(rs.getLong("quantity"));

            Purchases purchase = new Purchases();
            purchase.setPurchaseId(rs.getInt("purchase_id"));
            purchaseItem.setPurchases(purchase);

            Products product = new Products();
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            purchaseItem.setProducts(product);

            return purchaseItem;
        }
    }

    // RowMapper for Purchases
    private static class PurchasesRowMapper implements RowMapper<Purchases> {
        @Override
        public Purchases mapRow(ResultSet rs, int rowNum) throws SQLException {
            Purchases purchases = new Purchases();
            purchases.setPurchaseId(rs.getInt("purchase_id"));
            return purchases;
        }
    }
}
