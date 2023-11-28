<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.gym.management.service.ParticipantBatchService, java.util.List, com.gym.management.model.Participant"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Participants</title>
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
		<h1>Participants</h1>

		<%!List<Participant> participants = new ParticipantBatchService().getParticipants();%>

		<form action="ParticipantController" method="post">
			<table id="tableP">
				<thead>
					<tr>
						<th>Name</th>
						<th>Phone</th>
						<th>Email</th>
						<th>Batch</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="<%=participants%>" var="participant">
						<tr>
							<td>${participant.name}</td>
							<td>${participant.phone}</td>
							<td>${participant.email}</td>
							<td>${participant.batchId}</td>	
							<td><img alt="Update" src="images/update.jpg"><img alt="Delete" src="images/delete.png"></td>			
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</form>
	</div>
</body>
</html>
