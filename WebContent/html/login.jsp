<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${pageContext.request.requestURI}" />
	<meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
	<title>Login</title>
</head>
<body>
<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>

	<form action="${pageContext.request.contextPath}/Login" method="post">
		<div>
		<label for="email"> Name:</label> <input type="text" name="email" id="email">
		<label for="password"> Password:</label> <input type="password" name= "password" id="password">
		<button class="button" type="submit" value ="Submit"> login </button>
		</div>
	
	</form>
	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>