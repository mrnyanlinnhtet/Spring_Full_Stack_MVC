<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
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

         <div class="container mt-5">
           <h1 class="text-danger text-center">Sign UP Now !</h1>
           
            <div class="row">
            <div class="col-5">
            
             <sf:form action="/signup" method="post" modelAttribute="dto">
             
             <div class="form-group my-4">
               <sf:label for="name" path="name"><b>Name : </b></sf:label>
                <sf:input path="name" type="text" name="name" id="name" cssClass="form-control" placeholder="Enter Name !"/>
                <sf:errors path="name" cssClass="text-danger"></sf:errors>
               </div>
               
               <div class="form-group my-4">
               <sf:label for="loginId" path="loginId"><b>LoginId : </b></sf:label>
                <sf:input path="loginId" type="text" name="loginId" id="loginId" cssClass="form-control" placeholder="Enter Login Id !"/>
                  <sf:errors path="loginId" cssClass="text-danger" ></sf:errors>
               </div>
               
               <div class="form-group my-4">
               <sf:label for="password" path="password"><b>Password : </b></sf:label>
                <sf:input path="password" type="password" name="password" id="password" cssClass="form-control" placeholder="Enter Password !"/>
                <sf:errors path="password"  cssClass="text-danger"></sf:errors>
               </div>
              
               <button type="submit" class="btn btn-outline-success">Sign Up</button>
                <a href="/signin" class="btn btn-outline-primary">Sign In</a>
              
              
             
             </sf:form>
              
            </div>
            </div>
         </div>

</body>
</html>