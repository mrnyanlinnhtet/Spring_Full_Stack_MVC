<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="lists" required="true"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>



<div class="container mt-5">
	<div class="card">
		<div class="card-header">
			<b>Login / Logout Access Information</b>
		</div>
		<div class="card-body">

			<table class="table table-striped table-hover">

				<thead class="table-dark">

					<tr>

						<th>ID</th>
						<th>LOGIN ID</th>
						<th>USERNAME</th>
						<th>TYPE</th>
						<th>TIME</th>

					</tr>

				</thead>

				<tbody>

					<c:forEach items="${infoList}" var="list">

						<tr>
							<td>${list.id}</td>
							<td>${list.loginId}</td>
							<td>${list.userName}</td>
							<td>${list.type}</td>
							<td>
							<app:date-time value="${list.accessTime}"></app:date-time>
							</td>


						</tr>

					</c:forEach>

				</tbody>

			</table>


		</div>
	</div>
</div>
