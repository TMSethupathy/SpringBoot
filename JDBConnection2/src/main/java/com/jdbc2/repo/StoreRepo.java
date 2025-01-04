package com.jdbc2.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jdbc2.model.Store;

@Repository
public class StoreRepo {
	@Autowired
	private JdbcTemplate jt;
	
	public int save(Store store) {
		String sql="INSERT INTO store(productID,productName,productQuantity,productPrice) VALUES (?, ?, ?, ?)";
		return jt.update(sql, store.getProductID(),store.getProductName(),store.getProductQuantity(),store.getProductPrice()) ; 
	}
	
	public List<Store> findAll(){
		String sql="SELECT * FROM store";
		return jt.query(sql,new StoreRowMapper());	
	}
	
	public Store findById(int productID) {
		String sql="SELECT *FROM store WHERE productID = ?";
		return jt.queryForObject(sql,new StoreRowMapper(),productID);
	}
	
	public int update(Store store) {
	    String sql = "UPDATE store SET productID = ?, productName = ?, productQuantity = ?, productPrice = ? WHERE productID = ?";
	    return jt.update(sql, store.getProductID(), store.getProductName(), store.getProductQuantity(), store.getProductPrice(), store.getProductID());
	}

	
	public int detete(int productID) {
		String sql="DELETE FROM store WHERE productID = ? ";
		return jt.update(sql,productID);
	}
	
	
	private static class StoreRowMapper implements RowMapper<Store>{

		@Override
		public Store mapRow(ResultSet rs, int rowNum) throws SQLException {
			Store store=new Store();
			store.setProductID(rs.getInt("productID"));
			store.setProductName(rs.getString("productName"));
			store.setProductQuantity(rs.getInt("productQuantity"));
			store.setProductPrice(rs.getFloat("productPrice"));
			return store;
			
		}
		
	}

}
