package org.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bookstore.dao.CategoryDAO;
import org.bookstore.entity.Category;



public class CategoryServices {
	private EntityManager entityManager;
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	public CategoryServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		categoryDAO = new CategoryDAO(entityManager);
	}
	
	public void listCategory( ) throws ServletException, IOException {
		listCategory(null);
	
	}
	

	public void listCategory( String message) throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();
		request.setAttribute("listCategory", listCategory);
		if (message != null) {
			request.setAttribute("message", message);
		}
		String list = "category_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(list);
		dispatcher.forward(request, response);

	}

	public void createCategory() throws ServletException, IOException {
		System.out.println("Category Service Create CategoryMethod!");
		
		String categoryName = request.getParameter("categoryName");
		Category findByName = categoryDAO.findByName(categoryName);
		if (findByName != null ) {
			String errormessage ="Could not create category!" + categoryName +" is already exists.";
			request.setAttribute("errorMessage", errormessage);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		}else{
			Category cat = new Category(categoryName);
			categoryDAO.create(cat);
			String message ="Category " + categoryName +" has been create Successfully.";
			listCategory(message);
		}
		
		
	}

	public void deleteCategory() throws ServletException, IOException {
		Integer categoryId=Integer.parseInt(request.getParameter("id"));
		categoryDAO.delete(categoryId);
		String message="User Deleted Successfully!";
		listCategory(message);
		
	}

	public void editCategory() throws ServletException, IOException {
		Integer categoryId= Integer.parseInt(request.getParameter("id"));
		Category category = categoryDAO.get(categoryId);
		String editPage="category_form.jsp";
		request.setAttribute("category", category);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	public void updateCategory() {
		
		Integer categoryId= Integer.parseInt(request.getParameter("categoryId"));
		String CategoryName = request.getParameter("categoryName");
		Category categorybyId = categoryDAO.get(categoryId);
		
//		
//		
//		if(userbyEmail != null && userbyEmail.getUserId() != userbyId.getUserId()) {
//			String message="Could not update the User!! with email " +email +" already Exists." ;
//			request.setAttribute("errorMessage", message);		
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
//			requestDispatcher.forward(request, response);
//		
//			
//		}else {
//			Category category = new Category(categoryName);
//			Users user = new Users(userId, email, firstName, lastName, password);
//			userDao.update(user);
//			String message="User has been Updated Successfully!";
//			listUser(message);
//		}
	}
}