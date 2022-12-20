<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Security Demo</title>
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

<div class="container my-4">
            <h1 class="text-center text-danger">Security Demo Home</h1>
            
            <div class="container mt-5">
             <a href="/" class="btn btn-info">Home</a>
             <a href="/admin" class="btn btn-danger">Admin Home</a>
             <a href="/member" class="btn btn-secondary">Member Home</a>
             <sec:authorize access="isAnonymous()">
              <a href="/signup" class="btn btn-success">Sign Up</a>
             </sec:authorize>
             <sec:authorize access="isAuthenticated()">
             <a href="/signout" class="btn btn-warning">Sign Out</a>
             </sec:authorize>
             
            </div>
      </div>
      
      <div class="container mt-5">
       <img alt="cover photo" src="../resources/img/security.png">
      </div>

</body>
</html>