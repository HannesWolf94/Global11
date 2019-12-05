<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrierung</title>
<script type="text/javascript" src="../js/regiPwCheck.js"></script>
<script type="text/javascript" src="../js/cookieCheck.js"></script>
</head>
<body>
	<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>
	<form action="../Registrierung" method="post">
		<div>
			<label for="email"> E-Mail:</label> <input type="email" name="email" id="email"><br />
			<label for="pwRegi"> Passwort:</label> <input type="password"
				name="password" id="pwRegi"><br /> <label for="pwRegiR">
				Passwort wiederholen:</label> <input type="password" name="passwordRepeat" id="pwRegiR"><br />
			<label for="firstname"> Vorname:</label> <input type="text"
				name="firstname" id="firstname"><br /> <label for="lastname">
				Nachname:</label> <input type="text" name="lastname" id="lastname"><br /> <label
				for="street">Straße und Hausnummer.: </label> <input type="text"
				name="street" id="street"><br /> <label for="city">PLZ und Ort:
			</label> <input type="text" name="city" id="city"><br />
			<button class="button" type="submit" value="Submit">
				registrieren</button>
			<button class="button" name="Reset" type="reset">zurücksetzen</button>
		</div>
	</form>
<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>