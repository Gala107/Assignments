package com.my.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;

@WebServlet("/Hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[Helloservlet] - service executed");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<center>");
		String htmlResponse = "<center><h3><b>Welcome to Home</b></h3>" + "<p>Request Served at " + new Date()
				+ "</p>";
		out.print(htmlResponse);
		
		// 1. Session Tracking with Cookies
		// Reading cookies
		out.println("<br><p><b>Cookies Data</b></p>");
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			out.println("<p>" + cookie.getName() + " - " + cookie.getValue() + "</p>");
		}
		
		// 2. Session Tracking with URL ReWriting
		// Reading Data from URL
		String name = request.getParameter("name");
		String sales = request.getParameter("sales");
		out.println("<br><p><b>URL ReWriting Data</b></p>");
		out.println("NAME: " + name + " | SALES: " + sales);
		
		// 3. Session Tracking with hidden form fields
		// Reading the data from Form
		String hiddenName = request.getParameter("txtName");
		String hiddenSales = request.getParameter("txtSales");
		out.println("<br><br><p><b>Hidden Form Fields Data</b></p>");
		out.println("NAME: " + hiddenName + " | SALES: " + hiddenSales);
		out.println("</center>");
		
		// 4. Session Tracking with HttpSession Object
		// Read the data from HttpSession
		HttpSession session = request.getSession();
		HashMap<String, String> data = (HashMap<String, String>)session.getAttribute("key_data");
		
		out.println("<br><br><p><b>HttpSession Object Data</b></p>");
		out.println("<p>NAME: " + data.get("name") + " | SALES: " + data.get("sales") + "</p>");
		out.println("</center>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
