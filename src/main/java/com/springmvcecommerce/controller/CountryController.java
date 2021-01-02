package com.springmvcecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvcecommerce.dao.CountryDAO;
import com.springmvcecommerce.entity.Country;

@CrossOrigin(origins="http://localhost:4200")  
@RestController
@RequestMapping("/api")
public class CountryController {
	
	@Autowired
	CountryDAO countryDAO ;
	
	
	@GetMapping("/countries")
	public List<Country> getCountries(){
		return countryDAO.getCountries();
	}
	
	@GetMapping("/countries/{theCountryId}")
	public Country  getCountryById(@PathVariable int theCountryId) {
		return countryDAO.getCountryById(theCountryId);
	
	}

}
