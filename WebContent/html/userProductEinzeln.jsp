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
	
	<div  class="bild">
		<h1>Produktansicht</h1>
		<!-- Bild einfügen  -->
    </div>
   
   <div class="productbeschreibung" id="productbeschreibung"> 
    	<em>${product.label} ${product.type} ${product.colour}</em>
    	<br>
    	<em>${product.price}</em>
    	<br>
    	<%-- <em>${size.nr}</em> --%>
    	<form id="auswaehlen" method="post" action="ProductInWarenkorb">
        	<button name="submit" type="submit">in den Warenkorb</button>
        </form>
	</div>

	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>