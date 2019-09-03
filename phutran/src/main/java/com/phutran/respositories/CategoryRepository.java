package com.phutran.respositories;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.phutran.entities.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category>{
	//Test Supported query keywords with Spring data JPA
	
	//Use And
	List<Category> findAllCategoryByNameLikeAndStatusEquals(String name, Boolean status);
	
	//Use method name by name
	Category getCategoryByName(String name);

}
