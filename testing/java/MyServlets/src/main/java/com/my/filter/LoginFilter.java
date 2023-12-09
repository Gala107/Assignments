package com.my.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/Login")
public class LoginFilter extends HttpFilter implements Filter {

	public LoginFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Pre - Proessing (Filtering Request from the Client to the Servlet)
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		out.println("<h3>Pre Processing</h3>");

		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");
		if (email.isBlank() || password.isBlank()) {
			// pass the datat to LoginServlet
			out.println("<h3>Sorry! Email and Password cannot be blank!</h3>");
		} else {
			chain.doFilter(request, response);
		}

		// Post - Processing (Filtering Response from the Servlet to the Client
		out.println("<h3>Post Processing</h3>");
		out.print("</center>");
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
