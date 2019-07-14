package com.anna;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.anna.boinerface.categories.CategoriesServiceInterface;
import com.anna.component.categories.Categories;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnaSpringBootAngularApplicationTests {
	@Autowired
	CategoriesServiceInterface categoriesService;
	@Test
	public void contextLoads() {
	}
	
	public void getCategory() {
		List<Categories> categoriesList = categoriesService.getCategoriesList();
		System.out.println("categoriesList: " +categoriesList);
		 
	}

}
