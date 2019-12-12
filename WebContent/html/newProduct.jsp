<!-- erstellt von Martin Scherzer -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<base href="${pageContext.request.requestURI}" />
		
		<title>newProduct</title>
		
		<link rel="stylesheet" type="text/css" href="../css/header.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
	</head>
	<body>
		<div id="header">
			<%@include file="../jspf/header.jspf"%>
		</div>
		
		<h1>Herzlichen Glückwunsch! Ihr Produkt wurde erfolgreich gespeichert!</h1>
		
		<div>
			<form action="../ProductAnzeigen">
				<button class="button" type="submit" value="Submit">Weiter zur Produktverwaltung</button>
			</form>
		</div>
		
		<div id="footer">
			<%@include file="../jspf/footer.jspf"%>
		</div>
	</body>
</html>