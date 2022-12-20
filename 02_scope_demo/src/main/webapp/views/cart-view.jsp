<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Demo</title>
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
 
  <div class="card">
   <h2 class="card-header">Using Session</h2>
   
   <div class="card-body">
   
    <div class="row">
    
    <c:url value="/add-item" var="action"></c:url>
     <form action="${action}" method="post">
      
      <div class="col-8">
       <label class="form-label"><b>Add Item : </b></label>
       <input type="text" name="data" placeholder="Please Enter Item !" class="form-control" />
      </div>
      
      <div class="col-auto my-3">
       <button type="submit" class="btn btn-success">Add Items</button>
       <c:url value="/clear-session" var="clearSession"></c:url>
       <a href="${clearSession}" class="btn btn-danger">Clear Items</a>
      </div>
     
     </form>
    </div>
   <!-- End of Row -->
   </div>
  </div>
  
    <div class="list-group my-4">
    
    <div class="list-group-item active">
      Items in Cart : ${sessionScope.cart.count }
    </div>
    
     <c:forEach var="item" items="${sessionScope.cart.list}">
      <div class="list-group-item">
       ${item}
      </div>
     </c:forEach>
    
    </div>
    
 </div>

</body>
</html>