<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- https://www.tutorialspoint.com/jsp/jstl_format_formatnumber_tag.htm -->
<!DOCTYPE html>
<html lang="de">
	<head>
		<meta charset ="UTF-8">
		
		<base href="${pageContext.request.requestURI}" />
		
		<title>Produkt anzeigen</title>
		
		<link rel="stylesheet" type="text/css" href="../css/header.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
	
		<script src="../js/prodIdCheck.js"></script>
	</head>
	<body>
		<div id="header">
			<%@include file="../jspf/header.jspf"%>
		</div>
		
		<h1>Produkt anzeigen</h1>
		
		<form id="ProductAnzeigen" action="${pageContext.request.contextPath}/ProductAnzeigen" method="POST">
			<table>
				<tbody>
					<tr>
						<th>Artikelnummer</th>
						<th>Kategorie</th>
						<th>Marke</th>
						<th>Typ</th>
						<th>Farbe</th>
						<th>Preis</th>
						<th>Bild</th>
					</tr>
					<c:forEach items="${produktverwaltungAdminList}" var="produktverwaltung">
						<tr>
							<td>${produktverwaltung.prodId}</td>
							<td>${produktverwaltung.kategorie}</td>
							<td>${produktverwaltung.label}</td>
							<td>${produktverwaltung.type}</td>
							<td>${produktverwaltung.colour}</td>
							<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${produktverwaltung.price}"/>€</td>
							<td> <img src="../Bild?prod_id=${produktverwaltung.prodId}" width="200" height="200" alt="Schuh"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		<form  id = "ProductDelete" action="${pageContext.request.contextPath}/ProductDelete" method = "POST">
			<fieldset>
				<div>
					<label for="prodId"> Produkt löschen :</label> 
					<input type="text" name="prodId" id="prodId" placeholder="Bitte ProduktId eingeben" required>
					<input type="text" name="prodIdRepeat" id="prodIdRepeat" placeholder="ProduktId erneut eingeben" required>
				</div>
				<div>
					<button name="submit" id="submit" type="submit">löschen</button>
				</div>
			</fieldset>
		</form>
		<div id="footer">
			<%@include file="../jspf/footer.jspf"%>
		</div>
	</body>
</html>
