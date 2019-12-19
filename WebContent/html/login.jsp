<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>

<meta charset="UTF-8">

<base href="${pageContext.request.requestURI}" />

<title>Login</title>

<link rel="stylesheet" type="text/css" href="../css/header.css" />
<link rel="stylesheet" type="text/css" href="../css/style.css" />
</head>
<body>
	<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>
	<h1>Einloggen</h1>
	<form action="${pageContext.request.contextPath}/Login" method="post">
		<div class="login">
			<p>
				<label for="email"> E-Mail:</label><br>
				<input type="text" name="email" id="email" maxlength="64" autofocus
					required> <br>
			</p>
			<p>
				<label for="password"> Passwort:</label><br>
				<input type="password" name="password" id="password" maxlength="45"
					required><br>
			</p>
			<button class="button" type="submit" value="Submit">Login</button>
		</div>
	</form>

	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>
