<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
[
<c:forEach var="productList" items="${productlist}" varStatus="status">
	{
		"id":${product.id},
		"Hersteller":"${product.label}",
		"Typ":"${product.type}",
		"Farbe:"${product.colour}
		"Preis:"${product.prize}
	}<c:if test="${not status.prodLabel}">,</c:if>
</c:forEach>
]