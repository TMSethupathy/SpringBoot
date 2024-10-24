package com.procedure.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.procedure.model.Purchases;
import com.procedure.model.PurchaseItem;

@Repository
public class PurchasesRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Purchases> findAll() {
        String sql = "SELECT p.purchase_id, pi.id, pi.quantity, pi.product_id FROM purchases p " +
                     "LEFT JOIN purchase_item pi ON p.purchase_id = pi.pi.product_id";
        return jdbcTemplate.query(sql, new PurchasesRowMapper());
    }

    private static class PurchasesRowMapper implements RowMapper<Purchases> {

        @Override
        public Purchases mapRow(ResultSet rs, int rowNum) throws SQLException {
            Purchases purchase = new Purchases();
            purchase.setPurchaseId(rs.getInt("purchase_id"));
            
            PurchaseItem item = new PurchaseItem();
            item.setId(rs.getInt("id"));
            item.setQuantity(rs.getLong("quantity"));
            return purchase;
        }
    }
}