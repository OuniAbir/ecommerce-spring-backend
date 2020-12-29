package com.springmvcecommerce.dao;

import java.util.List;

import com.springmvcecommerce.entity.Product;

public interface ProductDAO {

	public List<Product> getProducts();
	public Product getProductById(Long id);
	public List<Product> findByCategoryid(Long categoryid);
	public List<Product> findByNameContaining(String name);
	
}
