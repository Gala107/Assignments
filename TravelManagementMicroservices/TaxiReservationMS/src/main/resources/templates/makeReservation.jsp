<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Make a Reservation</title>
<c:url value="/resources/css/styles.css" var="styles" />
<link rel="stylesheet" type="text/css" media="screen" href="${styles}" />

</head>
<body>
	<div class="center">
		<%@include file="navigationBar.html"%>
		<h1>Make a Reservation</h1>
		<form action="saveReservation" method="post">

			<table>
				<tr>
					<td><label for="name">Client Name</label><br> <input
						type="text" id="name" name="client.name" placeholder="John Watson"
						value="${requestScope.client.name}"></td>
				</tr>
				<tr>
					<td><div>
							<label>Phone</label><br> <input type="text" id="phone"
								name="client.phone" placeholder="919 999 1111"
								value="${requestScope.client.phone}">
						</div></td>
					<td><div>
							<label>Email</label><br> <input type="text" id="email"
								name="client.email" placeholder="john@example.com"
								value="${requestScope.client.email}">
						</div></td>
				</tr>
				<tr>
					<td><div>
							<label for="pickupLocation">Pickup Location</label><br> <input
								type="text" id="pickupLocation" name="pickupLocation"
								placeholder="Home">
						</div></td>
					<td><div>
							<label for="pickupTime">Pickup Time</label><br> <input
								type="text" id="pickupTime" name="pickupTime"
								placeholder="December 25, 10:35 am">
						</div></td>
				</tr>
				<tr>
					<td><label for="destination">Destination</label><br> <input
						type="text" id="destination" name="destination" placeholder="Work">
					</td>
				</tr>
				<tr>
					<td><label for="passengerNum">Number of Passengers</label><br>
						<input type="number" id="passengerNum" name="passengerNum"
						placeholder="4"></td>
				</tr>
				<tr>
					<td><label for="taxi">Taxi</label><br> 
					<select id="taxi" name="taxiInfo.id">
							<c:forEach items="${requestScope.taxi}" var="item">
								<option value="${item.id}" >
									<c:out value="${item.carModel} - ${item.licensePlate}" />
								</option>
							</c:forEach>
					</select></td>
					<td><label for="luggage">Is there a Luggage?</label> <input
						type="checkbox" id="luggage" name="luggage" value="yes"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
			<c:if test="${requestScope.client.id != ''}">
				<input type="hidden" name="client.id" value="${requestScope.client.id}" />
			</c:if>
		</form>
	</div>
</body>
</html>