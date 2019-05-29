package org.bookstore.dao;

import static org.junit.Assert.assertTrue;

import org.bookstore.entity.Customer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerDAOTest {
	
	private static CustomerDAO customerDAO;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customerDAO = new CustomerDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		customerDAO.close();
	}

	@Test
	public void testCreateCustomer() {
		Customer newcustomer = new Customer();
		newcustomer.setEmail("vaibhavbhatnagar96@gmail.com");
		newcustomer.setFirstName("gmail");
		newcustomer.setLastName("google");
		newcustomer.setPhone("80******");
		newcustomer.setPincode("209111");
		newcustomer.setAddress("*******");
		newcustomer.setCity("Kanpur ");
		newcustomer.setCountry("India");
		newcustomer.setPassword("1234");
		Customer create = customerDAO.create(newcustomer);
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