<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="de">
    <head>
    	<base href="${pageContext.request.requestURI}" />
  		<meta http-equiv="Content-Type" charset="UTF-8"> <!-- ka was des http-Zeug is!! -->
  		<title>Startseite</title>
    </head>

    <body>
    	<nav>
            <%@include file="jspf/navigation.jspf"%>
    	</nav>
   <!--  <a href="index.jsp"> Home</a>

	<a href="html/login.jsp"> Login</a>

	<a href="html/logout.jsp"> Logout</a>
	
	<a href="html/productupload.jsp"> Produkt Upload</a>
	
	<a href="html/registrierung.jsp"> Registrierung </a>
	
	<a href="html/benutzerverwaltung.jsp"> Benutzerverwaltung </a> -->
	
    </body>
</html>
