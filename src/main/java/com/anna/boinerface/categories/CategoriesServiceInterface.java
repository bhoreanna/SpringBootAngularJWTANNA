package com.anna.boinerface.categories;

import java.util.List;
import java.util.Optional;

import com.anna.component.categories.Categories;

public interface CategoriesServiceInterface {

	
	public List<Categories> getCategoriesList();
	public Categories saveCategories(Categories categories);
	public Optional<Categories> searchCategories(String categoryId);
	public int deleteCategories(String categoryId);
	public Categories updateCategories(Categories categories);
}
