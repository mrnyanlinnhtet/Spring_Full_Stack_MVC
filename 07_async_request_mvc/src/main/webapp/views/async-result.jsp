<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Async Result</title>
</head>
<body>

 <h1>Async Result</h1>
 
  <p>${message}</p>
  
  <br/>
  
  <c:url value="/" var="home"></c:url>
  <a href="${home}"><b>Home</b></a>
  
   <br />
   
   <h1>Callable Interceptor Messages</h1>
  
   <ul>
    <c:forEach var="data" items="${interceptorMessage}">
     
      <li>${data}</li>
    
    </c:forEach>
   </ul>
 

</body>
</html>