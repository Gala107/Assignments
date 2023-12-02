<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.gym.management.service.BatchService"%>
<%@page import="com.gym.management.model.Batch"%>
<%@page import="com.gym.management.model.Participant"%>
<%@page import="com.gym.management.service.ParticipantService"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Participant</title>
<link rel="stylesheet" href="/GymManagementApp/css/styles.css" />

</head>
<body>
	<div class="center">
		<div class="navigator">
			<a href="index.html">Home</a> <a href="addBatch.html">Add Batch</a> <a
				href="addParticipant.jsp">Add Participant</a> <a
				href="viewBatches.jsp">Batches</a> <a href="viewParticipants.jsp">Participants</a>
		</div>
		<h1>Update Participant</h1>
		<%
		String participantId = request.getParameter("participantId");
		Participant participant = new ParticipantService().getParticipant(Integer.parseInt(participantId));
		List<Batch> batches = new BatchService().getBatches();
		request.setAttribute("participantId", participant.getBatchId());
		%>
		<form action="ParticipantController" method="post">

			<ul>
				<li><label for="name">Full Name</label><br> <input
					type="text" id="name" name="name"
					value="<%=participant.getName()%>"></li>
				<li><label for="phone">Phone</label><br> <input
					type="text" id="phone" name="phone" value="<%=participant.getPhone()%>"></li>
				<li><label for="email">Email</label><br> <input
					type="text" id="email" name="email" value="<%=participant.getEmail()%>"></li>
				<li><label for="batch">Batch</label><br> <select
					id="batch" name="batch">
						<c:forEach items="<%=batches%>" var="batch">
							<option value="${batch.getId()}"
								<c:if test="${batch.getId() == participantId}">selected</c:if>>${batch.getId()}:
								${batch.getWeekDay()} at ${batch.getStartTime()}</option>
						</c:forEach>
				</select></li>
				<li><input type="submit" value="Update"></li>
			</ul>
			<input type="hidden" id="action" name="action" value="update">
			<input type="hidden" id="participantId" name="participantId"
				value="<%=participantId%>">
		</form>
	</div>
</body>
</html>