package com.session.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.session.dto.User;

/**
 * Servlet implementation class SessionServlet2
 */
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionServlet2() {
		super();
		// TODO Auto-generated constructor stub
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

			user.setEmail(request.getParameter("email"));
			user.setAge(Integer.parseInt(request.getParameter("age")));
			
			session.setAttribute("user", user);
			response.sendRedirect("sessionDemo3.html");
		}
	}

}
