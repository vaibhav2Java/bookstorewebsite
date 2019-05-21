package org.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bookstore.dao.UserDao;
import org.bookstore.entity.Users;

public class UserServices {

	private UserDao userDao;
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;


	public UserServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		super();


		this.request = request;
		this.response = response;
		this.entityManager= entityManager;
		userDao = new UserDao(entityManager);
	
	
	}

	public void listUser() throws ServletException, IOException {
		listUser(null);

	}

	public void listUser(String message) throws ServletException, IOException {
		List<Users> listUsers = userDao.listAll();
		request.setAttribute("listUsers", listUsers);
		if (message != null) {
			request.setAttribute("message", message);
		}
		String list = "user_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(list);
		dispatcher.forward(request, response);

	}

	public void createUser() throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Users exitUser = userDao.findByeEmail(email);
		if(exitUser != null) {
			String errorMessage ="Could not Create User. A User with email " +email+ " already exists.";
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		}else {
			Users newUser = new Users(firstName, lastName, email, password);
			userDao.create(newUser);
			listUser("New User Created Successfully!");
		}
	}

	public void editUser() throws ServletException, IOException {

		Integer userId= Integer.parseInt(request.getParameter("id"));
		Users user = userDao.get(userId);
		String editPage="user_form.jsp";
		request.setAttribute("user", user);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
		
	}

	public void updateUser() throws ServletException, IOException {
		Integer userId= Integer.parseInt(request.getParameter("userId"));
		String email=request.getParameter("email");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String password=request.getParameter("password");
		
		Users userbyId=userDao.get(userId);
		
		Users userbyEmail=userDao.findByeEmail(email);
		
		if(userbyEmail != null && userbyEmail.getUserId() != userbyId.getUserId()) {
			String message="Could not update the User!! with email " +email +" already Exists." ;
			request.setAttribute("errorMessage", message);		
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		
			
		}else {
			Users user = new Users(userId, email, firstName, lastName, password);
			userDao.update(user);
			String message="User has been Updated Successfully!";
			listUser(message);
		}		
	}

	public void deleteUser() throws ServletException, IOException {
		
		Integer userId=Integer.parseInt(request.getParameter("id"));
		System.out.println(userId);
		userDao.delete(userId);
		String message="User Deleted Successfully!";
		listUser(message);
		
	}

	public void checkLogin() throws ServletException, IOException {
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		
		
		boolean loginresult = userDao.checkLogin(email, password);
		if (loginresult) {
			System.out.println("User Is authenticated");
			request.getSession().setAttribute("useremail",email);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/");
			requestDispatcher.forward(request, response);
		}else {
			
			String message = "login failed with wrong credentials.";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
			System.out.println("login failed");
		}
	}

}
