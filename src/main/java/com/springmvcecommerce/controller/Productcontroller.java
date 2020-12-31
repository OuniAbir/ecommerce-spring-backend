package com.springmvcecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvcecommerce.dao.ProductDAO;
import com.springmvcecommerce.entity.Product;

@CrossOrigin(origins="http://localhost:4200")  
@RestController
@RequestMapping("/api")
public class Productcontroller  {

	@Autowired
	private ProductDAO productDAO;

	@GetMapping("/hello")
	public String getHello() {
		return "hello ";
	}
	@GetMapping("/products")
 	public List<Product> getProducts() { 
		return productDAO.getProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productDAO.getProductById(id);
	}
	
	@GetMapping("/products/search/findByCategoryid")
	@ResponseBody
	public List<Product> findByCategoryid(@RequestParam(value = "Categoryid", required = true) Long Categoryid)
	{
		return productDAO.findByCategoryid(Categoryid);
		
	}
	
	@GetMapping("/products/search/findByNameContaining")
	@ResponseBody
	public List<Product> findByNameContaining(@RequestParam(value = "name", required = true) String name){
		return productDAO.findByNameContaining(name);
		
	}

	
}
