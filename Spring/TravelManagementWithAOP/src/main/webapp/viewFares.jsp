<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Fares</title>
<c:url value="/resources/css/styles.css" var="styles" />
<link rel="stylesheet" type="text/css" media="screen" href="${styles}" />

</head>
<body>
	<div class="center">
		<%@include file="navigationBar.html"%>
		<h1>Available Fares</h1>
		<table id="tableB">
			<thead>
				<tr>
					<th>Amount</th>
					<th>Pickup Location</th>
					<th>Destination</th>
					<th>Taxi Model</th>
					<th># of Passengers</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.taxiFares}" var="fare">
					<tr>
						<td>${fare.fare}</td>
						<td>${fare.pickupLocation}</td>
						<td>${fare.destination}</td>
						<td>${fare.carModel}</td>
						<td>${fare.passengerNum}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>