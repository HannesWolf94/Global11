<!-- erstellt von Michael Haid -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
	<head>
		<meta charset ="UTF-8">
		
		<base href="${pageContext.request.requestURI}" />
		
		<title>Abmelden</title>
		
		<link rel="stylesheet" type="text/css" href="../css/header.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
	</head>
	<body>
		<div id="header">
			<%@include file="../jspf/header.jspf"%>
		</div>
		
		<header>
			<h1>Abmelden</h1>
		</header>
		
		<div>
			<form method="post" action="/Logout">
				<h3>Sie wurden erfolgreich ausgeloggt.</h3>
			</form>
			<form action=${pageContext.request.contextPath}/index.jsp>
				<button class="button" type="submit" value="Submit">Weiter zur Startseite</button>
			</form>
		</div>
		
		<div id="footer">
			<%@include file="../jspf/footer.jspf"%>
		</div>
	</body>
</html>