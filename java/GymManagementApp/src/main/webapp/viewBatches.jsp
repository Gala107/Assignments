<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.gym.management.service.ParticipantBatchService, java.util.List, com.gym.management.model.Batch"%>
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
			<a href="updateBatch.html">Update Batch</a> <a
				href="updateParticipant.html">Update Participant</a>
		</div>
		<h1>Batches</h1>

		<%!
			List<Batch> batches = new ParticipantBatchService().getBatches();
		%>

		<form action="BatchController" method="post">
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
							<td>${batch.id}</td>
							<td>${batch.weekDay}</td>
							<td>${batch.startTime}</td>	
							<td>
								<a href="updateBatch?id=${batch.id}"><img alt="Update" src="images/update.jpg"></a>
								<a href="BatchController?id=${batch.id}&action=delete"><img alt="Delete" src="images/delete.png"></a>
							</td>				
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</form>
	</div>
</body>
</html>