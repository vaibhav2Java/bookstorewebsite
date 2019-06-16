package org.bookstore.controller.frontend.customer;

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

@WebFilter("/*")
public class CustomerLoginFilter implements Filter {
	
	private static final String [] LOGINURLs = {
			"/view_profile","/edit_profile","/update_profile","/write_review"
	};

    public CustomerLoginFilter() {

    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

		if (path.startsWith("/admin/")) {
			chain.doFilter(request, response);
			return;
		}
		
		
		
		boolean loggedIn = session != null && session.getAttribute("loggedCustomer") != null;
		 String requestURL = httpRequest.getRequestURI().toString();
		 
		if (!loggedIn && isloginRequires(requestURL) ) {
			String queryString = httpRequest.getQueryString();
			String redirectURL = requestURL;
			if (queryString!= null) {
				redirectURL = redirectURL.concat("?").concat(queryString);
			}
			session.setAttribute("redirectURL",redirectURL);
			String loginPage = "frontend/login.jsp";
			RequestDispatcher requestDispatcher = httpRequest.getRequestDispatcher(loginPage);
			requestDispatcher.forward(request, response);
		}else {
		chain.doFilter(request, response);
		}
	}
	
	public boolean isloginRequires(String requestURL) {
		for(String loginRequiredURL : LOGINURLs) {
			if(requestURL.contains(loginRequiredURL)) {
				return true;
			}
		}
		return false;
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
