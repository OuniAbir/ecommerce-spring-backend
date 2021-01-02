package com.springmvcecommerce.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvcecommerce.entity.State;

@Repository
public class StateDAOImpl implements StateDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<State> getStates() {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<State> theQuery = currentSession.createQuery("From State", State.class);
		List<State> states = theQuery.getResultList();
		return states;
	}

	@Transactional
	public List<State> findByCountryCode(String Code) {
		Session currentSession = sessionFactory.getCurrentSession();
		// create query
		Query<State> theQuery = currentSession.createQuery("from State where country.code=:countryCode", State.class);
		theQuery.setParameter("countryCode", Code);
		List<State> states = theQuery.getResultList();
		return states;
	}

}
