package com.event.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class EventListenerDemo
 */
public class EventListenerDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventListenerDemo() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		System.out.println("Session is created. Listener will be invoked!");
		System.out.println();
		
		session.setAttribute("username", "Tom");
		session.setAttribute("password", "Jerry");
		
		System.out.println("Session attributes are displayed. Listener to come here");
		session.setAttribute("username", "Jim");
		
		System.out.println("Attribute is modified. Listener will be invoked!");
		session.invalidate();
		System.out.println("Session is destroyed.");

	}

}
