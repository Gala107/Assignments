<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update a Reservation</title>
<c:url value="/resources/css/styles.css" var="styles" />
<link rel="stylesheet" type="text/css" media="screen" href="${styles}" />

</head>
<body>
	<div class="center">
		<%@include file="navigationBar.html"%>
		<h1>Update a Reservation</h1>
		<form action="saveUpdateReservation" method="post">

			<table>
				<tr>
					<td><label for="name">Client Name</label><br> 
					<input type="text" id="name" name="client.name" value="${requestScope.reservation.client.name}" readonly></td>
				</tr>
				<tr>
					<td><div>
							<label>Phone</label><br> 
							<input type="text" id="phone" name="client.phone" value="${requestScope.reservation.client.phone}" readonly>
						</div></td>
					<td><div>
							<label>Email</label><br> 
							<input type="text" id="email" name="client.email" value="${requestScope.reservation.client.email}" readonly>
						</div></td>
				</tr>
				<tr>
					<td><div>
							<label for="pickupLocation">Pickup Location</label><br> 
							<input type="text" id="pickupLocation" name="pickupLocation"
								 value="${requestScope.reservation.pickupLocation}">
						</div></td>
					<td><div>
							<label for="pickupTime">Pickup Time</label><br> <input
								type="text" id="pickupTime" name="pickupTime"
								 value="${requestScope.reservation.pickupTime}">
						</div></td>
				</tr>
				<tr>
					<td><label for="destination">Destination</label><br> <input
						type="text" id="destination" name="destination"  value="${requestScope.reservation.destination}">
					</td>
				</tr>
				<tr>
					<td><label for="passengerNum">Number of Passengers</label><br>
						<input type="number" id="passengerNum" name="passengerNum"
						 value="${requestScope.reservation.passengerNum}"></td>
				</tr>
				<tr>
					<td><label for="taxi">Taxi</label><br> 
					<select id="taxi" name="taxiInfo.id">
							<c:forEach items="${requestScope.taxi}" var="item">
								<option value="${item.id}" ${item.id == requestScope.reservation.taxiInfo.id ? 'selected' : ''}>
									<core:out value="${item.carModel} - ${item.licensePlate}" />
								</option>
							</c:forEach>
					</select></td>
					<td><label for="luggage">Is there a Luggage?</label> <input
						type="checkbox" id="luggage" name="luggage" value="${requestScope.reservation.luggage}"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
			<input type="hidden" name="client.id" value="${requestScope.reservation.client.id}" />
		</form>
	</div>
</body>
</html>