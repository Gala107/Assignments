<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Confirmation</title>
<c:url value="/resources/css/styles.css" var="styles" />
<link rel="stylesheet" type="text/css" media="screen" href="${styles}" />

</head>
<body>
	<div class="center">
		<%@include file="navigationBar.html"%>
		<h1>Reservation Confirmation</h1>
		<table id="confirmReservation">
			<tr>
				<td><label>Client Name : </label>${requestScope.reservation.client.name}</td>
			</tr>
			<tr>
				<td><label>Phone : </label>${requestScope.reservation.client.phone}</td>
				<td><label>Email : </label>${requestScope.reservation.client.email}</td>
			</tr>
			<tr>
				<td><label>Pickup Location : </label>${requestScope.reservation.pickupLocation}</td>
				<td><label>Pickup Time : </label>${requestScope.reservation.pickupTime}</td>
			</tr>
			<tr>
				<td><label>Destination : </label>${requestScope.reservation.destination}</td>
			</tr>
			<tr>
				<td><label>Number of Passengers : </label>${requestScope.reservation.passengerNum}
			<tr>
				<td><label>Taxi : </label>${requestScope.reservation.taxiInfo.carModel}</td>
				<td><label>Is there a Luggage? </label>${requestScope.reservation.luggage == true ? 'Yes' : 'No'}</td>
			</tr>
			<tr>
				<td><label>Fare : </label>${requestScope.reservation.fare == 0.0 ? requestScope.msg : requestScope.reservation.fare}</td>
			</tr>
		</table>

	</div>
</body>
</html>
