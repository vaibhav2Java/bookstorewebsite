package org.bookstore.controller.admin;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Adminloginfilter
 */
@WebFilter("/admin/*")
public class Adminloginfilter implements Filter {

    public Adminloginfilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession(false);
		
		boolean loggedIn = session != null && session.getAttribute("useremail") != null;
		String loggInURI= httpServletRequest.getContextPath() +"/admin/login";
		boolean loginRequest = httpServletRequest.getRequestURI().equals(loggInURI);
		boolean loginPage = httpServletRequest.getContextPath().endsWith("login.jsp");
		if (loggedIn && (loginRequest || loginPage)) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/");
			requestDispatcher.forward(request, response);
		}
		else if (loggedIn || loginRequest) {
			System.out.println("User logged in");
			chain.doFilter(request, response);
		}else {
			System.out.println("User logged in");
			String message = "Please login to enter admin area!.";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}