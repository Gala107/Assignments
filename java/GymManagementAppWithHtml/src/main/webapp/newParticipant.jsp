<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.gym.management.service.BatchService"%>
<%@page import="com.gym.management.model.Batch"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Participant</title>
<link rel="stylesheet" href="/GymManagementAppWithHtml/css/styles.css" />

</head>
<body>
	<div class="center">
		<%@include file="navigationBar.html" %>
		<h1>New Participant</h1>
		<%
		List<Batch> batches = new BatchService().getBatches();
		%>
		<form action="ParticipantController" method="post">

			<ul>
				<li><label for="name">Full Name</label><br> <input
					type="text" id="name" name="name" placeholder="John Watson">
				</li>
				<li><label for="phone">Phone</label><br> <input
					type="text" id="phone" name="phone" placeholder="919 999 1111">
				</li>
				<li><label for="email">Email</label><br> <input
					type="text" id="email" name="email" placeholder="john@example.com">
				</li>
				<li><label for="batch">Batch</label><br> <select
					id="batch" name="batch">
						<c:forEach items="<%=batches%>" var="batch">
							<option value="${batch.id}">${batch.id}:
								${batch.weekDay} at ${batch.startTime}</option>
						</c:forEach>
				</select></li>
				<li><input type="submit" value="Create"></li>
			</ul>
			<input type="hidden" id="action" name="action" value="create">
		</form>
	</div>
</body>
</html>