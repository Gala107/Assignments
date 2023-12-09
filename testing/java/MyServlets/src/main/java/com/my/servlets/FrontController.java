package com.my.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Front")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<center>");
		out.println("<h3>Welcome to Front Controller!</h3>");

		String typeOfRequest = request.getParameter("txtType");
		String url = "";
		if (typeOfRequest.equals("login")) {
			url = "Login";
		} else if (typeOfRequest.equals("register")) {
			url = "Register";
		} else {
			out.println("<h3>Sorry! Request cannot be processed</h3>");
		}

		if (!url.isBlank()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			request.setAttribute("key_test", "test");
			dispatcher.forward(request, response);
			//dispatcher.include(request, response);
		}
		out.println("</center>");
	}
}
