<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
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
 
    <div class="container my-5">
     <h1 class="text-danger text-center">Sign In Now !</h1>
     
     <div class="row">
            <div class="col-5">
              <form action="/signin" method="post">
              
               <div class="form-group my-4">
               <label for="loginId"><b>LoginId : </b></label>
                <input type="text" name="loginId" id="loginId" class="form-control" placeholder="Enter Login Id !"/>
               </div>
               
               <div class="form-group my-4">
               <label for="password"><b>Password : </b></label>
                <input type="password" name="password" id="password" class="form-control" placeholder="Enter Password !"/>
               </div>
              
               <a href="/" class="btn btn-outline-info">Home</a>
                <button type="submit" class="btn btn-outline-success">Sign In</button>
              
              
              </form>
            
            </div>
            </div>
    
    </div>

</body>
</html>