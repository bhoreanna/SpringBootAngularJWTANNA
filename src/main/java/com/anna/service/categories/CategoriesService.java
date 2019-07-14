package com.anna.service.categories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anna.boinerface.categories.CategoriesServiceInterface;
import com.anna.component.categories.Categories;
import com.anna.repository.categories.CategoriesRepository;

@Service
public class CategoriesService implements CategoriesServiceInterface {

	@Autowired
	CategoriesRepository repository;
	
	public CategoriesService() {
	}

	@Override
	public List<Categories> getCategoriesList() {
		 return (List<Categories>)repository.findAll() ;
	}

	@Override
	public Categories saveCategories(Categories categories) {
		return null;
	}

	@Override
	public Optional<Categories> searchCategories(String categoryId) {
		return null;
	}

	@Override
	public int deleteCategories(String categoryId) {
		return 0;
	}

	@Override
	public Categories updateCategories(Categories categories) {
		return null;
	}

}
