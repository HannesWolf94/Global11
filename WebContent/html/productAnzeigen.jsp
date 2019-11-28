<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" charset="UTF-8">
<title>Produkt anzeigen</title>
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
						<td>${produktverwaltung.image}</td> 
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	<form  id = "ProductDelete" action="${pageContext.request.contextPath}/ProductDelete" method = "POST">
			<fieldset>
				<div>
					<label for="label"> Produkt löschen :</label> 
						<input type="text" name="label" id="label" placeholder="Bitte ProduktId eingeben" required>
						<input type="text" name="labelRepeat" id="labelRepeat" placeholder="ProduktId erneut eingeben" required>
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
