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
   
    <form id="UserProductGesamt" action="${pageContext.request.contextPath}/UserProductGesamt" method="POST">
			<table>
				<tbody>
					<c:forEach items="${productUserList}" var="product">

							<tr><td colspan="2"> ${product.price} € <td></tr>
		                    <tr>
		                    	<td><a href="welcomeUser.jsp">${product.label}</a></td>
		                    	<td>${product.type}</td>
		                    </tr>
		                    <tr><td colspan="2">${product.colour}<td></tr>
					</c:forEach>
				</tbody>
			</table>
		</form>

	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>