<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Edit</title>
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

       <div class="container my-5">
       
         <h1 style="text-align: center;font-size: 70px;color: steelblue;">Course Detail</h1>
         
          <div class="row">
          
           <div class="col-4">
           
            <c:if test="${ not empty result }">
              <div class="alert alert-success">
               ${result.message}
              </div>
            </c:if>
             <form>  
             <div class="from-group">
               
               <label  for="id" class="form-label my-3"><b>ID : </b></label>
               <input id="id" value="${course.id}" name="id" readonly="readonly" type="text" class="form-control" />
               
              </div>
             <!-- End of id  -->
             
             
              <div class="from-group">
               
               <label  for="name" class="form-label my-3"><b>Name : </b></label>
               <input id="name" value="${course.name}" name="name" readonly="readonly" type="text" class="form-control"  />
               
              </div>
             <!-- End of Name  -->
             
              <div class="from-group my-3">
               
               <label  for="level" class="form-label my-3"><b>Level : </b></label>
                <input type="text" value="${course.level}" readonly="readonly" class="form-control" />
               
              </div>
             <!-- End of Level  -->
             
              <div class="from-group">
               
               <label  for="duration" class="form-label my-3"><b>Duration : </b></label>
               <input id="duration" value="${course.duration}" readonly="readonly" name="duration" type="number" class="form-control"  />
               
              </div>
             <!-- End of Name  -->
             
              <div class="from-group">
               
               <label  for="fees" class="form-label my-3"><b>Fees : </b></label>
               <input id="fees" value="${course.fees}" readonly="readonly" name="fees" type="number" class="form-control" placeholder="Enter Course Fees !" />
               
              </div>
             <!-- End of Name  -->
             
              <div>
               <c:url value="/course/edit" var="editLink">
                <c:param name="id" value="${course.id}"></c:param>
               </c:url>
               <a href="${editLink}" class="btn btn-primary my-4">Edit Course</a> 
               
               <c:url value="/course" var="home"></c:url>
                <a href="${home}" class="btn btn-info my-4">Go Back Home</a>
                           
               </div>   
              <!-- End of Edit button  -->        
             </form>
           
           </div>
          
          
          </div>
       
       </div>
  

</body>
</html>