<%--
  pattern hab ich von w3 school
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<title>Kontobereich</title>
</head>
<body>
<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>
<form id="Kontobereich" action="${pageContext.request.contextPath}/Kontobereich" method="post">
				<div>
					<label for="firstName"> Vorname </label><br> <input
						name="firstName" id="firstName" type="text"
						value="${user.firstName}">
				</div>
				<div>
					<label for="lastName">Lastname: </label><br> <input
						name="lastName" type="text" id="lastName"
						value="${user.lastName}">
				</div>
				<div>
					<label for="street"> Straße u. Hausnr: : </label> <br> <input name="street"
						type="text" id="street"
						value="${user.street}">
				</div>
				<div>
					<label for="city"> Stadt u. PLZ: </label> <br> <input name="city"
						type="text" id="city"
						value="${user.city}">
				</div>
				<div>
					<label for="email"> E-Mail : </label> <br> <input name="email"
						type="email" id="email"
						value="${user.email}">
				</div>
				<div>
					<button class="button" name="submit" type="submit">Daten ändern und
						speichern</button>
					<button class="button" name="reset" type="reset">zurücksetzen</button>
				</div>
		</form>
		<form id="password" action="${pageContext.request.contextPath}/Password" method="post">
				<div>
					<label for="pw"> altes Passwort: </label> <br> <input
						type="password" name="oldPassword" id="pw" size="10"
						maxlength="10">
				</div>
				<div>
					<label for="newPassword"> neues Passwort : </label> <br> <input
						type="password" name="newPassword" id="newPassword" size="10"
						maxlength="10" required>
				</div>
				<div>
					<label for="passwordConfirmation"> Passwort bestätigen: </label><br> <input type="password"
						id="passwordConfirmation" name="passwordConfirmation" size="10"
						maxlength="10" required>
				</div>
				<div>
					<button class="button" name="submit" type="submit"> Passwort ändern</button>
				</div>
		</form>
		<form method="post" action="${pageContext.request.contextPath}/AccountLoeschen">
			<fieldset>
				<div>
					<label for="email"> Account löschen :</label> <input type="text"
						name="email" id="email"
						placeholder="Bitte Ihre Email eingeben" required>

				</div>
				<div>
					<button class="button" name="submit" type="submit">löschen</button>
					<button class="button" name="Reset" type="reset">zurücksetzen</button>
				</div>
			</fieldset>
		</form>
		<br>
<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>	
	
</body>
</html>
