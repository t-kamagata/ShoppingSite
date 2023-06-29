package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.model.Order;

public class OrdersDAO extends DAO{
	
	public int createOrders(int userId) throws Exception{
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"insert into orders values (null, ?, ?)"
			);
		
		st.setInt(1, userId);
		st.setBoolean(2, false);
		
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		
		return line;
	}
	
	public List<Order> getAllOrders() throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select o.id, u.last_name, u.first_name, o.shipping"
				+ " from orders as o"
				+ " join user as u on o.user_id = u.id"
			);
		
		ResultSet rs = st.executeQuery();
		
		List<Order> list = new ArrayList<>();
		
		while(rs.next()) {
			var order = new Order();
			order.setId(rs.getInt("id"));
			order.setUserName(rs.getString("last_name") + rs.getString("first_name"));
			order.setShipping(rs.getBoolean("shipping"));
			
			list.add(order);
		}
		
		return list;
	}
}
