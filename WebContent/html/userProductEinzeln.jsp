<!-- erstellt von Johannes Wolf  -->
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" charset="UTF-8">
<title>Unsere Produkte</title>
</head>

<body>
	<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>

	<div >
		<h1>Produktansicht</h1>
	</div>

	<div class="product" id="product">
		<img src="../Bild?prod_id=${productDB.prodId}" width="500"
			height="500" alt="Schuh"> <br> <em>Artikel: </em>${productDB.prodId}
		${productDB.label} ${productDB.type} ${productDB.colour} <br> <em>Preis:
		</em> ${productDB.price} <br> <em>Größe: <input type="text"
			list="sizeList" name="size" id="size" required autofocus> <datalist
				id="sizeList">
				<option value="40">
				<option value="41">
				<option value="42">
				<option value="43">
				<option value="44">
				<option value="45">
			</datalist>
		</em> <em>Anzahl: <input type="text" list="anzahlList" name="anzahl"
			id="anzahl" required autofocus> <datalist id="anzahlList">
				<option value="1">
				<option value="2">
				<option value="3">
				<option value="4">
				<option value="5">
			</datalist>
		</em>
		<form id="auswaehlen" method="post" action="../ProductInWarenkorb">
			<input name="prodId" type="hidden" value="${productDB.prodId}">
			<input name="label" type="hidden" value="${productDB.label}">
			<input name="type" type="hidden" value="${productDB.type}"> <input
				name="price" type="hidden" value="${productDB.price}"> <input
				name="colour" type="hidden" value="${productDB.colour}">
			<button name="submit" type="submit">in den Warenkorb</button>
		</form>
	</div>

	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>