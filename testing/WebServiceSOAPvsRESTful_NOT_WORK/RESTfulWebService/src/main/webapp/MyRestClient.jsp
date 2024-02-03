<%@page import="com.client.TestClient" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My REST Client</title>
</head>
<body>
	<h3>Testing RESTful Service</h3>
	
	<%!
		TestClient client = new TestClient();	
	%>
	Plain Response: <%= client.getPlainResponse() %>
	HTML Response: <%= client.getHTMLResponse() %>
	XML Response: <%= client.getXMLResponse() %>
	JSON Response: <%= client.getJSONResponse() %>
</body>
</html>