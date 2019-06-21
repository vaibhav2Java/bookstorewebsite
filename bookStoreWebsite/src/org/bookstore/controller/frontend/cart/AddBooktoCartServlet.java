package org.bookstore.controller.frontend.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bookstore.dao.BookDAO;
import org.bookstore.entity.Book;

@WebServlet("/add_to_cart")
public class AddBooktoCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddBooktoCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer bookId = Integer.parseInt(request.getParameter("book_Id"));
		Object cartObject = request.getSession().getAttribute("cart");
		
		ShoppingCart shoppingcart = null;
		
		if(cartObject != null && cartObject instanceof ShoppingCart) {
			shoppingcart = (ShoppingCart) cartObject;
		}else {
			shoppingcart = new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingcart);
		}
		
		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.get(bookId);
		
		shoppingcart.addItem(book);
		
		String redirectURL = request.getContextPath().concat("/view_cart");
		response.sendRedirect(redirectURL);
	}

}
