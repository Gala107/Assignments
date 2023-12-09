package com.my.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyAppListener implements ServletContextListener, HttpSessionListener {

	public MyAppListener() {

	}

	public void sessionCreated(HttpSessionEvent se) {
		HttpSessionListener.super.sessionCreated(se);
		HttpSession session = se.getSession();
		session.setAttribute("newOffer", "10% Off on CLothing");
		System.out.println("[MyAppListener] Session Created."); 
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("[MyAppListener] Session Destroyed."); 
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
		System.out.println("[MyAppListener] Context Destroyed."); 
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContextListener.super.contextInitialized(sce);
		System.out.println("[MyAppListener] Context Initialized. DB Connection is set up."); 

		try {
			ServletContext context = sce.getServletContext();
			String url = context.getInitParameter("dbURL");
			DriverManager.registerDriver(new Driver());
			
			// Connection to the DB
			Connection connection = DriverManager.getConnection(url, "username", "password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
