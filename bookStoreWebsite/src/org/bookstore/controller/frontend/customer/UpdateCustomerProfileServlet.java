package org.bookstore.controller.frontend.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bookstore.service.CustomerService;

@WebServlet("/edit_myprofile")
public class UpdateCustomerProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCustomerProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CustomerService customerService = new CustomerService(req, resp);
		customerService.updateCustomerProfile();
	}

}
