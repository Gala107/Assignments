<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Batch Participants</title>
<link rel="stylesheet" href="/css/styles.css" />
</head>
</head>
<body>
	<div class="center">
		<%@include file="navigationBar.html"%>
		<h1>Add Participants to Batch</h1>
		<form action="ParticipantController" method="post">
			<ul>
				<li><label for="batch">Select Batch</label><br> 
				<select id="batch" name="batch">
						<c:forEach items="<%=%>" var="batch">
							<option value="${batch.id}">${batch.id}:
								${batch.weekDay} at ${batch.startTime}</option>
						</c:forEach>
				</select></li>
				<li>
					<table>
						<tr>
							<th></th>
							<th>Name</th>
							<th>Phone</th>
							<th>Email</th>
							<th>Current Batch</th>
						</tr>
						<c:forEach items="<%=%>" var="participant">
							<tr>
								<td><input type="checkbox" id="participantId"
									name="participantId" value="${participant.id}"></td>
								<td>${participant.name}</td>
								<td>${participant.phone}</td>
								<td>${participant.email}</td>
								<td>${participant.batchId}</td>
							</tr>
						</c:forEach>
					</table>
				</li>
				<li><input type="submit" value="Add"></li>
			</ul>
			<input type="hidden" id="action" name="action" value="updateParticipants">
		</form>
		<div>
			<b>Note:</b>
			Participant can be assigned to one Batch only.<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Adding
			Participant to Batch removes them from current one.
		</div>
	</div>
</body>
</html>