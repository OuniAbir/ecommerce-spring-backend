package com.springmvcecommerce.dao;

import java.util.List;

import com.springmvcecommerce.entity.State;


public interface StateDAO {

	public List<State> getStates();
	public List<State> findByCountryCode(String Code);
}
