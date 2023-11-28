package com.session.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.session.dto.User;

/**
 * Servlet implementation class SessionServlet3
 */
public class SessionServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionServlet3() {
		super();

	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Indicate by 'false' we want session from previous request,
		// not new HttpSession
		HttpSession session = request.getSession(false);

		if (session != null) {
			User user = (User) session.getAttribute("user");

			user.setCity(request.getParameter("city"));
			user.setContact(Long.parseLong(request.getParameter("contact")));

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h2> Hello " + user.getEmail() + " </h2>");
			out.println("<h3> Details .. " + user + " </h3>");
			out.println("<h4> Session Id is " + session.getId() + " </h4>");
			out.println("<h2> Session created at " + session.getCreationTime() + " </h2>");
			
			// Session is closed;
			session.invalidate();
		}
	}

}
