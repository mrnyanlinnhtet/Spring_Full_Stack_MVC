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
       
     <h1 style="text-align: center;font-size: 70px;color: steelblue;">${empty course.id?'Add New':'Edit'} Course</h1>
         
          <div class="row">
          
           <div class="col-4">
            
            <c:url value="/course" var="saveUrl"></c:url>
             <form action="${saveUrl}" method="post">
             
              <div class="from-group">
              
               <c:if test="${ not empty course }">
              <input type="hidden" class="form-control" name="id" value="${course.id}" />
             </c:if>
               
               <label  for="name" class="form-label my-3"><b>Name : </b></label>
               <input id="name" value="${course.name}" name="name" type="text" class="form-control" placeholder="Enter Course Name !" />
               
              </div>
             <!-- End of Name  -->
             
              <div class="from-group my-3">
               
               <label  for="level" class="form-label my-3"><b>Level : </b></label>
               <select name="level" id="level" class="form-control">
                <option value="" disabled="disabled" selected="selected">Select One</option>
                 <c:forEach var="item" items="${levels}">
                  <c:choose>
                  <c:when test="${course.level eq item}">
                   <option selected="selected" value="${item}">${item}</option>
                  </c:when>
                  <c:otherwise>
                  <option value="${item }" >${item}</option>
                  </c:otherwise>
                  </c:choose>
                  
                 </c:forEach>
               </select>
               
              </div>
             <!-- End of Level  -->
             
            
             
              <div class="from-group">
               
               <label  for="duration" class="form-label my-3"><b>Duration : </b></label>
               <input id="duration" value="${course.duration}" name="duration" type="number" class="form-control" placeholder="Enter Course Duration !" />
               
              </div>
             <!-- End of Name  -->
             
              <div class="from-group">
               
               <label  for="fees" class="form-label my-3"><b>Fees : </b></label>
               <input id="fees" name="fees" value="${course.fees}" type="number" class="form-control" placeholder="Enter Course Fees !" />
               
              </div>
             <!-- End of Name  -->
             
             <div>
               <button type="submit" class="btn btn-success my-4">${empty course.id?'Save':'Update' } Course</button>
             </div>
             
             </form>
           
           </div>
          
          
          </div>
       
       </div>
  

</body>
</html>