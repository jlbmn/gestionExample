<!DOCTYPE html>
<html lang="fr">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="${pageContext.request.contextPath}/styles/style.css" rel="stylesheet" >
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <title>EMPLOYEE FORM</title>
    <style>
    
    </style>
</head>

<body>
	<form:form modelAttribute="employee" action="employeeForm" method="post">
		<br>
		<label>Enter First Name </label>
		<br>
		<br>
		<form:input path="firstName" name="firstName"/>
		<form:errors path="firstName" cssClass="errorblock" element="div" />
		
		<br>
		<br>
		<label>Enter Last Name </label>
		<br>
		<br>
		<form:input path="lastName" name="lastName"/>
		<form:errors path="lastName" cssClass="errorblock" element="div" />
		
		<br>
		<br>
		<input type="submit" value="Register">
		<br>
	</form:form>
</body>
</html>