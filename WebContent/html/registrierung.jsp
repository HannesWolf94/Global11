<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
	<head>
	<meta charset ="UTF-8">
	
	<base href="${pageContext.request.requestURI}" />
	
	
	<title>Registrierung</title>
	
	<link rel="stylesheet" type="text/css" href="../css/header.css" />
	<link rel="stylesheet" type="text/css" href="../css/style.css" />
	
	<script src="../js/regiPwCheck.js"></script>
	</head>
	<body>
		<div id="header">
			<%@include file="../jspf/header.jspf"%>
		</div>
		
		<form action="../Registrierung" method="post">
			<div>
				<label for="email"> E-Mail:</label> <input type="email" name="email" id="email" required autofocus><br/>
				<label for="pwRegi"> Passwort:</label>  <input type="password" name="password" id="pwRegi" required><br/> 
				<label for="pwRegiR"> Passwort wiederholen:</label> <input type="password" name="passwordRepeat" id="pwRegiR" required><br />
				<label for="firstname"> Vorname:</label> <input type="text" name="firstname" id="firstname" required><br/> 
				<label for="lastname"> Nachname:</label> <input type="text" name="lastname" id="lastname" required><br/> 
				<label for="street">Straße und Hausnummer.: </label> <input type="text" name="street" id="street" required><br/> 
				<label for="city">PLZ und Ort: </label> <input type="text" name="city" id="city" required><br/>
				<button class="button" type="submit" value="Submit">registrieren</button>
				<button class="button" name="Reset" type="reset">zurücksetzen</button>
			</div>
		</form>
		
		<div id="footer">
			<%@include file="../jspf/footer.jspf"%>
		</div>
	</body>
</html>