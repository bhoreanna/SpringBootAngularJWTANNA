package com.anna.component.categories;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.anna.component.products.Products;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CATEGORIES")
// CATEGORIES
public class Categories {

	

	@Id
	@Column(name = "CATEGORYID")
	private String categoryId;

	@Column(name = "CATEGORYNAME")
	private String categoryName;

	@JsonManagedReference
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Products> productsList;

	public Categories() {
	}

	public Categories(String categoryId, String categoryName, List<Products> productsList) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.productsList = productsList;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Products> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<Products> productsList) {
		this.productsList = productsList;
	}

	@Override
	public String toString() {
		return "Categories [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}
