package com.springmvcecommerce.service;

import com.springmvcecommerce.dto.Purchase;
import com.springmvcecommerce.dto.PurchaseResponse;

public interface CheckoutService {
	PurchaseResponse placeOrder(Purchase purchase);

}
