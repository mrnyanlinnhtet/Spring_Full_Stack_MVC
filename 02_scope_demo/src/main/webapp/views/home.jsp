<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
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

	<div class="container">

		<h1 class="text-center text-primary my-4">Home Page of Scope Demo</h1>

		<div class="row">

			<div class="col">
				<div class="card">
					<div class="card-header">Request Scope</div>
					<div class="card-body">
						<h1 class="text-center text-info">${request}</h1>
					</div>
				</div>
			</div>

			<div class="col">
				<div class="card">
					<div class="card-header">Session Scope</div>
					<div class="card-body">
						<h1 class="text-center text-danger">${session}</h1>
					</div>
				</div>
			</div>

			<div class="col">
				<div class="card">
					<div class="card-header">Application Scope</div>
					<div class="card-body">
						<h1 class="text-center text-primary">${application}</h1>
					</div>
				</div>
			</div>
		</div>



		<h1 class="text-center text-danger my-4">Access Scope Object</h1>

		<div class="row">

			<div class="col">
				<div class="card">
					<div class="card-header">Request Scope</div>
					<div class="card-body">
						<h1 class="text-center text-info">${requestScope.counter.count}</h1>
					</div>
				</div>
			</div>

			<div class="col">
				<div class="card">
					<div class="card-header">Session Scope</div>
					<div class="card-body">
						<h1 class="text-center text-danger">${sessionScope.counter.count}</h1>
					</div>
				</div>
			</div>

			<div class="col">
				<div class="card">
					<div class="card-header">Application Scope</div>
					<div class="card-body">
						<h1 class="text-center text-primary">${applicationScope.counter.count}</h1>
					</div>
				</div>
			</div>
		</div>

		<c:url value="/" var="home"></c:url>
		<a href="${home}" class="btn btn-success my-4">Reload Home Page</a>
		
		<c:url value="/create-session" var="createSession"></c:url>
		<a href="${createSession}" class="btn btn-dark my-4">Go Session Demo</a>

	</div>

</body>
</html>