<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.requestURI}" />
<title>Password ändern</title>
<link rel="stylesheet" type="text/css" href="../css/header.css" />
<link rel="stylesheet" type="text/css" href="../css/style.css" />
</head>
<body>
	<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>

	<h1>Passwort erfolgreich geändert</h1>

	<div>
		<h3>Passwort wurde erfolgreich geändert</h3>
		<form action="kontobereich.jsp">
			<button class="button" type="submit" value="Submit">Weiter
				zum Profil</button>
		</form>
	</div>
	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>