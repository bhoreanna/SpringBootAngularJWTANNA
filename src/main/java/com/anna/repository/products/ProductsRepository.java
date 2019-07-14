package com.anna.repository.products;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anna.component.categories.Categories;
import com.anna.component.products.Products;

@Repository
public interface ProductsRepository extends CrudRepository<Products , BigDecimal>{
	public List<Products> findByCategory(Categories category); 
}
