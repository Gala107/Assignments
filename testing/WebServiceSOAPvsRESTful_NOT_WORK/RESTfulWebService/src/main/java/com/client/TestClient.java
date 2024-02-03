package com.client;

import org.glassfish.jersey.client.ClientConfig;

import java.net.URI;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.client.Client;

public class TestClient {
	
	WebTarget target;

	public TestClient() {
		ClientConfig configuragion = new ClientConfig();
		Client client = ClientBuilder.newClient(configuragion);
		URI uri = UriBuilder.fromUri("http://localhost:8080/RESTfulWebService").build();
		target = client.target(uri);
	}
	
	public String getPlainResponse() {
		String response = target.path("rest").path("user").path("plain").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		return response;
	}
	
	public String getHTMLResponse() {
		String response = target.path("rest").path("user").request().accept(MediaType.TEXT_HTML).get(String.class);
		return response;
	}
	
	public String getXMLResponse() {
		String response = target.path("rest").path("user").request().accept(MediaType.TEXT_XML).get(String.class);
		return response;
	}
	
	public String getJSONResponse() {
		String response = target.path("rest").path("user").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		return response;
	}
}
