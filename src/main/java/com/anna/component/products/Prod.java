package com.anna.component.products;

import java.math.BigDecimal;



public class Prod {

	
	
	
	
	private BigDecimal productId;
	
	private String imageUrl ;
	
	private double price ;
	
	private String title;
	
	private String categoryId;
	public Prod() {
	}
	public Prod(BigDecimal productId, String imageUrl, double price, String title, String categoryId) {
		super();
		this.productId = productId;
		this.imageUrl = imageUrl;
		this.price = price;
		this.title = title;
		this.categoryId = categoryId;
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
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "Prod [productId=" + productId + ", imageUrl=" + imageUrl + ", price=" + price + ", title=" + title
				+ ", categoryId=" + categoryId + "]";
	}
	
	

}
