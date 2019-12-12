<!-- erstellt von Johannes Wolf -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<base href="${pageContext.request.requestURI}" />
		
		<title>Kategorieupload</title>
		
		<link rel="stylesheet" type="text/css" href="../css/header.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
	</head>
	<body>
	<div id="header">
			<%@include file="../jspf/header.jspf"%>
		</div>
		
		<form id="product"action="../KategorieUpload" method="post" enctype="multipart/form-data">
			<div>
				<label for="kategorie"> Kategorie:</label> <input type="text" list="kategorieList" name="kategorie" id="kategorie" required ><br />
				<button class="button" type="submit" value="submit">upload</button>
				<button class="button" name="reset" type="reset">zurücksetzen</button>
			</div>
		</form>
	</body>
</html>