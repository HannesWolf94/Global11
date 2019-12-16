<!-- erstellt von Johannes Wolf --> 
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
	<head>
	<meta charset ="UTF-8">
	
	<base href="${pageContext.request.requestURI}" />
	
	<title>Userverwaltung</title>
	
	
	<link rel="stylesheet" type="text/css" href="../css/header.css" />
	<link rel="stylesheet" type="text/css" href="../css/style.css" />
	
	<script src="../js/emailconfirmation.js"></script>
	<script src="../js/userSuche.js"></script>	
	</head>
	<body>
		<div id="header">
			<%@include file="../jspf/header.jspf"%>
		</div>
			<h1>Userverwaltung</h1>
				<table>
					<tbody>
						<tr>
							<th>ID</th>
							<th>Email</th>
							<th>Vorname</th>
							<th>Nachname</th>
							<th>Straße u. Hausnr.</th>
							<th>PLZ u. Ort</th>
						</tr>
						<c:forEach items="${userverwaltungAdminList}" var="userverwaltung">
							<tr>
								<td>${userverwaltung.userId}</td>
								<td>${userverwaltung.email}</td>
								<td>${userverwaltung.firstName}</td>
								<td>${userverwaltung.lastName}</td>
								<td>${userverwaltung.street}</td>
								<td>${userverwaltung.city}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			<form  id = "UserLoeschen" action="${pageContext.request.contextPath}/UserLoeschen" method = "POST">
				<fieldset>
					<div>
						<label for="email"> Account löschen :</label> 
						<input type="text" name="email" id="email" placeholder="Bitte Email eingeben" required>
						<input type="text" name="emailRepeat" id="mailRepeat" placeholder="Email erneut eingeben" required>
					</div>
					<div>
						<button name="submitButton" id="button" type="submit">löschen</button>
					</div>
				</fieldset>
			</form>
			<form  id = "UserAendern" action="${pageContext.request.contextPath}/UserAendern" method = "POST">
				<fieldset>
					<div>
						<label for="email1"> Account ändern :</label> <br>
						<input type="text" name="email" id="email1" placeholder="Email" required>
						<input type="text" name="firstName" id="firstName" placeholder="Vorname" required>
						<input type="text" name="lastName" id="lastName" placeholder="Nachname" required>
						<input type="text" name="street" id="street" placeholder="Straße u. Hausnr." required>
						<input type="text" name="city" id="city" placeholder="PLZ u. Ort" required>
					</div>
					<div>
						<button name="submitButton" id="button1" type="submit">ändern</button>
					</div>
				</fieldset>
			</form>
			
		<form id="myForm">
			<fieldset><legend>Mitarbeitersuche</legend>
				<div>
				  <label for="lastName2">Nachname:</label>
				  <input type="text" name="lastName2" id="lastName2" placeholder="Ihr Nachname">
				</div>
				<div>
				  <button type="button" id="button2" name="button2" >Absenden</button>
				  <button name="reset" type="reset">Zurücksetzen</button>
				</div>
			</fieldset>
		</form>
		<h3>Trefferliste</h3>
		<div id="hitlist">Keine Treffer</div>	
		<div id="footer">
			<%@include file="../jspf/footer.jspf"%>
		</div>
	</body>
</html>
