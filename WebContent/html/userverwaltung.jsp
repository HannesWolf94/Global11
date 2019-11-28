<!-- Hannes --> 
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" charset="UTF-8">
<title>Userverwaltung</title>
<script type="text/javascript" src="../js/emailconfirmation.js"></script>
</head>
<body>
	<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>

		<h1>Userverwaltung</h1>

		<form id="UserverwaltungAdmin"
			action="${pageContext.request.contextPath}/UserverwaltungAdmin" method="POST">
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
							<td>${userverwaltung.firstName}</td>
							<td>${userverwaltung.lastName}</td>
							<td>${userverwaltung.street}</td>
							<td>${userverwaltung.city}</td>
							<td>${userverwaltung.userAdmin}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		<form  id = "UserLoeschen" action="${pageContext.request.contextPath}/UserLoeschen" method = "POST">
			<fieldset>
				<div>
					<label for="email"> Account löschen :</label> 
						<input type="text" name="email" id="email" placeholder="Bitte Email eingeben" required>
						<input type="text" name="emailRepeat" id="emailRepeat" placeholder="Email erneut eingeben" required>
				</div>
				<div>
					<button name="submit" id="button" type="submit">löschen</button>
				</div>
			</fieldset>
		</form>
		<form  id = "UserAendern" action="${pageContext.request.contextPath}/UserAendern" method = "POST">
			<fieldset>
				<div>
					<label for="email"> Account ändern :</label> <br>
						<input type="text" name="email" id="email" placeholder="Email" required>
						<input type="text" name="firstName" id="firstName" placeholder="Vorname" required>
						<input type="text" name="lastName" id="lastName" placeholder="Nachname" required>
						<input type="text" name="street" id="street" placeholder="Straße u. Hausnr." required>
						<input type="text" name="city" id="city" placeholder="PLZ u. Ort" required>
						<input type="number" name="userAdmin" id="userAdmin" placeholder="0 = User | 1 = Admin" required> 
				</div>
				<div>
					<button name="submit" id="button" type="submit">ändern</button>
				</div>
			</fieldset>
		</form>

	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>
