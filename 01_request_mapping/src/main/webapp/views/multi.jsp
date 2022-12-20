<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Multi Action</title>
<style type="text/css">

    ul li a {
    
         text-decoration: none;
         list-style: none;
    }
</style>
</head>
<body>

   <h1>Multi Action Demo</h1>
   
   <h3>${not empty message?message:'Defalut Action'}</h3><br />
   
   <ul>
    <c:url value="/multi/action1" var="action1"></c:url>
   	<li><a href="${action1}">Action1</a></li>
   	
   	<c:url value="/multi/action1?id=10" var="actionId"></c:url>
   	<li><a href="${actionId}">Action With Id</a></li>
   	
   	<c:url value="/multi/action2" var="action2"></c:url>
   	<li><a href="${action2}">Action2</a></li>
   	
   	<c:url value="/multi/asdf" var="wildCard"></c:url>
   	<li><a href="${wildCard}">Wild Card</a></li>
   	
   	<c:url value="/multi/100" var="digit"></c:url>
   	<li><a href="${digit}">Digit</a></li>
   
   </ul>

</body>
</html>