<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Tags JSP Page</title>
</head>
<body>
	<!-- Core JSTL/JSP Standard Tag Library/ c: tag -->
	First name: <c:out value="${param.fname}"/><br> 
	Last name: <c:out value="${param.lname}"/><br>
	
	<!-- Core JSTL/JSP Standard Tag Library/ c:if tag -->
	<c:set var="income" scope="session" value="${param.income*4}"/>
	<c:if test="${income > 8000}">
		<p>My income is: <c:out value="${income}"/></p>
	</c:if>
	
	<!-- Core JSTL/JSP Standard Tag Library/ c:catch tag -->
	<c:catch var="catchTheException">
		<% int x = 2/0; %>
	</c:catch>
	
	<c:if test="${catchTheException != null}">
		<p>The Type of Exception:   ${catchTheException} <br>
		   The Exception Message:   ${catchTheException.message}</p>
	</c:if>
</body>
</html>