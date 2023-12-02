<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.gym.management.service.BatchService"%>
<%@page import="com.gym.management.model.Batch"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Batches</title>
<link rel="stylesheet" href="/GymManagementApp/css/styles.css" />


</head>
<body>
	<div class="center">
		<div class="navigator">
			<a href="index.html">Home</a> <a href="addBatch.html">Add Batch</a> <a
				href="addParticipant.jsp">Add Participant</a> <a
				href="viewBatches.jsp">Batches</a> <a href="viewParticipants.jsp">Participants</a>
		</div>
		<h1>Batches</h1>
		<%
		List<Batch> batches = new BatchService().getBatches();
		%>
		<span style="color: red">${requestScope.message}</span>
		<table id="tableB">
			<thead>
				<tr>
					<th>Batch ID</th>
					<th>Week Day</th>
					<th>Time</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="<%=batches%>" var="batch">
					<tr>
						<td>${batch.getId()}</td>
						<td>${batch.getWeekDay()}</td>
						<td>${batch.getStartTime()}</td>
						<td><a href="updateBatch.jsp?batchId=${batch.getId()}"><img
								alt="Update" src="images/update.jpg"></a> <a
							href="BatchController?batchId=${batch.getId()}&action=delete"><img
								alt="Delete" src="images/delete.png"></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>