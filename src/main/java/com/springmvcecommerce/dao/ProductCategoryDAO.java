package com.springmvcecommerce.dao;

import java.util.List;

import com.springmvcecommerce.entity.ProductCategory;

public interface ProductCategoryDAO {

	public List<ProductCategory> getProductCategories();
	public ProductCategory getProductCategoryById(Long id);
	
}
