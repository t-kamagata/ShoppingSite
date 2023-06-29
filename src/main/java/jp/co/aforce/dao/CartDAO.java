package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.model.Cart;

public class CartDAO extends DAO{
	
	public Cart getCart(int id) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select c.id, p.name, c.quantity from cart as c join product as p"
				+ " on c.product_id = p.id"
				+ " where c.id = ?"
			);
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		
		Cart cart = new Cart();
		
		if(rs.next()) {
			cart.setId(rs.getInt("id"));
			cart.setName(rs.getString("name"));
			cart.setQuantity(rs.getInt("quantity"));
		}
		return cart;
	}
	
	public int updateCart(Cart cart) throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"update cart set quantity = ?"
				+ " where id = ?"
			);
		st.setInt(1, cart.getQuantity());
		st.setInt(2, cart.getId());
		
		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
	public int addToCart(int userId, int productId, int stock) throws Exception{
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"insert into cart values (null, ?, ?, ?)"
			);
		
		st.setInt(1, userId);
		st.setInt(2, productId);
		st.setInt(3, stock);
		
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		
		return line;
	}
	
	public int deleteFromCart(int id) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"delete from cart where id = ?"
			);
		st.setInt(1, id);
		
		int line = st.executeUpdate();
		
		st.close();
		con.close();

		return line;
	}
	
	public List<Cart> returnCartItems(int userId) throws Exception{
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select c.id, p.name, p.price, c.quantity from product as p"
				+ " join cart as c on p.id = c.product_id"
				+ " where c.user_id = ?;"
			);
		st.setInt(1, userId);
		
		ResultSet rs = st.executeQuery();
		
		List<Cart> list = new ArrayList<>();
		
		while(rs.next()) {
			Cart cart = new Cart();
			cart.setId(rs.getInt("id"));
			cart.setName(rs.getString("name"));
			cart.setPrice(rs.getInt("price"));
			cart.setQuantity(rs.getInt("quantity"));
			
			list.add(cart);
		}
		
		return list;
	}
}
