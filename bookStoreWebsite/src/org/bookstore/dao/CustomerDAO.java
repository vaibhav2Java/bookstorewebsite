package org.bookstore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bookstore.entity.Customer;

public class CustomerDAO extends JpaDAO<Customer> implements GenericDAO<Customer> {

	public CustomerDAO() {
	}

	@Override
	public Customer create(Customer customer) {
		customer.setRegisterDate(new Date());
		Customer create = super.create(customer);
		return create;
	}

	@Override
	public Customer update(Customer customer) {
		return super.update(customer);
	}

	@Override
	public Customer get(Object id) {
		return super.find(Customer.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Customer.class, id);
	}

	@Override
	public List<Customer> listAll() {
		return super.findwithNamedQuery("Customer.findAll");
	}

	@Override
	public long count() {
		return super.countwithNamedQuery("Customer.countAll");
	}
	
	public Customer findByEmail(String email) {
		List<Customer> result = super.findwithNamedQuery("Customer.findByEmail", "email", email);
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

	public Customer checkLogin(String email, String password) {
		Map <String,Object> parameter= new HashMap<>();
		parameter.put("email", email);
		parameter.put("password", password);
		List<Customer> list = super.findwithNamedQuery("Customer.checkLogin", parameter);
		if(!list.isEmpty()) {
			return list.get(0);
		}
		return null;		
	} 

}
