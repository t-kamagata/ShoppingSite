package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.model.Product;

public class ProductDAO extends DAO {
	
	public int createProduct(Product product) throws Exception{
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"insert into product (id, name, price, stock) values (null, ?, ?, ?)"
			);
		
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		st.setInt(3, product.getStock());
		
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		
		return line;
	}
	
	public Product getProduct(int id) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from product where id = ?"
			);
		
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		
		Product product = null;
		
		if(rs.next()) {
			product = new Product();
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getInt("price"));
			product.setStock(rs.getInt("stock"));
		}
		
		return product;
	}
	
	public List<Product> getAllProduct() throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from product"
			);
		
		ResultSet rs = st.executeQuery();
		
		List<Product> list = new ArrayList<>();
		
		while(rs.next()) {
			var product = new Product();
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getInt("price"));
			product.setStock(rs.getInt("stock"));
			product.setImg_path(rs.getString("img_path"));
			
			list.add(product);
		}
		
		return list;
	}
	
	public int updateProduct(Product product) throws Exception{
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"update product set name = ?, price = ?, stock = ?"
				+ " where id = ?"
			);
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		st.setInt(3, product.getStock());
		st.setInt(4, product.getId());
		
		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
	
	public int deleteProduct(int id) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"delete from product where id = ?"
			);
		st.setInt(1, id);
		
		int line = st.executeUpdate();
		
		st.close();
		con.close();

		return line;
	}
	
	public List<Product> search(String key) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from product where name like ?"
			);
		
		st.setString(1, "%" + key + "%");
		ResultSet rs = st.executeQuery();
		
		List<Product> list = new ArrayList<>();
		
		while(rs.next()) {
			var product = new Product();
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getInt("price"));
			product.setStock(rs.getInt("stock"));
			product.setImg_path(rs.getString("img_path"));
			
			list.add(product);
		}
		
		return list;
	}
	
	public List<Product> getAllAscending(String column) throws Exception{
		Connection con = getConnection();
		
		String state = "select * from product order by " + column;
		PreparedStatement st = con.prepareStatement(
				state
			);
		
		ResultSet rs = st.executeQuery();
		
		List<Product> list = new ArrayList<>();
		
		while(rs.next()) {
			var product = new Product();
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getInt("price"));
			product.setStock(rs.getInt("stock"));
			product.setImg_path(rs.getString("img_path"));
			
			list.add(product);
		}
		
		return list;
	}
	
	public List<Product> getAllDescending(String column) throws Exception{
		Connection con = getConnection();
		
		String state = "select * from product order by " + column + " desc";
		PreparedStatement st = con.prepareStatement(
				state
			);
		
		ResultSet rs = st.executeQuery();
		
		List<Product> list = new ArrayList<>();
		
		while(rs.next()) {
			var product = new Product();
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getInt("price"));
			product.setStock(rs.getInt("stock"));
			product.setImg_path(rs.getString("img_path"));
			
			list.add(product);
		}
		
		return list;
	}
}
