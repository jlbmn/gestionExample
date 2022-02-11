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
    <title>Examples Servlet</title>
    <style>
    
    </style>
</head>

<body>
<div class="sidenav">
         <div class="login-main-text">
            <h2>${message }</h2>

            <h2><spring:message code="label.heading"/></h2>
         </div>
      </div>
      <div class="main">
      	
      	<!-- choose a language -->
     	<div style="text-align: center;padding:5px 0;margin:0;">
	       <a href="${pageContext.request.contextPath}/index?lang=en">Login (English)</a>
	       &nbsp;&nbsp;
	       <a href="${pageContext.request.contextPath}/index?lang=fr">Login (French)</a>
    	</div>
      
      <!-- login form -->
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form:form action="home" method="POST" modelAttribute="user">
                  <div class="form-group">
                     <label><spring:message code="label.username"/></label>
                     <input type="text" class="form-control" placeholder="<spring:message code="label.username"/>" name="login">
                  </div>
                  <div class="form-group">
                     <label><spring:message code="label.password"/></label>
                     <input type="password" class="form-control" placeholder="<spring:message code="label.password"/>" name="password">
                  </div>
                  <button type="submit" class="btn btn-black"><spring:message code="label.login"/></button>
                  <button type="submit" class="btn btn-secondary"><spring:message code="label.register"/></button>
               </form:form>
            </div>
         </div>
      </div>
</body>

</html>