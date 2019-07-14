package com.anna.repository.categories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anna.component.categories.Categories;

@Repository
public interface CategoriesRepository extends CrudRepository<Categories , String>{

	

}
