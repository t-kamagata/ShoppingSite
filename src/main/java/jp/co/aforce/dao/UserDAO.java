package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.model.User;

public class UserDAO extends DAO {
	
	public User getUser(String mail_address, String password) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from user where mail_address = ? and password = ?"
			);
		st.setString(1, mail_address);
		st.setString(2, password);
		
		ResultSet rs = st.executeQuery();
		
		User user = null;
		if(rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setLast_name(rs.getString("last_name"));
			user.setFirst_name(rs.getString("first_name"));
			user.setMail_address(rs.getString("mail_address"));
			user.setPassword(rs.getString("password"));
			user.setPayment(rs.getString("payment"));
			user.setAddress(rs.getString("address"));
			user.setBirth_year(rs.getInt("birth_year"));
			user.setBirth_month(rs.getInt("birth_month"));
			user.setBirth_day(rs.getInt("birth_day"));
			user.setPhone_number(rs.getString("phone_number"));
			user.setIsAdmin(rs.getBoolean("isAdmin"));
		} else {
			st.close();
			con.close();
			return null;
		}
		
		st.close();
		con.close();
		
		return user;
	}
	public int createUser(User user) throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"insert into user values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
			);
		
		st.setString(1, user.getLast_name());
		st.setString(2, user.getFirst_name());
		st.setString(3, user.getMail_address());
		st.setString(4, user.getPassword());
		st.setString(5, user.getPayment());
		st.setString(6, user.getAddress());
		st.setInt(7, user.getBirth_year());
		st.setInt(8, user.getBirth_month());
		st.setInt(9, user.getBirth_day());
		st.setString(10, user.getPhone_number());
		st.setBoolean(11, user.getIsAdmin());
		
		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
	
	public int updateMember(User member) throws Exception{
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"update user set last_name = ?, first_name = ?,"
				+ "mail_address = ?, password = ?, payment = ?, address = ?, birth_year = ?,"
				+ "birth_month = ?, birth_day = ?, phone_number = ?, isAdmin = ? where id = ?"
			);
		st.setString(1, member.getLast_name());
		st.setString(2, member.getFirst_name());
		st.setString(3, member.getMail_address());
		st.setString(4, member.getPassword());
		st.setString(5, member.getPayment());
		st.setString(6, member.getAddress());
		st.setInt(7, member.getBirth_year());
		st.setInt(8, member.getBirth_month());
		st.setInt(9, member.getBirth_day());
		st.setString(10, member.getPhone_number());
		st.setBoolean(11, member.getIsAdmin());
		
		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
	
	public int deleteUser(int id) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"delete from user where id = ?"
			);
		st.setInt(1, id);
		
		int line = st.executeUpdate();
		
		st.close();
		con.close();

		return line;
	}
}
