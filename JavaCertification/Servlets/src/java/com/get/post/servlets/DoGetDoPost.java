package com.get.post.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DoGetDoPost
 */
public class DoGetDoPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoGetDoPost() {

    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String fname = request.getParameter("fname");
//		String lname = request.getParameter("lname");
//		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.append("[Service] First name is " + fname + "<br>");
//		out.print("[Service] Last name is " + lname);
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("[doGet] First name is " + fname);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lname = request.getParameter("lname");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("[doPost] Last name is " + lname);
	}

}
