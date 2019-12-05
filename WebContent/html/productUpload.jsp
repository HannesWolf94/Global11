<!-- erstellt von Martin Scherzer -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produktupload</title>
<link rel="stylesheet" type="text/css" href="../css/style.css" />
</head>
<body>
	<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>
	<form id="product"action="../ProductUpload" method="post" enctype="multipart/form-data">
		<div>
			<label for="label"> Marke:</label> <input type="text"
				list="labelList" name="label" id="label" required ><br />
			<datalist id="labelList">
				<option value="Adidas">
				<option value="Nike">
				<option value="Puma">
			</datalist>
			<label for="type"> Typ:</label> <input type="text" name="type" id="type" required autofocus><br /> 
			<label for="colour"> Farbe:</label> <input type="text" list="colourList" name="colour" id="colour" required autofocus><br />
			<datalist id="colourList">
				<option value="weiß">
				<option value="schwarz">
				<option value="blau">
				<option value="gelb">
				<option value="rot">
			</datalist>
			<label for="price"> Preis:</label> <input type="text" name="price" id="price" placeholder="100.00" required autofocus><br /> 
			<label for="image"> Bild: </label> <input type="file" name="image" id="image" accept="image/*" required autofocus><br />
			<button class="button" type="submit" value="submit">upload</button>
			<button class="button" name="Reset" type="reset">zurücksetzen</button>
		</div>
	</form>
	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>