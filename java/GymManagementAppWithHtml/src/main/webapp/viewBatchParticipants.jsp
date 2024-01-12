<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.gym.management.service.ParticipantService"%>
<%@page import="com.gym.management.service.BatchService"%>
<%@page import="com.gym.management.model.Participant"%>
<%@page import="com.gym.management.model.Batch"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Batch Participants</title>
<link rel="stylesheet" href="/GymManagementAppWithHtml/css/styles.css" />
</head>
</head>
<body>
	<%
	String batchId = request.getParameter("batchId");
	List<Participant> participants = new ParticipantService().getParticipantsByBatch(batchId);
	%>
	<div class="center">
		<%@include file="navigationBar.html"%>
		<h1>Batch ${param.batchId} Participants</h1>
			<ul>
				<li>
					<table>
						<tr>
							<th>Name</th>
							<th>Phone</th>
							<th>Email</th>
						</tr>
						<c:forEach items="<%=participants %>" var="participant">
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