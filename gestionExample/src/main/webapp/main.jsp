<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<link href="css/style.css" rel="stylesheet" id="bootstrap-css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Home Page</title>

</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="main.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> Manage Employees </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="form.jsp"> Add Employee </a> <a
						class="dropdown-item" href="emp"> List of Employees </a>
				</div></li>
		</ul>
		<form class="form-inline my-2 my-lg-0" action="search" method="post">
			<input class="form-control mr-sm-2" type="search" name="searchNames"
				placeholder="Enter first name and last name" aria-label="Search">
			<button class="btn btn-outline-light my-2 my-sm-0" type="submit">
				<i class="bi bi-search"></i>
			</button>
		</form>
		<form action="logout" class="form-inline ml-3 my-3 my-lg-0">
			<button class="btn btn-outline-light ml-4" type="submit">
				<i class="bi bi-box-arrow-right"></i>
			</button>
		</form>

	</div>
</nav>

<div class="container-fluid">
	<p class="text-primary mt-2">${msg } </p>
	<c:if test="${not empty employees }">
		<br>
		<h3>List of Employees</h3>
		<table class="table table-bordered text-center">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Employee id</th>
					<th scope="col">First name</th>
					<th scope="col">Last name</th>
					<th scope="col">Title</th> 
					<th scope="col">Start date</th>
					<th scope="col" colspan="2">Manage Employee</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${employees }" var="emp">
					<tr>
						<c:set var="emp" value="${emp }" />
						<td>${emp.empId }</td>
						<td>${emp.firstName }</td>
						<td>${emp.lastName }</td>
						<td>${emp.title }</td>
						<td>${emp.startDate }</td>
						
						<td>
						<form action="update" method="get">
							<input type="hidden" name="empId" value="${ emp.empId }"/>
							<button type="submit">
								<i class="bi bi-pencil"></i>
							</button>
						</form>
						</td>
						
						<td>
						<form action="delete" method="get">
							<input type="hidden" name="empId" value="${ emp.empId }"/>
							<button type="submit" onclick="return confirm('Do you really want to delete this employee ?');">
								<i class="bi bi-trash"></i>
							</button>
						</form>
							
							
						</td>
					</tr>

				</c:forEach>
			</tbody>

		</table>
	</c:if>
</div>


</body>
</html>