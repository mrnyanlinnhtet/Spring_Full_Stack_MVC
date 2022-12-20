<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Demo</title>
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

	<div class="container">
		<h1 class="text-danger text-center my-4">
		 <sp:message code="app.title"></sp:message>
		</h1>

		<c:if test="${not empty allErrors}">
			<div class="alert alert-warning">
				<c:forEach var="e" items="${allErrors}" varStatus="sts">

					<span>${e}</span>
					<c:if test="${not sts.last}">
						<br />
					</c:if>

				</c:forEach>
			</div>
		</c:if>

		<sf:form modelAttribute="userInput">



			<sf:hidden path="id" />
			<div class="row">
				<div class="col">
					<sf:label path="name" cssClass="my-2">Student Name : </sf:label>
					<sf:input path="name" type="text" cssClass="form-control"
						placeholder="Enter Name !" />
					<sf:errors path="name" cssClass="text-danger"></sf:errors>
				</div>

				<div class="col">
					<sf:label path="phone" cssClass="my-2">Phone Number : </sf:label>
					<sf:input path="phone" type="tel" cssClass="form-control"
						placeholder="Enter Phone Number !" />
					<sf:errors path="phone" cssClass="text-danger"></sf:errors>
				</div>

				<div class="col">
					<sf:label path="email" cssClass="my-2">Email : </sf:label>
					<sf:input path="email" type="email" cssClass="form-control"
						placeholder="Enter Email !" />
					<sf:errors path="email" cssClass="text-danger"></sf:errors>
				</div>


			</div>

			<div class="row my-2">

				<div class="col">
					<sf:label path="password" cssClass="my-2">Password : </sf:label>
					<sf:input path="password" type="password" cssClass="form-control"
						placeholder="Enter Password !" />
					<sf:errors path="password" cssClass="text-danger"></sf:errors>
				</div>

				<div class="col">
					<sf:label path="course" cssClass="my-2">Courses : </sf:label>
					<sf:select path="course" cssClass="form-select">
						<sf:option value="">Select One</sf:option>
						<sf:options items="${courses}" itemValue="id" />
						<!-- If Converter nedd itemLable -->
					</sf:select>
					<sf:errors path="course" cssClass="text-danger"></sf:errors>
				</div>

				<div class="col">
					<sf:label path="registrationDate" cssClass="my-2">Registration Date : </sf:label>
					<sf:input path="registrationDate" cssClass="form-control"
						type="date" />
				</div>


			</div>

			<div class="row my-2">

				<div class="col-4">

					<sf:label path="genders" cssClass="my-2">Genders : </sf:label>
					<div>
						<sf:radiobuttons path="genders"
							cssClass="mx-2 form-check form-check-inline" items="${genders}" />
					</div>


				</div>

				<div class="col">
					<sf:label path="foundations" cssClass="my-2">Knowledge : </sf:label>
					<div>

						<sf:checkboxes items="${foundations}" cssClass="mx-2"
							path="foundations" />

					</div>
				</div>

				<div class="col">
					<sf:label path="agree" cssClass="my-2">Agree Conditions : </sf:label>
					<div>
						<sf:checkbox path="agree" label="Yes I Agree !" cssClass="mx-2" />
					</div>

				</div>

			</div>

			<div class="my-3">

				<sf:label path="remark" cssClass="my-2">Remark : </sf:label>
				<sf:textarea path="remark" cssClass="form-control" />

			</div>

			<button type="submit" class="btn btn-outline-success my-2">Save
				Data</button>

		</sf:form>

	</div>

	<div class="container my-5">
		<h1 class="text-center text-primary">Data Information</h1>
		<table class=" table table-hover table-primary my-4">

			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Password</th>
					<th>Course</th>
					<th>Registration Date</th>
					<th>Gender</th>
					<th>Foundation</th>
					<th>Agreement</th>
					<th>Remark</th>
				</tr>
			</thead>

			<tbody>


				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.id}</td>
						<td>${list.name}</td>
						<td>${list.phone}</td>
						<td>${list.email}</td>
						<td>${list.password}</td>
						<td>${list.course.name}</td>
						<td>${list.registrationDate}</td>
						<td>${list.genders}</td>
						<td>${list.foundations}</td>
						<td>${list.agree}</td>
						<td>${list.remark}</td>
					</tr>
				</c:forEach>


			</tbody>

		</table>

	</div>

</body>
</html>