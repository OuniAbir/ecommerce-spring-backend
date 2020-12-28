package com.springmvcecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvcecommerce.entity.ProductCategory;

@Repository
public class ProductCategoryDAOImpl implements ProductCategoryDAO {
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<ProductCategory> getProductCategories() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create query ... sort by last Name
		Query<ProductCategory> theQuery = currentSession.createQuery("from ProductCategory ", ProductCategory.class);

		// excute the query
		List<ProductCategory> productCategory = theQuery.getResultList();

		// return results
		return productCategory;
	}

	@Transactional
	public ProductCategory getProductCategoryById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();

		// now retreive/read from database using the primary key
		ProductCategory productCategory = currentSession.get(ProductCategory.class, id);

		return productCategory;
	}

}
