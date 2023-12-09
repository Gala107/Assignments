package com.my.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/Configured", 
			initParams = { @WebInitParam(name = "appName", value = "MyServlets - web app")
})
public class ConfiguredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ServletConfig is specific to a Servlet
		ServletConfig config = getServletConfig();
		String initParam = config.getInitParameter("appName");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<center><h3>" + initParam + "</h3>");
		
		Enumeration<String> paramNames = config.getInitParameterNames();
		while(paramNames.hasMoreElements()) {
			String name = paramNames.nextElement();
			String value = config.getInitParameter(name);
			out.println("Config param name: " + name + " | Config param value: " + value + "<br><br>");
		}
		
		// ServletContext is accessible by any Servlet
		ServletContext context = getServletContext();
		String dbURL = context.getInitParameter("dbURL");
		out.println("Context init param: dbURL | Context init value: " + dbURL);
		
		out.println("</center>");
	}
}
