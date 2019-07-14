package com.anna.controller.categories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anna.boinerface.categories.CategoriesServiceInterface;
import com.anna.component.categories.Categories;

@RestController
//@CrossOrigin(origins = "http://192.168.10.165:4200", allowedHeaders = "*")
// @CrossOrigin(origins = "http://192.168.10.165:8082", allowedHeaders = "*") Tomacat
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

// @CrossOrigin(origins = "http://192.168.8.105:4200", allowedHeaders = "*")

@RequestMapping(value = "/categories")
public class CategoriesController {
// 192.168.10.164:9991/categories/productCategoriesList
	Categories categories;
	
	@Autowired
	CategoriesServiceInterface categoriesService;
	
	List<Categories> categoriesList = new ArrayList<Categories>();

	public CategoriesController() {
		System.out.println("*** CategoriesController ***");
	}

	
	
//	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@RequestMapping(value = "/productCategoriesList")
	public List<Categories> categoriesList() {
		// write the code to get all employees from DAO
		// here, we are writing manual code of list for easy understanding
		System.out.println("i am in CategoriesController in main Controllar");
		List<Categories> categoriesList = categoriesService.getCategoriesList();
		System.out.println("User List Size in Controller: " + categoriesList.size());
		return categoriesList;
	}
	
	
}
