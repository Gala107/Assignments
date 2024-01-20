<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservations</title>
<link rel="stylesheet" href="/css/styles.css" />

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
					<th>Phone</th>
					<th>Email</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<core:forEach items="${requestScope.taxiReservations}"
					var="reservation">
					<tr>
						<td>${reservation.pickupLocation}</td>
						<td>${reservation.pickupTime}</td>
						<td>${reservation.destination}</td>
						<td>${reservation.taxiInfo.carModel}</td>
						<td>${reservation.client.name}</td>
						<td>${reservation.client.phone}</td>
						<td>${reservation.client.email}</td>
						<td><a href="updateReservation?id=${reservation.id}"><img
								alt="Update" src="images/update.jpg"></a> <a
							href="deleteReservation?id=${reservation.id}"><img
								alt="Delete" src="images/delete.png"></a></td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>