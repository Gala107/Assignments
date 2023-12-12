<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.gym.management.service.ParticipantService"%>
<%@page import="com.gym.management.model.Participant"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Batch</title>
<link rel="stylesheet" href="/GymManagementApp/css/styles.css" />
</head> 
</head>
<body>
	<div class="center">
		<%@include file="navigationBar.html" %>
		<h1>New Batch</h1>
		<form action="BatchController" method="post">
			<ul>
				<li><label for="batchId">Batch ID</label><br> <input
					type="text" id="batchId" name="batchId" placeholder="A1"></li>
				<li><label for="day">Day of the Week</label><br> <input
					type="text" id="day" name="day" placeholder="Monday"></li>
				<li><label for="time">Start Time</label><br> <input
					type="text" id="time" name="time" placeholder="10:30 am"></li>
				<li><input type="submit" value="Create"></li>
			</ul>
			<input type="hidden" id="action" name="action" value="create">
		</form>
	</div>
</body>
</html>