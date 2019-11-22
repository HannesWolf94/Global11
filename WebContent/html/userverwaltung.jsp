<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" charset="UTF-8">
<title>Userverwaltung</title>
</head>

<body>
<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>

		<h1>Userverwaltung</h1>

	<form id="UserverwaltungAdmin"
		action="${pageContext.request.contextPath}/UserverwaltungAdmin"
		method="POST">
		<table>
			<tbody>
				<tr>
					<th>ID</th>
					<th>Email</th>
					<th>Vorname</th>
					<th>Nachname</th>
					<th>Straße u. Hausnr.</th>
					<th>PLZ u. Ort</th>
					<th>Admin</th>
				</tr>
				<c:forEach items="${userverwaltungAdminList}" var="userverwaltung">
					<tr>
						<td>${userverwaltung.userId}</td>
						<td>${userverwaltung.email}</td>
						<td><input type="text" name="userFirstName" id="userFirstName" value="${userverwaltung.firstName}"></td>
						<td><input type="text" name="userLastName" id="userLastName" value="${userverwaltung.lastName}"></td>
						<td><input type="text" name="userStreet" id="userStreet" value="${userverwaltung.street}"></td>
						<td><input type="text" name="userCity" id="userCity" value="${userverwaltung.city}"></td>
						<td><input type="checkbox" name="userAdmin" id="userAdmin" value="${userverwaltung.userAdmin}"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button name="button" id="button" type="submit" action="UserverwaltungAdmin" > ändern </button>
	</form>
<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>
