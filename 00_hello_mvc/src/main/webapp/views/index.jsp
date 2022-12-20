<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello MVC</title>
</head>
<body>

  <h1>Welcome To Spring MVC Lessons</h1>
  
    <p>
       <c:out value="${message}"></c:out>
    </p>
    
    <ul>
    	<li>
    	  <c:url value="/legacy" var="legacyStyle"></c:url>
    	  <a href="${legacyStyle}">Legacy Controller</a>
    	</li>
    	
    	
    	<li>
    	  <c:url value="/router-demo" var="routerDemo"></c:url>
    	  <a href="${routerDemo}">Router Function</a>
    	</li>
    </ul>
    
</body>
</html>