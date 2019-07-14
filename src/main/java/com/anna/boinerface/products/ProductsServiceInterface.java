package com.anna.boinerface.products;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.anna.component.categories.Categories;
import com.anna.component.products.Products;

public interface ProductsServiceInterface {
	
	public List<Products> getProductsList();
	public Products saveProducts(Products products);
	public Optional<Products> searchProducts(BigDecimal productId);
	public int deleteProducts(BigDecimal productId);
	public Products updateCategories(Products products);
	public List<Products> getProductsListByCategory(Categories category);
}
