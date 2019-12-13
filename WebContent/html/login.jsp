<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
	<head>
		<meta http-equiv="Content-Type" content="text/html">
		<meta charset ="UTF-8">
	
		<base href="${pageContext.request.requestURI}" />
		
		<title>Login</title>
		
		<link rel="stylesheet" type="text/css" href="../css/header.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
		
		<script type="text/javascript" src="../js/cookieCheck.js"></script>
	</head>
	<body>
		<div id="header">
			<%@include file="../jspf/header.jspf"%>
		</div>
		
		<form action="${pageContext.request.contextPath}/Login" method="post">
			<div>
			<p>
				<label for="email"> E-Mail:</label> <input type="text" name="email" id="email" maxlength="64" autofocus required>
			</p>
			<p>
				<label for="password"> Passwort:</label> <input type="password" name="password" id="password" maxlength="45" required>
			</p>
				<button class="button" type="submit" value="Submit">Login</button>
			</div>
		</form>
		
		<div id="footer">
			<%@include file="../jspf/footer.jspf"%>
		</div>
	</body>
</html>
