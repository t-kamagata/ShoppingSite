package jp.co.aforce.model;

import java.io.Serializable;

public class User implements Serializable{
	private int id;
	private String last_name;
	private String first_name;
	private String mail_address;
	private String password;
	private String payment;
	private String address;
	private int birth_year;
	private int birth_month;
	private int birth_day;
	private String phone_number;
	private boolean isAdmin;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMail_address() {
		return mail_address;
	}
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBirth_year() {
		return birth_year;
	}
	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
	}
	public int getBirth_month() {
		return this.birth_month;
	}
	public void setBirth_month(int birth_month) {
		this.birth_month = birth_month;
	}
	public int getBirth_day() {
		return this.birth_day;
	}
	public void setBirth_day(int birth_day) {
		this.birth_day = birth_day;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public boolean getIsAdmin() {
		return this.isAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
