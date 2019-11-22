<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<title>Password ändern</title>
</head>
<body>
	<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>

		<h1>Passwort erfolgreich geändert</h1>

		<div>
			<h3>Passwort wurde erfolgreich geändert</h3>
			<form action="kontobereich.jsp">
				<button class="button" type="submit" value ="Submit"> Weiter zur Profil </button>
			</form>
		</div>
			<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>