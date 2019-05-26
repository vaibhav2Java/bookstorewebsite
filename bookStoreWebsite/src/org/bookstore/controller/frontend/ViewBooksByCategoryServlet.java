package org.bookstore.controller.frontend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bookstore.controller.BaseServlet;
import org.bookstore.service.BookService;

/**
 * Servlet implementation class ViewBooksByCategoryServlet
 */
@WebServlet(name = "ViewBooksByCategoryServ", urlPatterns = { "/view_category" })
public class ViewBooksByCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public ViewBooksByCategoryServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookServiceByCategory = new BookService(entityManager, request, response);
		bookServiceByCategory.listBookBYCategory();
	}

}
