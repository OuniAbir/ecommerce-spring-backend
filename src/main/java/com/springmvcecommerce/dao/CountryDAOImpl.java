package com.springmvcecommerce.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvcecommerce.entity.Country;

@Repository
public class CountryDAOImpl implements CountryDAO {

	@Autowired
	SessionFactory sessionFactory ;


	
	@Transactional
	public List<Country> getCountries() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Country> theQuery = currentSession.createQuery("From Country" , Country.class);
		List<Country> countries = theQuery.getResultList();
		return countries;
	}

	@Transactional
	public Country getCountryById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Country theCountry  = currentSession.get(Country.class, id);
		return theCountry;
	}

}
