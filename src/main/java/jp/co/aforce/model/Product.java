package jp.co.aforce.model;

import java.io.Serializable;

public class Product implements Serializable {
	private int id;
	private String name;
	private int price;
	private int stock;
	private String img_path;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImg_path() {
		return this.img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
}
