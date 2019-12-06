<%-- erstellt von Michael Haid--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.requestURI}" />
<title>Kontobereich</title>
<link rel="stylesheet" type="text/css" href="../css/header.css" />
<link rel="stylesheet" type="text/css" href="../css/style.css" />
</head>
<body>
	<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>
	<form method=post
		action="${pageContext.request.contextPath}/KontoAendern">
		<div>
			<label for="firstName"> Vorname: </label><br> <input
				name="firstName" id="firstName" type="text"
				value="${user.firstName}">
		</div>
		<div>
			<label for="lastName">Nachname: </label><br> <input
				name="lastName" type="text" id="lastName" value="${user.lastName}">
		</div>
		<div>
			<label for="street"> Straße und Hausnummer: </label> <br> <input
				name="street" type="text" id="street" value="${user.street}">
		</div>
		<div>
			<label for="city"> PLZ und Ort: </label> <br> <input name="city"
				type="text" id="city" value="${user.city}">
		</div>
		<div>
			<label for="email"> E-Mail:</label>
			<p>${user.email}</p>
			<br>
		</div>
		<div>

			<button class="button" name="submit" type="submit">Daten ändern und speichern</button>
			<button class="button" name="reset" type="reset">zurücksetzen</button>
		</div>
	</form>
	<form id="password"
		action="${pageContext.request.contextPath}/Password" method="post">
		<div>
			<label for="pw"> altes Passwort: </label> <br> <input
				type="password" name="oldPassword" id="pw" size="15" required>
		</div>
		<div>
			<label for="newPassword"> neues Passwort: </label> <br> <input
				type="password" name="newPassword" id="newPassword" size="15"
				required>
		</div>
		<div>
			<label for="passwordConfirmation"> Passwort bestätigen: </label><br>
			<input type="password" id="passwordConfirmation"
				name="passwordConfirmation" size="15" required>
		</div>
		<div>
			<button class="button" name="submit" type="submit">Passwort
				ändern</button>
		</div>
	</form>
	<form method="post"
		action="${pageContext.request.contextPath}/AccountLoeschen">
		<fieldset>
			<div>
				<label for="email"> Konto löschen:</label> <input type="text"
					name="email" id="email" placeholder="Bitte Ihre Email eingeben"
					required>

			</div>
			<div>
				<button class="button" name="submit" type="submit">löschen</button>
				<button class="button" name="Reset" type="reset">zurücksetzen</button>
			</div>
		</fieldset>
	</form>
	<br>
	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>

</body>
</html>
