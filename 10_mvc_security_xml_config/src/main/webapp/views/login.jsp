<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
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
      
         <div class="row">
          <div class="col-4">
          
           <div class="card">
           <div class="card-header">Login Form</div>
           
            <form action="/login" method="post" class="card-body">
            
              <div class="form-group my-3">
               <label for="loginId" class="form-label"><b>Login Id : </b></label>
               <input type="text" class="form-control" name="loginId" id="loginId" placeholder="Enter Login Id !" />
              </div>
              
               <div class="form-group my-3">
               <label for="password" class="form-label"><b>Password : </b></label>
               <input type="password" class="form-control" name="password" id="password" placeholder="Enter Password !">
               
               </div>
               
               <div class="form-group">
                <button type="submit" class="btn btn-success">Login</button>
               </div>
            
            </form>
           
           </div>
          
          </div>
         </div>
      
      </div>

</body>
</html>