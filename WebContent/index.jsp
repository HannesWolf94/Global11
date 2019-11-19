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

    </body>
</html>
