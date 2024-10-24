package com.procedure.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.procedure.model.Products;

@Repository
public class ProductsRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Products> findAll() {
		String sql = "SELECT * FROM Products";
		return jdbcTemplate.query(sql, new ProductsRowMapper());
	}

	private static class ProductsRowMapper implements RowMapper<Products> {

		@Override
		public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
			Products products = new Products();
			products.setProductId(rs.getInt("product_id"));
			products.setProductName(rs.getString("product_name"));
			products.setQuantity(rs.getLong("quantity"));
			return products;

		}

	}

}
