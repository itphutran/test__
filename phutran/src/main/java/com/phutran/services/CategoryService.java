package com.phutran.services;

import java.util.List;

import com.itphutran.exceptions.DataNullException;
import com.phutran.entities.Category;

public interface CategoryService {
	List<Category> findAll();

	List<Category> findAllSearchByName(String name);

	Long save(Category category) throws DataNullException;
	
	Category getCategoryById(Long id)  throws DataNullException;
	
	List<Category> findAllCategoryByNameLikeAndStatusEquals(String name, Boolean status);
	
	Category getCategoryByName(String name);
}
