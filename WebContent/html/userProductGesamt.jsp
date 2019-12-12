<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- https://www.tutorialspoint.com/jsp/jstl_format_formatnumber_tag.htm -->
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<base href="${pageContext.request.requestURI}" />
	
	<title>Unsere Produkte</title>
	
	<link rel="stylesheet" type="text/css" href="../css/header.css" />
	<link rel="stylesheet" type="text/css" href="../css/style.css" />
	
	<script type="text/javascript" src="../js/suche.js"></script>
	</head>
	<body>
		<div id="header">
			<%@include file="../jspf/header.jspf"%>
		</div>
	
		<form id="suche" action="../Suche" method="POST">
			<fieldset>
				<legend>Produktsuche</legend>
				<div>
				<label for="kategorie">Suche nach Kategorie:</label> <input type="text" name="kategorie" id="kategorie" placeholder="Kategorie">
					<label for="label">Suche nach Hersteller:</label> <input type="text" name="label" id="label" placeholder="Hersteller">
					<button type="submit" id="submit" name="submit">Suchen</button>
					<button name="reset" type="reset">Zurücksetzen</button>
				</div>
			</fieldset>
		</form>
		<br>
		
		<h1>Unsere Produkte von Global11</h1>
		<c:choose>
			<c:when test="${products == null || empty products}">
				<table>
					<tbody>
						<c:forEach items="${productUserList}" var="product">
							<tr>
								<td>${product.prodId}</td>
								<td>${product.kategorie}</td>
								<td>${product.label}</td>
								<td>${product.type}</td>
								<td>${product.colour}</td>
								<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.price}"/>€</td> 
								<td><img src="../Bild?prod_id=${product.prodId}" width="200" height="200" alt="Schuh"></td>
								<td>
									<div class="auswaehlen">
										<form action="../UserProductEinzeln" method="POST">
											<input name="prodId" type="hidden" value="${product.prodId}">
											<input name="kategorie" type="hidden" value="${product.kategorie}">
											<input name="label" type="hidden" value="${product.label}">
											<input name="type" type="hidden" value="${product.type}">
											<input name="price" type="hidden" value="${product.price}">
											<input name="colour" type="hidden" value="${product.colour}">
											<button name="submit" type="submit">zum Produkt</button>
										</form>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<table>
					<c:forEach var="product" items="${products}">
						<tr>
							<td>${product.prodId}</td>
							<td>${product.kategorie}</td>
							<td>${product.label}</td>
							<td>${product.type}</td>
							<td>${product.colour}</td>
							<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.price}"/>€</td>
							<td><img src="../Bild?prod_id=${product.prodId}" width="200" height="200" alt="Schuh"></td>
							<td>
								<div class="auswaehlen">
									<form action="../UserProductEinzeln" method="POST">
										<input name="prodId" type="hidden" value="${product.prodId}">
										<input name="prodId" type="hidden" value="${product.kategorie}">
										<input name="label" type="hidden" value="${product.label}">
										<input name="type" type="hidden" value="${product.type}">
										<input name="price" type="hidden" value="${product.price}">
										<input name="colour" type="hidden" value="${product.colour}">
										<button name="submit" type="submit">zum Produkt</button>
									</form>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	
		<div id="footer">
			<%@include file="../jspf/footer.jspf"%>
		</div>
	</body>
</html>