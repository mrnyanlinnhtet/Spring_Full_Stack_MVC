package com.ultron.mvc.controller.advices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ultron.dto.Category;
import com.ultron.root.services.CategoryService;

@RestControllerAdvice
public class CategoryAdvice {

	@Autowired
	private CategoryService categoryService;

	@ModelAttribute("categories")
	public List<Category> categories() {
		return categoryService.getAll();
	}

}
