package org.bookstore.controller.admin.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bookstore.controller.BaseServlet;
import org.bookstore.service.BookService;

@WebServlet("/admin/update_book")
public class UpdateBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateBookServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService updateBookService = new BookService(entityManager, request, response);
		updateBookService.updateBook();
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
