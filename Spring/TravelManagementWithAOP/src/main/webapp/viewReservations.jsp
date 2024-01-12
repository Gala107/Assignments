<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Batches</title>
<link rel="stylesheet" href="/css/styles.css" />


</head>
<body>
	<div class="center">
		<%@include file="navigationBar.html" %>
		<h1>Batches</h1>
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
				<c:forEach items="<%=%>" var="batch">
					<tr>
						<td><a href="viewBatchParticipants.jsp?batchId=${batch.getId()}">${batch.getId()}</a></td>
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