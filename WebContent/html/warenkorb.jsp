<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<base href="${pageContext.request.requestURI}" />
		
		<title>Warenkorb</title>
		
		<link rel="stylesheet" type="text/css" href="../css/header.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
	</head>
	<body>
		<div id="header">
			<%@include file="../jspf/header.jspf"%>
		</div>
		<h1>Ihr Warenkorb</h1>	
	   		<form action="../WarenkorbLoeschen" method="POST">
		   		<table>
					<tbody>
						<tr>
							<th> </th>
							<th>Marke</th>
							<th>Typ</th>
							<th>Farbe</th>
							<th>Preis</th>
							<th>Größe</th>
							<th>Anzahl</th>
							<th><th>
						</tr>
						<c:forEach items="${warenkorbList}" var="warenkorb">
						<tr> 
							<td> <img src="../Bild?prod_id=${warenkorb.prodId}" width="100" height="100" alt="Schuh"> </td>
	                       	<td>${warenkorb.label}</td>
	                    	<td>${warenkorb.type}</td>
	                    	<td>${warenkorb.colour}</td>
	                    	<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${warenkorb.price}"/> €<td> 
	                    	<td><input type="text" name="size" id="size" value="${warenkorb.size}"></td>
	                    	<td><input type="text" name="anzahl" id="anzahl" value="${warenkorb.anzahl}"></td>
	                    	<td><button name="delete" type="submit"> löschen </button></td>
		                    </tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
			<form action="../WarenkorbAendern" method="POST">
				<button name="ändern" type="submit"> Ändern </button>
			</form>
            <form action="../Buchen" method="POST">
               <button name="bestellen" type="submit"> Jetzt bestellen </button>
            </form>
		<div id="footer">
			<%@include file="../jspf/footer.jspf"%>
		</div>
	</body>
</html>