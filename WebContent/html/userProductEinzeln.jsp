<!-- erstellt von Johannes Wolf  -->
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<base href="${pageContext.request.requestURI}" />
	
	<title>Unsere Produkte</title>
	
	<link rel="stylesheet" type="text/css" href="../css/header.css" />
	<link rel="stylesheet" type="text/css" href="../css/style.css" />
	</head>
	<body>
		<div id="header">
			<%@include file="../jspf/header.jspf"%>
		</div>
	
		<h1>${productDB.kategorie} ${productDB.label} ${productDB.type} ${productDB.colour} </h1> <br>	
		
		<div class="product" id="product">
			<img src="../Bild?prod_id=${productDB.prodId}" width="500" height="500" alt="Schuh"> 
			
			<h2><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${productDB.price}"/> € </h2><br> 
			<p>Artikelnummer: ${productDB.prodId} <br>
				 
			Größe: <input type="text" list="sizeList" name="size" id="size" required autofocus> 
			<datalist id="sizeList">
				<option value="40">
				<option value="41">
				<option value="42">
				<option value="43">
				<option value="44">
				<option value="45">
			</datalist>
			Anzahl: <input type="text" list="anzahlList" name="anzahl" id="anzahl" required> 
			<datalist id="anzahlList">
					<option value="1">
					<option value="2">
					<option value="3">
					<option value="4">
					<option value="5">
				</datalist>
				</p>
			<form id="auswaehlen" method="post" action="../ProductInWarenkorb">
				<input name="prodId" type="hidden" value="${product.prodId}">
				<input name="kategorie" type="hidden" value="${product.kategorie}">
				<input name="label" type="hidden" value="${product.label}">
				<input name="type" type="hidden" value="${product.type}"> 
				<input name="price" type="hidden" value="${product.price}"> 
				<input name="colour" type="hidden" value="${product.colour}">
				<button name="submit" type="submit">in den Warenkorb</button>
			</form>
		</div>
	
		<div id="footer">
			<%@include file="../jspf/footer.jspf"%>
		</div>
	</body>
</html>