package com.anna.controller.products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anna.boinerface.products.ProductsServiceInterface;
import com.anna.component.categories.Categories;
import com.anna.component.products.Prod;
import com.anna.component.products.Products;
import com.anna.exception.ExceptionHandling;

@RestController
//@CrossOrigin(origins = "http://192.168.10.165:4200", allowedHeaders = "*")

//@CrossOrigin(origins = "http://192.168.10.165:8082", allowedHeaders = "*") //Tomcat
// @CrossOrigin(origins = "http://192.168.8.105:4200", allowedHeaders = "*")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

@RequestMapping(value = "/products")
public class ProductsController {

	Products products;
	@Autowired
	ProductsServiceInterface productsService;
	public ProductsController() {
	}

	// 192.168.10.164:9991/products/productsList
//	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@RequestMapping(value = "/productsList")
	public List<Products> productsList() {
		System.out.println(" productsList in main Controllar: ");
		List<Products> productsList = productsService.getProductsList();
		System.out.println("productsList List Size in Controller: " + productsList.size());
		
		for (Products products : productsList) {
			System.out.println("********************* Product List ***************");
			System.out.println("Product ProductId: "+products.getProductId());
			products.setCategoryId(products.getCategory().getCategoryId());
			
			System.out.println("Product Name: "+products.getTitle());
			System.out.println("Category Name: "+products.getCategory().getCategoryId());
			
		}
		
		System.out.println("productsList: " + productsList);
		
		return productsList;
	}
	
	
//	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public boolean saveProduct(@RequestBody Prod products) {
		System.out.println("**************************************************************");
		System.out.println("Save Product Object: " + products);
		Products productNew  =new Products();
		productNew.setTitle(products.getTitle());
		productNew.setImageUrl(products.getImageUrl());
		productNew.setPrice(products.getPrice());
		Categories categories = new Categories();
		categories.setCategoryId(products.getCategoryId());
		productNew.setCategory(categories);
		System.out.println("////////////////// Before Saving Product Object //////////////");
		System.out.println("New Products: "+productNew );
		productsService.saveProducts(productNew);
		return true;
	}
	
	
	
	
	// @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@RequestMapping(value = "/getProduct", method = RequestMethod.POST)
	public Optional<Products>  getProductr(@RequestBody BigDecimal productId) throws ExceptionHandling  {
		System.out.println("<-- Product Id -->" + productId);
		
		Optional<Products> products = productsService.searchProducts(productId);
		System.out.println("*****************Get User From /DB Products*************  "+products);
		
		if(products.isPresent()) {
		  // String fruitName = first.get().getName(); //apple
			products.get().setCategoryId(products.get().getCategory().getCategoryId());
		}
		
		    System.out.println("-----------------Response Return---------------");

		    return products;
		
	}
	
	

	
	@RequestMapping(value = "/getProductByCategoryId/{categoryId}")
	public List<Products> getProductByCategoryId(@PathVariable(name="categoryId")String categoryId) {
		System.out.println("I am in ScreenMasterListByModuleUid  Controllar categoryId: " + categoryId);
		List<Products> productsList = new ArrayList<Products>();
		 Categories category = new Categories();
		 category.setCategoryId(categoryId);
		 System.out.println("getCategoryId: " +category.getCategoryId());
		 productsList = productsService.getProductsListByCategory(category);
		 for (Products products : productsList) {
			 products.setCategoryId(products.getCategory().getCategoryId());
		}
		return productsList;
	}
	
	
}
