<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Home Page</title>

</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="main.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Manage Employees </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">Add employee</a> 
					<a class="dropdown-item" href="#">List of employees</a>
				</div></li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search by last name" aria-label="Search">
			<button class="btn btn-outline-light my-2 my-sm-0" type="submit"><i class="bi bi-search"></i></button>
		</form>
		<form action="logout" class="form-inline ml-3 my-3 my-lg-0">
			<button class="btn btn-outline-light ml-4" type="submit">
				<i class="bi bi-box-arrow-right"></i>
			</button>
		</form>

	</div>
	</nav>




</body>
</html>