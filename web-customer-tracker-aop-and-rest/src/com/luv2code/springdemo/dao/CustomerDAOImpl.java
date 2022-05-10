package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//don't use org.hibernate.Query
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.util.SortUtils;

//Translates checked exceptions into unchecked exceptions
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	//Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers(int sortField) {
		
		//get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		String sortFieldName = null;
		
		switch (sortField) {
			case SortUtils.FIRST_NAME:
				sortFieldName = "firstName";
				break;
			case SortUtils.LAST_NAME:
				sortFieldName = "lastName";
				break;
			case SortUtils.EMAIL:
				sortFieldName = "email";
				break;
			default:
				sortFieldName = "lastName";
		}
		
		//create a query ... sort by last name
		Query<Customer> query = session.createQuery("from Customer order by "
			+ sortFieldName	, Customer.class);
		
		//execute the query
		List<Customer> customers = query.getResultList();
		
		//return list of customers
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		//get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		//get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//retrieve customer by primary key
		Customer customer = session.get(Customer.class, id);
				
		return customer;	
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query =
			session.createQuery("delete from Customer where id=:customerId");
		
		query.setParameter("customerId", id);
		
		//delete customer by primary key
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String searchName) {
	    // get the current hibernate session
        Session session = sessionFactory.getCurrentSession();
        
        Query query = null;

        // only search by name if searchName is not empty
        if (searchName != null && searchName.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
        	query = session.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name", Customer.class);
        	query.setParameter("name", "%" + searchName.toLowerCase() + "%");
        }
        else {
            // searchName is empty ... so just get all customers
            query = session.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = query.getResultList();
                
        // return the results        
        return customers;
	}

}
