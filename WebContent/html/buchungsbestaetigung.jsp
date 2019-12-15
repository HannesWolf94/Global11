<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<meta charset="UTF-8">

<base href="${pageContext.request.requestURI}" />

<title>Buchungsbestaetigung</title>

<link rel="stylesheet" type="text/css" href="../css/header.css" />
<link rel="stylesheet" type="text/css" href="../css/style.css" />
</head>
<body>
	<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>

	<h1>Herzlichen Glückwunsch! Ihre Buchung wurde erfolgreich
		entgegengenommen!</h1>

	<div>
		<form action="../WarenkorbAnzeigen">
			<button class="button" type="submit" value="Submit">Zum
				Warenkorb</button>
		</form>
	</div>

	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>