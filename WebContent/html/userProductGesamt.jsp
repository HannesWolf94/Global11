<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" charset="UTF-8">
<title>Unsere Produkte</title>
</head>

<body>
	<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>
	
	<h1>Produkt anzeigen</h1>
   
   		<table>
				<tbody>
					<c:forEach items="${productUserList}" var="product">
							<tr> <td colspan="2"> <img src="../Bild?prod_id=${product.prodId}" width="300"
                             height="150" alt="autobild" > </td></tr> 
							<tr><td colspan="2"> ${product.price} € <td></tr>
		                    <tr>
		                    	<td>${product.label}</td>
		                    	<td>${product.type}</td>
		                    </tr>
		                    <tr><td colspan="2">${product.colour}<td></tr>
			                <tr>    
			                	<td colspan="2">
			                        <div class="auswaehlen">
			                            <form action="../UserProductEinzeln" method="POST">
			                                <input name="prodId" type="hidden" value="${product.prodId}">
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


	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>