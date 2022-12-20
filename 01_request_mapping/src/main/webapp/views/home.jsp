<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>Welcome Home Controller</h1>

	<ul>
		<li>
		<c:url value="/multi" var="multiLink"></c:url>
		<a href="${multiLink}">Multi Action</a>
		</li>
		
		<li>
		<c:url value="/inputs" var="inputsLink"></c:url>
		<a href="${inputsLink}">User Input</a>
		</li>
		
		<li>
		<c:url value="/course" var="courseLink"></c:url>
		<a href="${courseLink}">Return Type Demo</a>
		</li>
	</ul>


</body>
</html>