<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>
     <a href="?lang=en" class="btn btn-sm btn-success">English</a> <a href="?lang=fr" class="btn btn-sm btn-success">French</a>

	<h2><spring:message code="label.heading"/></h2>
	<h2><spring:message code="label.title"/></h2>
	<h2><spring:message code="label.homeMessage"/></h2>
	<h1>${ message} <br> ${ emp }</h1>

</body>
</html>