package com.springmvcecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvcecommerce.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Product> getProducts() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create query ... sort by last Name
		Query<Product> theQuery = currentSession.createQuery("from Product ", Product.class);

		// excute the query
		List<Product> products = theQuery.getResultList();

		// return results
		return products;
	}

	@Transactional
	public Product getProductById(Long id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retreive/read from database using the primary key
		Product product = currentSession.get(Product.class, id);

		return product;
	}

	@Transactional
	public List<Product> findByCategoryid(Long categoryid) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create query  
		Query<Product> theQuery = currentSession.createQuery("from Product where  category.id=:categoryid", Product.class);
 
		theQuery.setParameter("categoryid", categoryid);
		
		// excute the query
		List<Product> products = theQuery.getResultList();

		// return results
		return products;
	}

}
