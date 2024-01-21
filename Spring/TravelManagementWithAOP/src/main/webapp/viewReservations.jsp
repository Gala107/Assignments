<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservations</title>
<c:url value="/resources/images/" var="images" />
<c:url value="/resources/css/styles.css" var="styles" />
<link rel="stylesheet" type="text/css" media="screen" href="${styles}" />

</head>
<body>
	<div class="center">
		<%@include file="navigationBar.html"%>
		<h1>Reservations</h1>
		<table id="tableB">
			<thead>
				<tr>
					<th>Pickup</th>
					<th>Time</th>
					<th>Destination</th>
					<th>Taxi</th>
					<th>Client</th>
					<th>Email</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.taxiReservations}"
					var="reservation">
					<tr>
						<td>${reservation.pickupLocation}</td>
						<td>${reservation.pickupTime}</td>
						<td>${reservation.destination}</td>
						<td>${reservation.taxiInfo.carModel}</td>
						<td>${reservation.client.name}</td>
						<td>${reservation.client.email}</td>
						<td><a href="updateReservation?id=${reservation.id}"><img
								alt="Update" src="resources/images/update.jpg"></a><a
							href="deleteReservation?id=${reservation.id}"><img
								alt="Delete" src="resources/images/delete.png"></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>