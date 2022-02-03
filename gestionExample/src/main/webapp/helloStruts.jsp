<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello Struts 2! </title>
</head>
<body>
	<h2> 
		<s:property value="messageStore.message" />
	</h2>
	<hr>
	<h2>
		<s:property value="name" />
	</h2>
		<h2>
		<s:property value="personne" />
	</h2>
</body>
</html>