package com.event.listeners;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import java.util.Date;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	/**
	 * Default constructor.
	 */
	public SessionListener() {
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("From Listener attribute with name: " + se.getName() 
		+ " and value: " + se.getValue() + " is modified successfully.");
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Hello from Listener. Session is created at " 
				+ new Date(se.getSession().getCreationTime()));
		System.out.println();
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out
				.println("Hello from Listener. Session is destroyed at " 
						+ new Date(se.getSession().getCreationTime()));
		System.out.println();
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("From Listener attribute with name: " + se.getName() 
			+ " and value: " + se.getValue() + " is removed successfully.");
		System.out.println();
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("From Listener attribute with name: " + se.getName() 
		+ " and value: " + se.getValue() + " is added successfully.");
		System.out.println();
	}
}
