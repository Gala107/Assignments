<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="st" uri="WEB-INF/mytag.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Custom Tags</title>
</head>
<body>
	<st:MyDate/>
	<st:CustomDateTag format="dd...mm...yy"/><br>
	
	<st:UpperCaseTag>this sentence will be displayed in uppercase!!!</st:UpperCaseTag>
	
</body>
</html>