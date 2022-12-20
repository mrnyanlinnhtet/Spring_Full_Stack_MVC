<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="card">
       <h3 class="card-header text-info">BOOK SEARCH</h3>
       <c:url value="/books" var="homeLink"></c:url>
        <form action="${homeLink}" class="card-body">
        
         <div class="form-group mb-2">
         <label class="col-form-label" for="category"><strong>Category : </strong></label>
         <select name="category" id="category" class="form-select">
            <option value="" selected="selected">Search Category</option>
             <c:forEach var="c" items="${categories}">
              <c:choose>
              <c:when test="${c.id eq param.category }">
                <option value="${c.id}" selected="selected">${c.name}</option>
              </c:when>
              
              <c:otherwise>
               <option value="${c.id}">${c.name}</option>
              </c:otherwise>
              
              </c:choose>
             </c:forEach>
           </select>
         </div>
         
         <div class="form-group mb-3">
         <label for="keyword" class="col-form-label"><strong>Keyword : </strong></label>
         <input type="text" class="form-control" autocomplete="off" value="${param.keyword}" name="keyword" placeholder="Enter Your Keyword !"/>
         </div>
         
         <div class="form-group">
          <button class="btn btn-primary form-control mb-2">Search</button>
          <a  id="uploadBtn" class="btn btn-secondary form-control mb-2">Upload</a>
          <c:url value="/books/edit" var="addNew"></c:url>
          <a href="${addNew}" class="btn btn-success form-control">Add New</a>
         </div> 
        
        </form>
        
        <c:url value="/upload" var="upload"></c:url>
         <form action="${upload }" method="post" id="uploadForm" class="d-none" enctype="multipart/form-data">
          <input type="file" id="uploadInput" name="uploadFile">
         </form>
         <c:url value="/resources/js/upload-file.js" var="jsLink"></c:url>
         <script type="text/javascript" src="${jsLink}"></script>
       </div>
       