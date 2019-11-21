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
	<header>
		<h1>Userverwaltung</h1>
	</header>
	<nav>
		<%@include file="../jspf/navigation.jspf"%>
	</nav>
	<form id="UserverwaltungAdmin"
		action="${pageContext.request.contextPath}/UserverwaltungAdmin"
		method="POST">
		<button name="button" id="button" type="submit">Refresh</button>

		<table>
			<tbody>
				<h2>Userverwaltung</h2>
				<tr>
					<th>ID</th>
					<th>Email</th>
					<th>Passwort</th>
					<th>Vorname</th>
					<th>Nachname</th>
					<th>Straße u. Hausnr.</th>
					<th>PLZ u. Ort</th>
					<th>Admin</th>
				</tr>
				<c:forEach items="${userverwaltungAdminList}" var="userverwaltung">
					<tr>
						<td>${userverwaltung.userId}</td>
						<td>${userverwaltung.userEmail}</td>
						<td>${userverwaltung.userPassword}</td>
						<td>${userverwaltung.userFirstName}</td>
						<td>${userverwaltung.userLastName}</td>
						<td>${userverwaltung.userStreet}</td>
						<td>${userverwaltung.userCity}</td>
						<td>${userverwaltung.userAdmin}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>

</body>
</html>
