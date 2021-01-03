package com.springmvcecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvcecommerce.dto.Purchase;
import com.springmvcecommerce.dto.PurchaseResponse;
import com.springmvcecommerce.service.CheckoutService;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
	
	
	@Autowired
	CheckoutService checkoutService ;
	
	@PostMapping("/purchase")
	public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
		
		PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase) ;
		return purchaseResponse;
		
	}

}
