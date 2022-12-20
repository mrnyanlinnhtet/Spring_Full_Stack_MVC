<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Security Demo Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>

	<h1 class="text-center text-danger my-3">Web Security</h1>

	<div class="container my-4">
		<a href="/" class="btn btn-primary">Home</a>
		<a href="/admin" class="btn btn-success">Admin Home</a>
		<a href="/member" class="btn btn-secondary">Member Home</a>
		<s:authorize access="isAuthenticated()">
		<a href="/logout" class="btn btn-danger">Logout</a>
		</s:authorize>
		
	</div>
	 
	 <c:if test="${not empty title }">
	  <div class="container">
	      <div class="card">
	       <div class="card-header">${title}</div>
	       <div class="card-body">${message}</div>
	      </div>
	  </div>
	 </c:if>
	 
	 

</body>
</html>