package org.bookstore.dao;

import static org.junit.Assert.*;

import org.bookstore.entity.Customer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerDAOTest extends BaseDaotest {
	public static CustomerDAO customerDAO;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDaotest.setUpBeforeClass();
		customerDAO = new CustomerDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDaotest.tearDownAfterClass();
	}

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setEmail("metooo@gmail.com");
		customer.setFirstName("xyz");
		customer.setLastName("mno");
		customer.setPhone("9170203426");
		customer.setPincode("209111");
		customer.setAddress("A-114 2nd floor");
		customer.setCity("new deldi");
		customer.setCountry("India");
		customer.setPassword("zbc");
		Customer create = customerDAO.create(customer);
		assertTrue(create.getCustomerId() > 0);
	}

	@Test
	public void testUpdateCustomer() {
	}

	@Test
	public void testGet() {
	}

	@Test
	public void testDeleteObject() {
	}

	@Test
	public void testListAll() {
	}

}