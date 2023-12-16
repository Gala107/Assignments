<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.gym.management.service.BatchService"%>
<%@page import="com.gym.management.model.Batch"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Batch</title>
<link rel="stylesheet" href="/GymManagementWithMongoDB/css/styles.css" />
</head>
<body>
	<div class="center">
		<%@include file="navigationBar.html" %>
		<h1>Update Batch</h1>
		<%
		int batchId = Integer.parseInt(request.getParameter("batchId"));
		Batch batch = new BatchService().getBatch(batchId);
		%>
		<form action="BatchController" method="post">
			<ul>
				<li><label for="batchId">Batch ID</label><br> <input
					type="text" id="batchId" name="batchId" value="<%=batch.getId()%>"
					readonly></li>
				<li><label for="day">Day of the Week</label><br> <input
					type="text" id="day" name="day" value="<%=batch.getWeekDay()%>"></li>
				<li><label for="time">Start Time</label><br> <input
					type="text" id="time" name="time" value="<%=batch.getStartTime()%>"></li>
				<li><input type="submit" value="Update"></li>
			</ul>
			<input type="hidden" id="action" name="action" value="update">
		</form>
	</div>
</body>
</html>