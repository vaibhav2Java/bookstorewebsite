package org.bookstore.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.bookstore.dao.BookDAO;
import org.bookstore.dao.CategoryDAO;
import org.bookstore.entity.Book;
import org.bookstore.entity.Category;

public class BookService {

	private BookDAO bookDAO;
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public BookService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		bookDAO = new BookDAO();
		categoryDAO = new CategoryDAO();
	}

	public void listBooks() throws ServletException, IOException {
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

	public void createNewBook() throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();
		request.setAttribute("listCategory", listCategory);
		String newPage = "book_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(newPage);
		dispatcher.forward(request, response);

	}

	public void createBook() throws ParseException, IOException, ServletException {
		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		String description = request.getParameter("description");
		float price = Float.parseFloat(request.getParameter("price"));
		DateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
		Date publishDate = dateFormat.parse(request.getParameter("publishDate"));
		Book exitsBook = bookDAO.findByTitle(title);
		if (exitsBook != null && exitsBook.getBookId() > 0) {
			String message = "Could not Create the book " + title + " titled book is already present in database.";
			listBooks(message);
			return;
		}
		Book newBook = new Book();
		newBook.setTitle(title);
		newBook.setAuthor(author);
		newBook.setIsbn(isbn);
		newBook.setPrice(price);
		newBook.setPublishDate(publishDate);
		newBook.setDescription(description);
		Category category = categoryDAO.get(categoryId);
		newBook.setCategory(category);
		Part part = request.getPart("bookImage");
		if (part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageByte = new byte[(int) size];
			InputStream inputStream = part.getInputStream();
			inputStream.read(imageByte);
			inputStream.close();
			newBook.setImage(imageByte);
		}
		Book createdBook = bookDAO.create(newBook);
		if (createdBook.getBookId() > 0) {
			String message = "Book created Successfully!";
			request.setAttribute("message", message);
			listBooks(message);
		}
	}
	
	public void deleteBook() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		bookDAO.delete(bookId);
		String message = "Book has been deleted successfully.";
		listBooks(message);
	}

	public void editBook() throws ServletException, IOException {
		System.out.println("Book Service Edit Book Method !");
		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		List<Category> listcategory = categoryDAO.listAll();
		Book exitsbook = bookDAO.get(bookId);
		request.setAttribute("book", exitsbook);
		request.setAttribute("listcategory", listcategory);
		String editPage = "book_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	public void updateBook() throws ServletException, IOException {
		String messgage = "Hi User we are trying hard to build this module! please visit this after some time!";
		request.setAttribute("errorMessage", messgage);
		String msgPage = "message.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(msgPage);
		requestDispatcher.forward(request, response);
	}

	public void listBookBYCategory() throws ServletException, IOException {
		Integer categoryId = Integer.parseInt(request.getParameter("id"));
		System.out.println("categoryId:" +categoryId);
		Category category = categoryDAO.get(categoryId);
		List<Book> bookListbyCategory = bookDAO.listByCategory(categoryId);
		request.setAttribute("bookListbyCategory", bookListbyCategory);
		request.setAttribute("category", category);
		String newPage = "frontend/book_list_bycategory.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(newPage);
		dispatcher.forward(request, response);
	}

	public void viewBookDetail() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		Book book = bookDAO.get(bookId);
		request.setAttribute("book", book);
		String detailPage = "frontend/book_details.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(detailPage);
		dispatcher.forward(request, response);
	}

	public void searchBook() throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		List<Book> searchBook = null;
		if (keyword.equals("")) {
			searchBook = bookDAO.listAll();
		} else {
			searchBook = bookDAO.searchBook(keyword);
		}
		request.setAttribute("keyword", keyword);
		request.setAttribute("searchBook", searchBook);
		String resultPage = "frontend/search_results.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
		dispatcher.forward(request, response);
	}
}