<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.gym.management.service.BatchService"%>
<%@page import="com.gym.management.model.Participant"%>
<%@page import="com.gym.management.repository.model.ParticipantsBatch"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Batch Participants</title>
<link rel="stylesheet" href="/GymManagementApp/css/styles.css" />
</head>
</head>
<body>
	<%
	String batchId = request.getParameter("batchId");
	ParticipantsBatch batch = new BatchService().getBatchWithParticipants(batchId);
	%>
	<div class="center">
		<%@include file="navigationBar.html"%>
		<h1>Batch <%=batch.getId() %> Participants</h1>
			<ul>
				<li>
					<table>
						<tr>
							<th>Name</th>
							<th>Phone</th>
							<th>Email</th>
						</tr>
						<c:forEach items="<%=batch.getParticipants() %>" var="participant">
							<tr>
								<td><c:out value="${participant.name}"/></td>
								<td>${participant.phone}</td>
								<td>${participant.email}</td>
							</tr>
						</c:forEach>
					</table>
				</li>
			</ul>
	</div>
</body>
</html>