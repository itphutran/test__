package com.phutran.services;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.itphutran.exceptions.DataNullException;
import com.phutran.entities.Category;
import com.phutran.respositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Long save(Category category) throws DataNullException {
		return categoryRepository.save(category).getId();
	}

	@Override
	public List<Category> findAllSearchByName(String name) {
		//Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder
		/*
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Office> query =  builder.createQuery(Office.class);
		Root<Office> root = query.from(Office.class);
		query.select(root);
		CriteriaBuilder: Để xây dựng một câu query, các bạn sẽ cần tới interface CriteriaBuilder, 
		mục đích của nó là giúp tạo ra đối tượng chứa câu lệnh truy vấn CriteriaQuery và cung cấp cơ số các phép biến đổi, 
		phép logic, điều kiện cho câu lệnh (and, or, not, avg, greater than,v.v...)
		CriteriaQuery: Đối tượng chính của chúng ta đây, 
		nó được tạo ra bởi builder.createQuery(Office.class). 
		Mục đích là khai báo đối tượng bạn muốn lấy ra sau khi thực hiện query. Nó tương đương với đoạn ngoặc đơn ở dưới đây:
		Root: root là khai báo đối tượng bạn sẽ sử dụng trong query, tương đương với đối tượng sau mệnh đề 	
		*/
		Specification<Category> specification = (root, query, cb) -> {
	         query.select(root.get("name"));
	         return query.multiselect(root.get("id")).where(cb.like(root.get("name"), "%" + name + "%")).getRestriction();
			//return cb.like(root.get("name"), "%" + name + "%") ;
		};
		
		return categoryRepository.findAll(specification);
	}

	@Override
	public Category getCategoryById(Long id) throws DataNullException{
		return categoryRepository.findById(id).get();
	}

	@Override
	public List<Category> findAllCategoryByNameLikeAndStatusEquals(String name, Boolean status) {
		return categoryRepository.findAllCategoryByNameLikeAndStatusEquals("%"+name+"%", status);
	}

	@Override
	public Category getCategoryByName(String name) {
		return categoryRepository.getCategoryByName(name);
	}
}
