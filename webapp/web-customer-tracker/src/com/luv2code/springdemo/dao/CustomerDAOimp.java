package com.luv2code.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOimp implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session=sessionFactory.getCurrentSession();
		
		Query<Customer> theCustomers=session.createQuery("from Customer",Customer.class);
		
		List<Customer> customers=theCustomers.getResultList();
		
		return customers;
	}

	public void saveCustomer(Customer theCustomer) {
		Session session=sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		Session session=sessionFactory.getCurrentSession();
		Customer theCustomer=session.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session session=sessionFactory.getCurrentSession();
		
	//	session.delete(theId);
		
		Query theQuery=session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId",theId);
		theQuery.executeUpdate();
	}

}
