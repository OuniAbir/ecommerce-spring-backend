package com.springmvcecommerce.dao;

import java.util.List;

import com.springmvcecommerce.entity.Country;

public interface CountryDAO {
	public List<Country> getCountries();
	public Country getCountryById(int id);
}
