<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.gym.management.service.BatchService"%>
<%@page import="com.gym.management.model.Batch"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Batch</title>
<link rel="stylesheet" href="/GymManagementApp/css/styles.css" />
</head>
<body>
	<div class="center">
		<div class="navigator">
			<a href="index.jsp">Home</a> 
			<a href="newBatch.html">New Batch</a> 
			<a href="newParticipant.jsp">New Participant</a> 
			<a href="addBatchParticipants.jsp">Add Participants to Batch</a> 
			<a href="viewBatches.jsp">Batches</a> 
			<a href="viewParticipants.jsp">Participants</a>
		</div>
		<h1>Update Batch</h1>
		<%
		String batchId = request.getParameter("batchId");
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