<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>

 <h1>Error Result</h1>
 
  <p>${message}</p>
  
  <br/>
  
  <c:url value="/" var="home"></c:url>
  <a href="${home}"><b>Home</b></a>
 

</body>
</html>