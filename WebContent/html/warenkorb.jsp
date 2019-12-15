<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="de">
	<head>
		<meta charset ="UTF-8">
		
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
	   		
		   		<table>
					<tbody>
						<tr>
							<th></th>
							<th>Marke</th>
							<th>Typ</th>
							<th>Farbe</th>
							<th>Preis</th>
							<th>Größe</th>
							<th>Anzahl</th>
							<th>Gesamtpreis</th>
							<th><th>
						</tr>
						<c:forEach items="${warenkorbList}" var="warenkorb">
						<tr> 
							<td> <img src="../Bild?prod_id=${warenkorb.prodId}" width="100" height="100" alt="Schuh"> </td>
	                       	<td>${warenkorb.label}</td>
	                    	<td>${warenkorb.type}</td>
	                    	<td>${warenkorb.colour}</td>
	                    	<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${warenkorb.price}"/> €<td> 
	                    	<td>${warenkorb.size}</td> 
	                    	<td>
		                    	<form action="../WarenkorbAendern" method="POST">
		                    		<input type="number" name="anzahl" id="anzahl" min="1" max="99" value="${warenkorb.anzahl}">
		                    		 <input name="gesamtpreis" type="hidden" value="${warenkorb.gesamtpreis}">	
		                       	    <input name="orderId" type="hidden" value="${warenkorb.orderId}">
		                       	    <input name="price" type="hidden" value="${warenkorb.price}">
		                    		<button name="aendern" type="submit"> ändern </button>
		                    	</form>
		                    	
	                    	</td>
	                    	<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${warenkorb.gesamtpreis}"/> €<td>
	                    	<td>
	                    		<form action="../WarenkorbLoeschen" method="POST">
	                    			<input name="orderId" type="hidden" value="${warenkorb.orderId}">
	                    			<button name="delete" type="submit"> löschen </button>
	                    		</form>
	                    	</td>
	                    </tr>
						</c:forEach>
					</tbody>
				</table>

            <form action="../Buchen" method="POST">
               <button name="bestellen" type="submit"> Jetzt bestellen </button>
            </form>
		<div id="footer">
			<%@include file="../jspf/footer.jspf"%>
		</div>
	</body>
</html>