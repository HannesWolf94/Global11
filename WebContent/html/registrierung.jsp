<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrierung</title>
<script type="text/javascript" src="../js/regiPwCheck.js"></script>
</head>
<body>
	<form action="../Registrierung" method="post">
		<div>
			<label for="email"> email:</label> <input type="email" name="email" id="email"><br />
			<label for="pwRegi"> Passwort:</label> <input type="password"
				name="password" id="pwRegi"><br /> <label for="pwRegiR">
				Passwort wiederholen:</label> <input type="password" name="passwordRepeat" id="pwRegiR"><br />
			<label for="firstname"> Vorname:</label> <input type="text"
				name="firstname" id="firstname"><br /> <label for="lastname">
				Nachname:</label> <input type="text" name="lastname" id="lastname"><br /> <label
				for="street">Straße u. Hausnr.: </label> <input type="text"
				name="street" id="street"><br /> <label for="city">PLZ u. Ort:
			</label> <input type="text" name="city" id="city"><br />
			<button class="button" type="submit" value="Submit">
				registrieren</button>
			<button class="button" name="Reset" type="reset">zurücksetzen</button>
		 

		</div>
	</form>

</body>
</html>