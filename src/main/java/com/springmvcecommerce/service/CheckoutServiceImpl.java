package com.springmvcecommerce.service;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvcecommerce.dao.CustomerDAO;
import com.springmvcecommerce.dto.Purchase;
import com.springmvcecommerce.dto.PurchaseResponse;
import com.springmvcecommerce.entity.Customer;
import com.springmvcecommerce.entity.Order;
import com.springmvcecommerce.entity.OrderItem;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	@Autowired
	CustomerDAO customerDAO;

	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		// retreive the order info from the dto
		Order order = purchase.getOrder();
		// generate a random/unique tracking number : UUID (unique universel identifier
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);

		// populate order with orderItems
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));

		// populate order with shippingAddress/billingAddress
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());

		// populate customer with the order
		Customer customer = purchase.getCustomer();
		customer.add(order);

		// save all to data base
		customerDAO.saveCustomer(customer);

		return new PurchaseResponse(orderTrackingNumber);
	}

	private String generateOrderTrackingNumber() {
		return UUID.randomUUID().toString();

	}

}
