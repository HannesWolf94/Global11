<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
	<base href="${pageContext.request.requestURI}" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Registrierung</title>
</head>
<body>
	<form action="../Registrierung" method="post">
		<div>
		<label for="email"> email:</label> <input type="email" name="email"><br/>		
		<label for="password"> Password:</label> <input type="password" name= "password"><br/>
		<label for="firstname"> Vorname:</label> <input type="text" name="firstname"><br/>
		<label for="lastname"> Nachname:</label> <input type="text" name="lastname"><br/>
		<label for="street">Straße u. Hausnr.: </label> <input type="text" name="street"><br/>
		<label for="city">PLZ u. Ort: </label> <input type="text" name="city"><br/>
		
		<button class="button" type="submit" value ="Submit"> registrieren </button>
		</div>
	</form>

</body>
</html>