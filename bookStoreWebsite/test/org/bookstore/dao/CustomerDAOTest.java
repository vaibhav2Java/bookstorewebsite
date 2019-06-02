package org.bookstore.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
		customerDAO.close();
	}

	@Test
	public void testCreateCustomer() {
		Customer newcustomer = new Customer();
		newcustomer.setEmail("vaibhav@gmail.com");
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
		Customer customer = customerDAO.get(1);
		customer.setFirstName("vaibhav");
		customer.setLastName("Bhatnagar");
		Customer update = customerDAO.update(customer);
		System.out.println(update.getFirstName());
		assertTrue(update.getFirstName().equals("vaibhav"));
		
	}
	
	@Test
	public void testGet() {
		Integer id = 5;
		Customer customer = customerDAO.get(id);
		assertNotNull(customer);
	
	}
	
	@Test
	public void testDeleteCustomer() {
		Integer id = 5;
		customerDAO.delete(id);
		Customer customer = customerDAO.get(id);
		assertNull(customer);
	}
	
	@Test
	public void testListAll() {
		List<Customer> listAllCustomer = customerDAO.listAll();
		assertTrue(listAllCustomer.size()>0);
	}
	
	@Test
	public void testCount() {
		long count = customerDAO.count();
		assertTrue(count>0);
	}
	
	@Test
	public void testFindByEmail() {
		String email = "vaibhavbhatnagar96@gmail.com";
		Customer findByEmail = customerDAO.findByEmail(email);
		System.out.println(findByEmail.getFirstName());
		assertNotNull(findByEmail);
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email = "vaibhav26bhatnagar@gmail.com";
		String password = "abc";
		Customer checkLogin = customerDAO.checkLogin(email, password);
		System.out.println(checkLogin.getFirstName());
		assertNotNull(checkLogin);
		

	} 
}