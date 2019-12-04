<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" charset="UTF-8">
<title>Warenkorb</title>
</head>

<body>
	<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>
	
	<h1>Warenkorb</h1>
   
   		<table>
				<tbody>
					<tr>
						<th colspan= "3"> Produkt</th>
						<th>Farbe</th>
						<th>Größe</th>
						<th>Anzahl</th>
						<th colspan="2">Preis</th>
					</tr>
					<!-- evlt Sessionlist?? -->
					<c:forEach items="${productUserList}" var="product">
					<tr> 
						<td> <img src="../Bild?prod_id=${product.prodId}" > </td> 
                       	<td>${product.label}</td>
                    	<td>${product.type}</td>
                    	<td>${product.colour}</td>
                    	<td>Größe</td>
                    	<td>Anzahl</td>  
                    	<td> ${product.price} € <td>  
	                	<td>
	                        <div class="bestellen">
	                            <form action="../Warenkorb" method="POST">
	                                <input name="prodId" type="hidden" value="${product.prodId}">
	                                <input name="label" type="hidden" value="${product.label}">
	                                <input name="type" type="hidden" value="${product.type}">
	                                <input name="price" type="hidden" value="${product.price}">
	                                <input name="colour" type="hidden" value="${product.colour}">
	                                <input name="size" type="hidden" value="${product.size}">
	                                <input name="anzahl" type="hidden" value="${product.anzahl}">
	                                <button name="submit" type="submit"> bestellen </button>
	                            </form>
	                        </div>
	                   	</td>
	                </tr>
					</c:forEach>
				</tbody>
			</table>


	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>