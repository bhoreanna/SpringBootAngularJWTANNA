package com.anna.service.products;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anna.boinerface.products.ProductsServiceInterface;
import com.anna.component.categories.Categories;
import com.anna.component.products.Products;
import com.anna.repository.products.ProductsRepository;

@Service
public class ProductsService implements ProductsServiceInterface {

	@Autowired
	ProductsRepository repositry;
	
	public ProductsService() {
	}

	@Override
	public List<Products> getProductsList() {
		return (List<Products>) repositry.findAll();
	}

	@Override
	public Products saveProducts(Products products) {
		repositry.save(products);
		return products;
	}

	@Override
	public Optional<Products> searchProducts(BigDecimal productId) {
		return repositry.findById(productId);
	}

	@Override
	public int deleteProducts(BigDecimal productId) {
		return 0;
	}

	@Override
	public Products updateCategories(Products products) {
		return null;
	}

	@Override
	public List<Products> getProductsListByCategory(Categories category) {
		return repositry.findByCategory(category);
	}

}
