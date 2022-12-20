<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New</title>
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
			<h3 class="card-header text-success">${book.id eq 0 ? 'Add':'Edit' } Book</h3>
			
			 <sf:form action="/home"  method="post" cssClass="card-body" modelAttribute="book">
			 
			  <sf:hidden path="id"/>
			  
			   <div class="row">
			   
			   <div class="col">
			   
			   <div class="form-group">
			   <label for="category" class="my-2"><strong>Category : </strong></label>
			   <sf:select path="category" cssClass="form-select">
			    <option value="">Select One</option>
			    <sf:options items="${categories}" itemValue="id" itemLabel="name"/>
			   </sf:select>
			     <sf:errors path="category" cssClass="text-danger"></sf:errors>
			   </div>
			   
			   </div>
			   <!-- End of Col 0 -->
			    <div class="col">
			    
			    <div class="form-group">
			     <label for="title" class="my-2"><strong>Book Title : </strong></label>
			     <sf:input path="title" cssClass="form-control" placeholder="Enter Book Title !"/>
			       <sf:errors path="title" cssClass="text-danger"></sf:errors>
			    </div>
			    
			    </div>
			    <!-- End Of Col 1 -->
			    <div class="col">
			    
			    <div class="form-group">
			     <label for="author" class="my-2"><strong>Author : </strong></label>
			     <sf:input path="author" cssClass="form-control" placeholder="Enter Book's Author !"/>
			       <sf:errors path="author" cssClass="text-danger"></sf:errors>
			    </div>
			    
			    </div>
			      <!-- End Of Col 1 -->
			   </div>
			    <!-- End Of Row -->
			    
	    <div class="row my-3">
	   
	    <div class="col-4">
	    
	     <div class="form-group">
	     <label for="price" class="my-2"><strong>Price : </strong></label>
	     <sf:input path="price" type="number" cssClass="form-control" placeholder="Please Enter Price !"/>
	       <sf:errors path="price" cssClass="text-danger"></sf:errors>
	     </div>
	    
	    </div>
	    <!-- End of col 0 row2 -->
	    
	    <div class="col">
	    
	     <div class="form-group">
	     <label for="remark" class="my-2"><strong>Remark : </strong></label>
	     <sf:input path="remark" cssClass="form-control" placeholder="Please Enter Your Remark !"/>
	       <sf:errors path="remark" cssClass="text-danger"></sf:errors>
	     </div>
	    </div>
	    <!-- End of col 1 row2 -->
	   </div>
	   
	   <div class="row">
	   <div class="col">
	   <button class="btn btn-danger">Save Book</button>
	   </div>
	   </div>
	   
	   <!-- End of Row -->
			 </sf:form>

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