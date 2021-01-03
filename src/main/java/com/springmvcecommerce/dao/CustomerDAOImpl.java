package com.springmvcecommerce.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvcecommerce.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public void saveCustomer(Customer customer) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
	}

}
