package org.bookstore.controller.frontend.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bookstore.dao.BookDAO;
import org.bookstore.entity.Book;

@WebServlet("/remove_from_cart")
public class RemoveBookFromShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveBookFromShoppingCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("book_id"));
		Object cartObject = request.getSession().getAttribute("cart");
		ShoppingCart shoppingcart = (ShoppingCart) cartObject;
		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.get(bookId);
		shoppingcart.removeItem( new Book(bookId));
		String redirectURL = request.getContextPath().concat("/view_cart");
		response.sendRedirect(redirectURL);
	}

}
