<!-- erstellt von Johannes Wolf  -->
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- https://www.tutorialspoint.com/jsp/jstl_format_formatnumber_tag.htm -->
<!DOCTYPE html>
<html lang="de">
	<head>
	<meta charset ="UTF-8">
	
	<base href="${pageContext.request.requestURI}" />
	
	<title>Unsere Produkte</title>
	
	<link rel="stylesheet" type="text/css" href="../css/header.css" />
	<link rel="stylesheet" type="text/css" href="../css/style.css" />
	</head>
	<body>
		<div id="header">
			<%@include file="../jspf/header.jspf"%>
		</div>
		
		<div id="einzelschuh">
			<h1>${productDB.kategorie} ${productDB.label} ${productDB.type} ${productDB.colour} </h1> <br>	
			
				<img src="../Bild?prod_id=${productDB.prodId}" width="450" height="450" alt="Schuh"> 
				
				<h2><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${productDB.price}"/>€</h2><br> 
				<p>Artikelnummer: ${productDB.prodId} </p>
				
				<form id="auswaehlen" method="post" action="../ProductInWarenkorb">	 
					
					Größe: <input type="number" list="sizeList" name="size" id="size" min="40" max="46" required autofocus> 
					<datalist id="sizeList">
						<option value="40">
						<option value="41">
						<option value="42">
						<option value="43">
						<option value="44">
						<option value="45">
						<option value="46">
					</datalist>
					Anzahl: <input type="number" list="anzahlList" name="anzahl" id="anzahl" min="1" max="99" required> 
					<datalist id="anzahlList">
							<option value="1">
							<option value="2">
							<option value="3">
							<option value="4">
							<option value="5">
						</datalist>
						
				<c:choose>
		            <c:when test="${sessionScope.user.email != null }">
						<input name="prodId" type="hidden" value="${productDB.prodId}">
						<input name="kategorie" type="hidden" value="${productDB.kategorie}">
						<input name="label" type="hidden" value="${productDB.label}">
						<input name="type" type="hidden" value="${productDB.type}"> 
						<input name="price" type="hidden" value="${productDB.price}"> 
						<input name="colour" type="hidden" value="${productDB.colour}">
						<button name="submit" type="submit">in den Warenkorb</button>
					</c:when>
					<c:otherwise>
					<p>Bitte loggen Sie sich zuerst ein um Produkte in den Warenkorb zu legen! </p>
					<a class="linkstyle" href= "${pageContext.request.contextPath}/html/login.jsp">Zum Login </a>
					</c:otherwise>
				</c:choose>
			</form>
		</div>
		<div id="footer">
			<%@include file="../jspf/footer.jspf"%>
		</div>
	</body>
</html>