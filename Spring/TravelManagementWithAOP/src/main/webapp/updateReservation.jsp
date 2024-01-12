<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Participant</title>
<link rel="stylesheet" href="/css/styles.css" />

</head>
<body>
	<div class="center">
		<%@include file="navigationBar.html" %>
		<h1>Update Participant</h1>
		<form action="ParticipantController" method="post">

			<ul>
				<li><label for="name">Full Name</label><br> <input
					type="text" id="name" name="name"
					value="<%=%>"></li>
				<li><label for="phone">Phone</label><br> <input
					type="text" id="phone" name="phone" value="<%=%>"></li>
				<li><label for="email">Email</label><br> <input
					type="text" id="email" name="email" value="<%=%>"></li>
				<li><label for="batch">Batch</label><br> <select
					id="batch" name="batch">
						<c:forEach items="<%=%>" var="batch">
							<option value="${batch.getId()}"
								<c:if test="${batch.getId() == participantId}">selected</c:if>>${batch.getId()}:
								${batch.getWeekDay()} at ${batch.getStartTime()}</option>
						</c:forEach>
				</select></li>
				<li><input type="submit" value="Update"></li>
			</ul>
			<input type="hidden" id="action" name="action" value="update">
			<input type="hidden" id="participantId" name="participantId"
				value="<%=%>">
		</form>
	</div>
</body>
</html>