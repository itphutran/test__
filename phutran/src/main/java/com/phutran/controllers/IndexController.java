package com.phutran.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itphutran.exceptions.DataNullException;
import com.phutran.entities.Category;
import com.phutran.entities.Tag;
import com.phutran.services.CategoryServiceImpl;

@Controller
@RequestMapping("category")
public class IndexController {
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	@GetMapping("index")
	public String index() {
		List<Category> listCat = categoryServiceImpl.findAll();
		System.out.println(listCat.size());
		System.out.println(listCat);
		return "index";
	}

	@GetMapping("{id}")
	public String getCategortById(@PathVariable Long id) {
		Category cat;
		try {
			cat = categoryServiceImpl.getCategoryById(id);
			System.out.println(cat);
		} catch (DataNullException e) {
			System.err.println("DataNullException with method get category");
		}
		return "index";
	}

	@GetMapping("index/{name}")
	public String indexUseSpecification(@PathVariable String name) {
		List<Category> listCat = categoryServiceImpl.findAllSearchByName(name);
		System.out.println(listCat.size());
		System.out.println(listCat);
		return "index";
	}
	
	@GetMapping("index/{name}/{status}")
	public String findAllLikeNameAndEqualsStatus(@PathVariable String name, @PathVariable Boolean status) {
		List<Category> listCat = categoryServiceImpl.findAllCategoryByNameLikeAndStatusEquals(name, status);
		System.out.println(listCat);
		return "index";
	}
	
	@GetMapping("getCategoryByName/{name}")
	public String findAllLikeNameAndEqualsStatus(@PathVariable String name) {
		Category cat = categoryServiceImpl.getCategoryByName(name);
		System.out.println(cat);
		return "index";
	}
	

	@GetMapping("add")
	public String add() {
		List<Tag> listTag = new ArrayList<Tag>();
		listTag.add(new Tag(0, "tagcat1"));
		listTag.add(new Tag(0, "tagcat2"));
		listTag.add(new Tag(0, "tagcat3"));
		Category category = new Category(0l, "Category test1", listTag, true);
		Long resultId = 0l;
		try {
			resultId = categoryServiceImpl.save(category);
		} catch (DataNullException e) {
			System.err.println("DataNullException with method add category");
		}
		System.out.println("Result insert have id : " + resultId);
		return "index";
	}
	
	/*@GetMapping("getNameAndId")
	public String getNameAndId() {
		List<Category> listCat = categoryServiceImpl.findByName();
		System.out.println(listCat);
		return "index";
	}*/
	
	
	
}
