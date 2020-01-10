<!-- erstellt von Martin Scherzer -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<meta charset ="UTF-8">

<base href="${pageContext.request.requestURI}" />

<title>Produktupload</title>

<link rel="stylesheet" type="text/css" href="../css/header.css" />
<link rel="stylesheet" type="text/css" href="../css/style.css" />
</head>
<body>
	<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>
	<form id="product" action="../ProductUpload" method="post"
		enctype="multipart/form-data">
		<div>
			<label for="kategorie"> Kategorie:</label> <input type="text"
				list="kategorielist" name="kategorie" id="kategorie" required><br />
			<datalist id="kategorielist">
				<c:forEach items="${kategorieList}" var="kategorie">
					<option value="${kategorie.kategorie}">
				</c:forEach>
			</datalist>
			<label for="label"> Marke:</label> <input type="text"
				list="labelList" name="label" id="label" required><br />
			<datalist id="labelList">
				<option value="Adidas">
				<option value="Nike">
				<option value="Puma">
			</datalist>
			<label for="type"> Typ:</label> <input type="text" name="type"
				id="type" required><br /> <label for="colour">
				Farbe:</label> <input type="text" list="colourList" name="colour"
				id="colour" required><br />
			<datalist id="colourList">
				<option value="weiß">
				<option value="schwarz">
				<option value="blau">
				<option value="gelb">
				<option value="rot">
			</datalist>
			<label for="price"> Preis:</label> <input type="text" name="price"
				id="price" placeholder="100.00" pattern="[0-9]+([\.][0-9]+)?" required><br /> <label
				for="image"> Bild: </label> <input type="file" name="image"
				id="image" accept="image/*" required><br />
			<button class="button" type="submit" value="submit">upload</button>
			<button class="button" name="Reset" type="reset">zurücksetzen</button>
		</div>
	</form>
	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>