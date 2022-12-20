<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<c:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"></c:url>
<c:url value="/resources/js/bootstrap.bundle.min.js" var="bootstrapJs"></c:url>
<link type="text/css" rel="stylesheet" href="${bootstrapCss}"/>
<script type="text/javascript" src="${bootstrapJs}"></script>
</head>
<body>

    <div class="container">
    <h1 class="my-5 text-danger text-center">
    <spring:message code="app.title"></spring:message>
   </h1>
   
    <c:url value="/views/import/upload-message.jsp" var="messageUpload"></c:url>
    <c:import url="${messageUpload}"></c:import>
     
     
     <div class="row">
    
      <!-- Table Start -->
      <div class="col-9">
      
      <div class="card">
       <h3 class="card-header text-info">BOOK LIST</h3>
       <div class="card-body">
       
       <table class="table table-hover table-success">
   
      <thead>
      
       <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Category</th>
        <th>Price</th>
        <th>Remarks</th>
       
       </tr>
      
      </thead>
      
      <tbody>
      
       <c:forEach var="data" items="${list}">
       
       <tr>
       <td>${data.id}</td>
       <td>
      <c:url value="/books/edit" var="eUrl">
       <c:param name="id" value="${data.id}"></c:param>
      </c:url>
       <a href="${eUrl}" style="text-decoration: none">
          ${data.title }
       </a>
       </td>
       <td>${data.author }</td>
       <td>${data.category.name}</td>
       <td>${data.price } Kyats</td>
       <td>${data.remark }</td>
       </tr>
       
       </c:forEach>
      
      </tbody>
      
   </table>
  
       </div>
      </div>
      
      </div>
      
       <!-- end of table  -->
       
       <div class="col">
      
        <c:import url="/views/import/left-bar.jsp"></c:import>
       <!-- End of Form -->
      
      </div>
     </div>
  
    </div>
</body>
</html>