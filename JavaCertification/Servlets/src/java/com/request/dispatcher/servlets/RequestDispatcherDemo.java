package com.request.dispatcher.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class RequestDispatcherDemo
 */
@WebServlet("/dispatcher")
public class RequestDispatcherDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDispatcherDemo() {
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		RequestDispatcher dispatcher = null;
		if(userName.equalsIgnoreCase("tom") && password.equals("jerry")) {
			dispatcher = request.getRequestDispatcher("success");
			dispatcher.forward(request, response);
		} else {
			dispatcher = request.getRequestDispatcher("requestDispatcher.html");
			PrintWriter out = response.getWriter();
			dispatcher.include(request,  response);
			out.println("<center><span style = 'color:red'>Invalid Credentials!</span></center>");
		}
	}

}
