package org.bookstore.dao;

import java.util.Date;
import java.util.List;

import org.bookstore.entity.Customer;

public class CustomerDAO extends JpaDAO<Customer> implements GenericDAO<Customer> {

	public CustomerDAO() {
	}

	@Override
	public Customer create(Customer customer) {
		System.out.println("CustomerDao Create Method:"+"Email" +customer.getEmail()+ "firstName" +customer.getFirstName()+ "LastName" +customer.getLastName());
		customer.setRegisterDate(new Date());
		Customer create = super.create(customer);
		System.out.println("Size:" +create.toString());
		return create;
	}

	@Override
	public Customer update(Customer t) {
		return null;
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
		
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

}
