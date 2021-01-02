package com.springmvcecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvcecommerce.dao.StateDAO;
import com.springmvcecommerce.entity.State;

@RestController
@RequestMapping("/api")
public class StateController {

	@Autowired
	StateDAO stateDAO ;
	
	@GetMapping("/states")
	public List<State> getStates() {
		return stateDAO.getStates();
	}
	
	@GetMapping("/states/search/findByCountryCode")
	@ResponseBody
	public List<State> findByCountryCode(@RequestParam(value = "code", required = true) String code) {
		return stateDAO.findByCountryCode(code);
	}
}
