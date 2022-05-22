package entity;

import java.sql.Date;

public class Product {

	private int id;

	private String name;

	private Date expire;

	private float price;

	public Product() {
	}
	
	public Product(String name, Date expire, float price) {
		this.name = name;
		this.expire = expire;
		this.price = price;
	}

	public Product(int id, String name, Date expire, float price) {
		super();
		this.id = id;
		this.name = name;
		this.expire = expire;
		this.price = price;
	}

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

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
