package com;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientDemo {

	public static void main(String[] args) {
		String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
				
		/*
		 * 1. create HTTP Client
		 * 2. create HTTP Request
		 * 3. create HTTP Response
		 */	
		// HttpClient client0 = HttpClient.newHttpClient(); - ok to use too
		HttpClient client = HttpClient.newBuilder()
				.version(HttpClient.Version.HTTP_2)
				.connectTimeout(Duration.ofSeconds(10))
				.build();
		
		HttpRequest req = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create(url))
				.build();
		
		try {
			HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
			System.out.println("Response: " + res.body());
			
			// Further you can parse the JSON data here
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
