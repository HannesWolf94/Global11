<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<title>Password ändern</title>
</head>
<body>
	<header>
		<h1>Passwort erfolgreich geändert</h1>
	</header>
		<main>
		<div>
			<h3>Passwort wurde erfolgreich geändert</h3>
			<form action="benutzerverwaltung.jsp">
				<button class="button" type="submit" value ="Submit"> Weiter zur Profil </button>
			</form>
		</div>
		</main>
</body>
</html>