<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course List</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
	crossorigin="anonymous"></script>
</head>
<body>

<div class="container my-4">
   <h1 class="my-4">Course List</h1>
   
    <c:url value="/course/add/" var="courseNew"></c:url>
    <a href="${courseNew}" class="btn btn-primary my-4">New Course</a>
    <table class="table table-hover table-dark">
    
     <thead>
      <tr>
      
      <th>ID</th>
      <th>Name</th>
      <th>Level</th>
      <th>Fees</th>
      <th>Duration</th>
      
      </tr>
     
     </thead>
    <!-- End of table head -->
    
    <tbody>
    
      <c:forEach var="c" items="${list}">
      
        <tr>
        
         <td>${c.id}</td>
         
         <td>
         <c:url value="/course/${c.id}" var="detailUrl"></c:url>
         <a href="${detailUrl}">${c.name}</a>
         </td>
         <td>${c.level}</td>
         <td>${c.fees} MMK</td>
         <td>${c.duration} Months</td>
        
        </tr>
      
      </c:forEach>
    
    </tbody>
    </table>
</div>

</body>
</html>