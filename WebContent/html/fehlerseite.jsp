<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fehlerseite</title>
</head>
<body>
	<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>
	<h1>Hoppla, irgendwas ist wohl schief gelaufen!</h1>
	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>