<!-- erstellt von Johannes Wolf -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			
		<base href="${pageContext.request.requestURI}" />
		
		<title>newKategorie</title>
		
		<link rel="stylesheet" type="text/css" href="../css/header.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
	</head>
	<body>
		<div id="header">
				<%@include file="../jspf/header.jspf"%>
			</div>
			
			<h1>Herzlichen Glückwunsch! Ihre Kategorie wurde erfolgreich angelegt!</h1>
			
			<div>
				<form action="../KategorieAnzeigen">
					<button class="button" type="submit" value="Submit">Weiter zum Produktupload</button>
				</form>
			</div>
			
			<div id="footer">
				<%@include file="../jspf/footer.jspf"%>
			</div>
	</body>
</html>