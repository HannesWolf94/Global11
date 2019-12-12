<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	   		<table>
					<tbody>
						<tr>
							<th colspan= "3"> Hersteller</th>
							<th>Typ</th>
							<th>Farbe</th>
							<th>Größe</th>
							<th>Anzahl</th>
							<th>Preis</th>
						</tr>
						<c:forEach items="${productWarenkorb}" var="warenkorb">
						<tr> 
							<td> <img src="../Bild?prod_id=${warenkorb.prodId}" width="50"
	                             height="25" alt="Schuh"> </td> 
	                       	<td>${warenkorb.label}</td>
	                    	<td>${warenkorb.type}</td>
	                    	<td>${warenkorb.colour}</td>
	                    	<td>${warenkorb.size}</td>
	                    	<td>${warenkorb.anzahl}</td>  
	                    	<td>${product.price} € <td>  
		                </tr>
						</c:forEach>
					</tbody>
				</table>
	            <form action="../Warenkorb" method="POST">
	               <button name="submit" type="submit"> Jetzt bestellen </button>
	            </form>
		<div id="footer">
			<%@include file="../jspf/footer.jspf"%>
		</div>
	</body>
</html>