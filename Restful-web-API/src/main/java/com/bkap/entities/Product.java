package com.bkap.entities;

import java.sql.Date;
import java.util.Locale.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "expire")
	private Date expire;

	@Column(name = "price")
	private float price;

//	@ManyToOne
//	@JoinColumn(name = "category_id", referencedColumnName = "id")
//	private Category productCategory;

	public Product() {
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

//	public Category getProductCategory() {
//		return productCategory;
//	}
//
//	public void setProductCategory(Category productCategory) {
//		this.productCategory = productCategory;
//	}
	
	

}
