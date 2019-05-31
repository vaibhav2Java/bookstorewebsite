package org.bookstore.service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bookstore.dao.CustomerDAO;
import org.bookstore.entity.Customer;

public class CustomerService {
	private CustomerDAO customerDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	public CustomerService(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response= response;
		customerDAO = new CustomerDAO();
	}
	
	public void listCustomers() throws ServletException, IOException {
		listCustomers(null);
	}

	public void listCustomers(String message) throws ServletException, IOException {
		List<Customer> listAllCustomers = customerDAO.listAll();
		if (message != null) {
			request.setAttribute("message", message);
		}
		request.setAttribute("listAllCustomers", listAllCustomers);		
		String listPath = "customer_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPath);
		requestDispatcher.forward(request, response);
	}

	public void deleteCustomer() throws ServletException, IOException {
		String message = null;
		Integer customerId = Integer.parseInt(request.getParameter("customerId"));
		Customer customer = customerDAO.get(customerId);
		if(customer == null) {
			message = "Could not found the Customer with exiting ID " + customerId + " or the customer is already deleted BY Another Admin.";
		}else {
			customerDAO.delete(customerId);
			message = "Customer deleted Successfully.";
		}
		listCustomers(message);
	}

	public void createCustomer() throws ServletException, IOException {
		String email = request.getParameter("email");
		String message= null;
		Customer existCustomer = customerDAO.findByEmail(request.getParameter("email"));
		if (existCustomer != null) {
			message = "Could not create a customer. A customer is already exists with this email " +email;
		}else {
			Customer customer = new Customer();
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String country = request.getParameter("country");
			String phone = request.getParameter("phone");
			String password = request.getParameter("password");
			String pincode = request.getParameter("pincode");
			customer.setEmail(email);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setAddress(address);
			customer.setCity(city);
			customer.setCountry(country);
			customer.setPhone(phone);
			customer.setPassword(password);
			customer.setPincode(pincode);
			customerDAO.create(customer);
			message = "Customer "+firstName+" "+lastName+" Created Successfully.";
		}
		listCustomers(message);
	}

	public void editCustomer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("customerId")); 
		Customer customer = customerDAO.get(customerId);
		if(customer != null) {
			request.setAttribute("customer", customer);
			String updateForm = "customer_form.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(updateForm);
			requestDispatcher.forward(request, response);
		}else {
			String message = "Could not found the Customer with exiting ID " + customerId + " or the customer is already deleted";
			listCustomers(message);
		}
	}

	public void updateCustomer() throws ServletException, IOException {
		String message=null;
		Integer customerId = Integer.parseInt(request.getParameter("customerId"));
		String email = request.getParameter("email");
		
		Customer customerByEmail = customerDAO.findByEmail(request.getParameter("email"));
		if (customerByEmail != null && customerByEmail.getCustomerId() != customerId) {
		 message = "Could not update a customer with ID. " +customerId+ " because a customer is already exists with this email " +email;
		}else {
			Customer customerById = customerDAO.get(customerId);
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String country = request.getParameter("country");
			String phone = request.getParameter("phone");
			String password = request.getParameter("password");
			String pincode = request.getParameter("pincode");
			customerById.setCustomerId(customerId);
			customerById.setEmail(email);
			customerById.setFirstName(firstName);
			customerById.setLastName(lastName);
			customerById.setAddress(address);
			customerById.setCity(city);
			customerById.setCountry(country);
			customerById.setPhone(phone);
			customerById.setPassword(password);
			customerById.setPincode(pincode);
			customerDAO.update(customerById);
			message = "Customer "+firstName+" "+lastName+" updated Successfully.";
	}
		listCustomers(message);
	}

	public void registerCustomer() throws ServletException, IOException {
		String email = request.getParameter("email");
		String message= null;
		Customer existCustomer = customerDAO.findByEmail(request.getParameter("email"));
		if (existCustomer != null) {
			message = "Could not Register a customer. A customer is already registered with this email " +email;
		}else {
			Customer customer = new Customer();
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String country = request.getParameter("country");
			String phone = request.getParameter("phone");
			String password = request.getParameter("password");
			String pincode = request.getParameter("pincode");
			customer.setEmail(email);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setAddress(address);
			customer.setCity(city);
			customer.setCountry(country);
			customer.setPhone(phone);
			customer.setPassword(password);
			customer.setPincode(pincode);
			customerDAO.create(customer);
			message = "You have  Registered Successfully ! Thank You!!. </br>" 
			+"<a href='login'>Click Here <a> for Login<a>";
		}
		request.setAttribute("message", message);
		String messagePage = "frontend/message.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(messagePage);
		requestDispatcher.forward(request, response);

	}
}
