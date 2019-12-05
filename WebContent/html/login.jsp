<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
<title>Login</title>
<script type="text/javascript" src="../js/cookieCheck.js"></script>
</head>
<body>
	<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>

	<form action="${pageContext.request.contextPath}/Login" method="post">
		<div>
			<label for="email"> E-Mail:</label> <input type="text" name="email"
				id="email" autofocus required> <label for="password"> Passwort:</label> <input
				type="password" name="password" id="password" required>
			<button class="button" type="submit" value="Submit">Login</button>
		</div>

	</form>
	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>