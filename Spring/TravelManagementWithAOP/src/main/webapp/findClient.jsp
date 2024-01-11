<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Make a Reservation</title>
<link rel="stylesheet" href="/TravelManagementWithAOP/css/styles.css" />
</head>
</head>
<body>
	<div class="center">
		<%@include file="navigationBar.html"%>
		<h1>Make a Reservation</h1>
		<form method="post">
			<ul>
				<li><label for="findBy">Find Client by</label>
				<input type="radio" id="findBy" name="phone"> Phone
				<input type="radio" id="findBy" name="email"> Email</li>
				<li><input type="text" id="clientInfo" name="clientInfo"></li>
				<li><input type="submit" value="Submit"></li>
				<li><a href="makeReservation.jsp">New Client Reservation</li>
			</ul>
		</form>
	</div>
</body>
</html>