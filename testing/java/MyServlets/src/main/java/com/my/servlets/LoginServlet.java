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

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String EMAIL = "123";
	private final String PASSWORD = "123";
	
	private final String NAME = "John";
	private final int TOTAL_SALES = 30000;

	public LoginServlet() {

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object test = request.getAttribute("key_test");
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");

		System.out.println("[LoginServlet] service User Details: " + email + " " + password);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<center>");
		out.println("Test attribute value: " + test);
		String message = "";
		if (email.equals(EMAIL) && password.equals(PASSWORD)) {
			
			// 1. Session Tracking with Cookies, cookies are stored in the browser
			// Creating Cookies
			// Advantage: faster access because cookies are stored in the client machine, 
			// Disadvantage: cookies could be disabled in the browser 
			Cookie cookie1 = new Cookie("KEY_NAME", NAME);
			Cookie cookie2 = new Cookie("KEY_SALES", String.valueOf(TOTAL_SALES));
			
			// Writing Cookies
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
			// 2. Session Tracking with URL ReWriting
			// Writing Data in URL Directly
			// Advantage: quick, 
			// Disadvantage: cannot share sensitive information
			String url = "Hello?name=" + NAME + "&sales=" + TOTAL_SALES;
			message = "<p>Welcome to Home<br><a href='" + url + "'>Click to navigate to Home</a></p>";	
			//message = "<p>welcome to Home<br><a href='Hello'>Click to navigate to Home</a></p>";		
			
			// 3. Session Tracking with Hidden Form Fields
			// Writing the data from Form as hidden fields
			// Disadvantage: tedious because you have to write a form.
			String form = "<form action='Hello' method='post'>"
					+ "<input type='hidden' value='" + NAME + "' name='txtName'/>"
					+ "<input type='hidden' value='" + TOTAL_SALES + "' name='txtSales'/>"
					+ "<input type='submit' value='NAVIGATE TO HOME'/>"
					+ "</form><br>";
			out.println(form);
			
			// 4. Session Tracking with HTTP Session
			// Writing data in the Session Object
			// In this case JSESSIONID is created with value and stored in cookies
			// Advantage: most convenient and good to use.
			HttpSession session = request.getSession();
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("name", NAME);
			data.put("sales", String.valueOf(TOTAL_SALES));
			session.setAttribute("key_data", data);
			
			out.print("<p><a href='Hello'>Click to navigate to Home with HttpSession</a></p>");
		} else {
			message = "<b>Invalid Username or Password</b>";
		}

		String loginTimeStamp = new Date().toString();
		String htmlResponse = "<h3>Welcome " + email 
				+ "</h3><p>You Attemptedd Login at " + loginTimeStamp
				+ "</p><br><br>" + message;

		out.print(htmlResponse);
		out.println("</center>");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");

		System.out.println("[LoginServlet] doGet User Details: " + email + " " + password);

		response.setContentType("text/html");
		String loginTimeStamp = new Date().toString();
		String htmlResponse = "<center><h3>Welcome " + email + "</h3><p>You Logged in at " + loginTimeStamp
				+ "<br> Handled by [doGet] </p>";

		PrintWriter out = response.getWriter();
		out.print(htmlResponse);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");

		System.out.println("[LoginServlet] doPost User Details: " + email + " " + password);

		response.setContentType("text/html");
		String loginTimeStamp = new Date().toString();
		String htmlResponse = "<center><h3>Welcome " + email + "</h3><p>You Logged in at " + loginTimeStamp
				+ "<br> Handled by [doPost] </p></center>";

		PrintWriter out = response.getWriter();
		out.print(htmlResponse);
	}
}
