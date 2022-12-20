<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">

<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
	crossorigin="anonymous"></script>
</head>
<body>
	<h1 class="text-info text-center my-3">Streaming Response</h1>
	
	
	 <div class="container">
	  
	   <ul id="output">
	   </ul>
	 
	 <button class="btn btn-danger" id="reqBtn">Request Send</button>
	 <button class="btn btn-success" id="sseTrigger">Connect Sse Source</button>
	 </div>
	
	<c:url value="/resources/js/client.js" var="jsLink"></c:url>
	<script type="text/javascript" src="${jsLink}"></script>
	
</body>
</html>