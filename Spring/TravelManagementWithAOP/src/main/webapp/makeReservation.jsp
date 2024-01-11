<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Make a Reservation</title>
<link rel="stylesheet" href="/TravelManagementWithAOP/css/styles.css" />

</head>
<body>
	<div class="center">
		<%@include file="navigationBar.html"%>
		<h1>Make a Reservation</h1>
		<form method="post">

			<table>
				<tr>
					<td><label for="name">Client Name</label><br> <input
						type="text" id="name" name="name" placeholder="John Watson">
					</td>
				</tr>
				<tr>
					<td><div>
							<label>Phone</label><br> <input type="text" id="phone"
								name="phone" placeholder="919 999 1111">
						</div></td>
					<td><div>
							<label>Email</label><br> <input type="text" id="email"
								name="email" placeholder="john@example.com">
						</div></td>
				</tr>
				<tr>
					<td><div>
							<label for="pickupLocation">Pickup Location</label><br>
							<input type="text" id="pickupLocation" name="pickupLocation"
								placeholder="Home">
						</div></td>
					<td><div>
							<label for="pickupTime">Pickup Time</label><br>
							<input type="text" id="pickupTime" name="pickupTime"
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
					<td><label for="taxi">Type of Taxi</label><br> <select
						id="taxi" name="taxi">

					</select></td>
					<td><label for="luggage">Is there a Luggage?</label> <input
						type="checkbox" id="luggage" name="luggage" value="yes"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>