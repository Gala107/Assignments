package com.intro.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class IntroServlet
 */
@WebServlet("/introServlet")
public class IntroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntroServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("fname");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body><h2>Welcome to doGet, " + name + "</h2></body></html>"); 
		
		out.print("<br/><h1>Accessing Init Parameters from Servlet Context</h1>");
		ServletContext appContext = getServletContext();
		out.print("fruit is " + appContext.getInitParameter("fruit"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("fname");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body><h2>Welcome to doPost, " + name + "</h2></body></html>"); 
		
		out.print("<br/><h1>Accessing Init Parameters from Servlet Context</h1>");
		ServletContext appContext = getServletContext();
		out.print("fruit is " + appContext.getInitParameter("fruit"));
	}

	// service(...) has higher priority over doGet() and doPost() and 
	// will be called for get and post action if implemented in servlet
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		arg1.setContentType("text/html");
//		arg1.getWriter().print("<html><body><h2>Welcome to service!</h2></body></html>");
//	}
	
	

}
