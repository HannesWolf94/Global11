<!-- erstellt von Johannes Wolf --> 
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
	<head>
	<meta charset ="UTF-8">
	
	<base href="${pageContext.request.requestURI}" />
	
	<title>Userverwaltung</title>
	
	
	<link rel="stylesheet" type="text/css" href="../css/header.css" />
	<link rel="stylesheet" type="text/css" href="../css/style.css" />
	
	<script src="../js/userSuche.js"></script>
	</head>
	<body>
		<div id="header">
			<%@include file="../jspf/header.jspf"%>
		</div>

		
		<h3>Trefferliste</h3>
		<div id="hitlist">Keine Treffer</div>	
		<c:forEach var="user" items="${users}" varStatus="status"> {
				"Id":${user.userId},
				"Email":"${user.email}",
				"Firstname":"${user.firstName}",
				"Lastname":"${user.lastName}",
			}<c:if test="${not status.last}">,</c:if>
		</c:forEach>


		<div id="footer">
			<%@include file="../jspf/footer.jspf"%>
		</div>
	</body>
</html>
