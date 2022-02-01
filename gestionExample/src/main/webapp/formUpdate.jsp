<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
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
					<a class="dropdown-item" href="emp"> Add Employee </a> <a
						class="dropdown-item" href="emp"> List of Employees </a>
				</div></li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search by last name" aria-label="Search">
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


<div class="container mx-auto">
         <div class="col-md-4">
         	<h3>Update Employee id = ${emp.empId }</h3>
				<form action="update" method="post">
				<input type="hidden" name="empId" value="${ emp.empId }"/>
					  <div class="form-group">
					    <label for="firstName">First name</label>
					    <input name="firstName" type="text" class="form-control" placeholder="Enter first name" value="${emp.firstName }">
					  </div>
					  <div class="form-group">
					    <label for="lastName">Last name</label>
					    <input name="lastName" type="text" class="form-control" placeholder="Enter last name" value="${emp.lastName }">
					  </div>
					  <div class="form-group">
					    <label for="startDate">Start date</label>
					    <input name="startDate" type="text" class="form-control" placeholder="Enter start date" value="${emp.startDate }">
					  </div>
					  <button type="submit" class="btn btn-black text-light">Submit</button>
			
				</form>
	</div>
	</div>



</body>
</html>