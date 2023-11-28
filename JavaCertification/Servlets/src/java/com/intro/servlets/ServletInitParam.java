package com.intro.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletInitParam
 * DD (web.xml - Deployment Descriptor) can overwrite init params
 */
@WebServlet(name="servletInitParam", urlPatterns="/initParam", initParams=@WebInitParam(name="name", value="Galochka"))
public class ServletInitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInitParam() {
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		PrintWriter out = response.getWriter();
		out.print("<br/><h1>Accessing Init Parameters from Servlet Config</h1>");
		out.print("My favorite person is " + config.getInitParameter("name"));
		
		out.print("<br/><h1>Accessing Init Parameters from Servlet Context</h1>");
		ServletContext appContext = getServletContext();
		out.print("fruit is " + appContext.getInitParameter("fruit"));
		
	}

}
