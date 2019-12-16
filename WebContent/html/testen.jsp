<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		[<c:forEach var="user" items="${users}" varStatus="status">{
				"Id":${user.userId},
				"Email":"${user.email}",
				"Firstname":"${user.firstName}",
				"Lastname":"${user.lastName}"
			}<c:if test="${not status.last}">,</c:if>
		</c:forEach>]


