<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About Book</title>
<c:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"></c:url>
<c:url value="/resources/js/bootstrap.bundle.min.js" var="bootstrapJs"></c:url>
<link type="text/css" rel="stylesheet" href="${bootstrapCss}" />
<script type="text/javascript" src="${bootstrapJs}"></script>
</head>
<body>

	<div class="container">
		<h1 class="my-5 text-danger text-center">
			<spring:message code="app.edit.title"></spring:message>
		</h1>

		<div class="row mb-4">
			<div class="col-9">
			
		<div class="card">
			<h3 class="card-header text-success">About Book</h3>
			
			 <div  class="card-body">
			  
			   <div class="row">
			   
			   <div class="col">
			   
			   <div class="form-group">
			   <label for="category" class="my-2"><strong>Category : </strong></label>
			    <span class="form-control">${book.category.name}</span>
			   </div>
			   
			   </div>
			   <!-- End of Col 0 -->
			    <div class="col">
			    
			    <div class="form-group">
			     <label for="title" class="my-2"><strong>Book Title : </strong></label>
			    <span class="form-control">${book.title}</span>
			    </div>
			    
			    </div>
			    <!-- End Of Col 1 -->
			    <div class="col">
			    
			    <div class="form-group">
			     <label for="author" class="my-2"><strong>Author : </strong></label>
			    <span class="form-control">${book.author}</span>
			    </div>
			    
			    </div>
			      <!-- End Of Col 1 -->
			   </div>
			    <!-- End Of Row -->
			    
	    <div class="row my-3">
	   
	    <div class="col-4">
	    
	     <div class="form-group">
	     <label for="price" class="my-2"><strong>Price : </strong></label>
	   <span class="form-control">${book.price}</span>
	     </div>
	    
	    </div>
	    <!-- End of col 0 row2 -->
	    
	    <div class="col">
	    
	     <div class="form-group">
	     <label for="remark" class="my-2"><strong>Remark : </strong></label>
	   <span class="form-control">${book.remark}</span>
	     </div>
	    </div>
	    <!-- End of col 1 row2 -->
	   </div>
	   
	   <div class="row">
	   <div class="col">
	   <c:url value="/books/edit" var="editUrl">
	   <c:param name="id" value="${book.id}"></c:param>
	   </c:url>
	   <a href="${editUrl }" class="btn btn-danger">Edit Book</a>
	   </div>
	   </div>
	   
	   <!-- End of Row -->
			 </div>

		</div>
			<!-- End of Card -->
			</div>

			<!-- End of Col 9 -->

			<div class="col">
				<c:import url="/views/import/left-bar.jsp"></c:import>
			</div>
		</div>
		
	   <!-- End of row -->
	   
	  

	</div>
</body>
</html>