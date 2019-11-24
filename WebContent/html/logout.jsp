<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<title>Abmelden</title>
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
			<h3>Sie haben sich erfolgreich ausgeloggt</h3>
		</form>
		<form action=${pageContext.request.contextPath}/index.jsp>
			<button class="button" type="submit" value="Submit">Weiter
				zur Startseite</button>
		</form>
	</div>
	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>