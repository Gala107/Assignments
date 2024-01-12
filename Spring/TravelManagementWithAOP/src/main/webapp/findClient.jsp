<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Make a Reservation</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css"/>

</head>
</head>
<body>
	<div class="center">
		<%@include file="navigationBar.html"%>
		<h1>Make a Reservation</h1>
		
		<form action="getClient" method="post">
			<ul>
				<li class="warning">${requestScope.msg}</li>
				<li><label for="findBy">Find Client by</label>
				<input type="radio" id="findBy" name="findBy" value="phone"> Phone
				<input type="radio" id="findBy" name="findBy" value="email"> Email</li>
				<li><input type="text" id="clientInfo" name="clientInfo"></li>
				<li><input type="submit" value="Submit"></li>
				<li><a href="makeReservation.jsp">New Client Reservation</li>
			</ul>
		</form>
	</div>
</body>
</html>