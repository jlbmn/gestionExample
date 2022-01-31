<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="css/style.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <title>Welcome Page</title>

</head>

<body>
<div class="sidenav">
         <div class="login-main-text">
            <h2>Application<br> JAVA EE</h2>
            <p>Gestion of employees</p>
            <br>
            <%= new Date() %>
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <h1>Welcome! </h1>
               <a class="btn btn-outline-dark btn-lg" href="login.jsp">Log in <i class="bi bi-box-arrow-in-right"></i></a>
            </div>
            <div><br>
            	<p class="text-danger">${msg }</p>
            </div>
         </div>
      </div>
</body>

</html>