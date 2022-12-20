<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Input</title>
</head>
<body>
   <h1>User Input</h1>
    <!-- Path Parameter -->
    <div>
      <c:if test="${not empty type and not empty id }">
      
        <h3>Type is ${type}</h3>
        <h3>Id   is ${id}</h3>
      
      </c:if>
    </div>
    
    <!-- Date Parameter -->
    <div>
     <c:if test="${not empty date}">
       <h3>${date}</h3>
     </c:if>
    
    </div>
  <!-- Link  -->
        <ul>
        	<li>
        	<c:url value="/inputs/path type/search/1001" var="pathVariable"></c:url>
        	<a href="${pathVariable}">Path Variable</a>
        	</li>
        	
        	
        	<li>
        	<c:url value="/inputs/2022-07-07" var="dateParam"></c:url>
        	<a href="${dateParam}">Date Parameter</a>
        	</li>
        	
        	<li>
        	<c:url value="/inputs/Basic" var="enumLink"></c:url>
        	<a href="${enumLink}">Enum Parameter</a>
        	</li>
        	
        	
        	<li>
        	<c:url value="inputs/matrix/Vetor;s=L;c=3" var="matrixLink"></c:url>
        	<a href="${matrixLink}">Matrix Parameter</a>
        	</li>
        	
          <li>
          <c:url value="/inputs/requestParam?p=tesla&c=sModel&m=2010" var="requestLink"></c:url>
          <a href="${requestLink}">Request Parameter</a>
          </li>
        	
        	
        </ul>
</body>
</html>