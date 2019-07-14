package com.anna.component.products;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.anna.component.categories.Categories;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="PRODUCTS") 

//PRODUCTS
public class Products {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PRODUCTID")
	private BigDecimal productId;
	
	@Column(name="IMAGEURL")
	private String imageUrl ;
	
	@Column(name="PRICE")
	private double price ;
	
	@Column(name="TITLE")
	private String title;
	
	@Transient
	private String categoryId;
	 
	
	@JsonBackReference
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "CATEGORYID" )
	private Categories category ;
	
	public Products() {
		
	}

	public Products(BigDecimal productId, String imageUrl, double price, String title, Categories category) {
		super();
		this.productId = productId;
		this.imageUrl = imageUrl;
		this.price = price;
		this.title = title;
		this.category = category;
	}

	public BigDecimal getProductId() {
		return productId;
	}

	public void setProductId(BigDecimal productId) {
		this.productId = productId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	
	
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", imageUrl=" + imageUrl + ", price=" + price + ", title=" + title
				+ ", category=" + category + "]";
	}

	
	
	

	

	
	
	
	

	}
