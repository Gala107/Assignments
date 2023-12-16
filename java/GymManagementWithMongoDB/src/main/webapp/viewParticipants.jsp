<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.gym.management.service.ParticipantService"%>
<%@page import="com.gym.management.model.Participant"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Participants</title>
<link rel="stylesheet" href="/GymManagementWithMongoDB/css/styles.css" />

</head>
<body>
	<div class="center">
		<%@include file="navigationBar.html" %>
		<h1>Participants</h1>
		<%
			List<Participant> participants = new ParticipantService().getParticipants();
		%>
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
							<td><a
								href="updateParticipant.jsp?participantId=${participant.id}"><img
									alt="Update" src="images/update.jpg"></a> <a
								href="ParticipantController?participantId=${participant.id}&action=delete"><img
									alt="Delete" src="images/delete.png"></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</div>
</body>
</html>
