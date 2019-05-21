package org.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bookstore.dao.BookDAO;
import org.bookstore.dao.CategoryDAO;
import org.bookstore.entity.Book;
import org.bookstore.entity.Category;

public class BookService {
	
	private EntityManager entityManager;
	private BookDAO bookDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public BookService(EntityManager entityManager,HttpServletRequest request,HttpServletResponse response) {
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		bookDAO = new BookDAO(entityManager);
	}
	
	public void listBooks( ) throws ServletException, IOException {
		listBooks(null);
	}

	public void listBooks(String message) throws ServletException, IOException {
		
		List<Book> listbooks = bookDAO.listAll();
		request.setAttribute("listbooks", listbooks);
		if (message != null) {
			request.setAttribute("message", message);
		}
		String booklist = "book_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(booklist);
		dispatcher.forward(request, response);

	}

		
}