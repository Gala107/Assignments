package com.service;

import java.util.Date;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/*
 * 1. Configure the project with dependencies
 * 	1. Jersey Server
 * 	2. Jersey Container
 * 
 * 2. Create Web Methods in your web service
 * 3. Annotate the Web Service and Web Methods
 * 4. Configure ServletContainer from the Jersey in web.xml [org.glassfish.jersey.servlet.ServletContainer]
 */
@Path("/user")
public class UserService {

	@Path("plain")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String registerUserWithPlainResponse() {
		String response = "[PLAIN TEST] User registered successfully at " + new Date();
		return response;
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String registerUserWithHTMLResponse() {
		String response = "<html><bocy><h3>[HTML TEXT] User registered successfully at " + new Date()
				+ "</h3></body></html>";
		return response;
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String registerUserWithXMLResponse() {
		String response = "<?xml version='1.0' charset='UTF-8'?><response>[XML TEXT] User registered successfully at "
				+ new Date() + "</response>";
		return response;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String registerUserWithJSONResponse() {
		String response = "{'response: '[JSON TEXT] User registered successfully at " + new Date() + "'}";
		return response;
	}
}
