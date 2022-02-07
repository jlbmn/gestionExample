<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="fr">
<%@ taglib uri="/struts-tags" prefix="s" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="css/style.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <title>Examples Servlet</title>
	
	
	
</head>

<body>

	 <h1><s:text name = "global.heading"/></h1>
	 <p><s:text name = "global.subtitle"/></p>
	 
      <s:url var = "indexEN" namespace="/" action = "locale" >
         <s:param name = "request_locale" >en</s:param>
      </s:url>
      
      <s:url var = "indexFR" namespace="/" action = "locale" >
         <s:param name = "request_locale" >fr</s:param>
      </s:url>

      <s:a href="%{indexEN}" >English</s:a>
      <s:a href="%{indexFR}" >Français</s:a>
	 <br><br>
    
   	<s:form action="hello" method="post">
      <s:textfield name="personne.firstName" key="global.firstName" />
      <s:textfield name="personne.lastName" key="global.lastName" />
      <s:radio name="personne.gender" key="global.gender" list="#{'male':'male', 'female':'female'}" />
      <s:textfield name="personne.email" key="global.email" />
      <s:textfield type="int" name="personne.age" key="global.age" />
      <s:textfield type="date" name="personne.birthday" key="global.birthday" />
      <s:submit value="Submit"/>
    </s:form>	


</body>

</html>