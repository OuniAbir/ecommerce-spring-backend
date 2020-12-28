package com.springmvcecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springmvcecommerce.dao.ProductCategoryDAO;
import com.springmvcecommerce.entity.ProductCategory;

@CrossOrigin(origins="http://localhost:4200")  
@RestController
public class ProductCategoryController {
	
	@Autowired
	private ProductCategoryDAO productCategoryDAO;
	
	@GetMapping("/product-category")
	public List<ProductCategory> getProductCategories() { 
		return productCategoryDAO.getProductCategories();
	}
	
	@GetMapping("/product-category/{id}")
	public ProductCategory getProductCategoryById(@PathVariable Long id) {
		
		return productCategoryDAO.getProductCategoryById(id);
		
	}
	
}
