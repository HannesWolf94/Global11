<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" charset="UTF-8">
<title>Produkt anzeigen</title>
<script type="text/javascript" src="../js/prodIdCheck.js"></script>
<link rel="stylesheet" type="text/css" href="../css/style.css" />
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
					<th>ID</th>
					<th>Marke</th>
					<th>Typ</th>
					<th>Farbe</th>
					<th>Preis</th>
					<th>Größe</th>
					<th>Bild</th>
				</tr>
				<c:forEach items="${produktverwaltungAdminList}" var="produktverwaltung">
					<tr>
						<td>${produktverwaltung.prodId}</td>
						<td>${produktverwaltung.label}</td>
						<td>${produktverwaltung.type}</td>
						<td>${produktverwaltung.colour}</td>
						<td>${produktverwaltung.price}</td>
						<td>${produktverwaltung.size}</td>
						<td>Bild: <img src="../Bild?prod_id=${produktverwaltung.prodId}" ></td>
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
					<button name="submit" id="button" type="submit">löschen</button>
				</div>
			</fieldset>
		</form>
	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>
