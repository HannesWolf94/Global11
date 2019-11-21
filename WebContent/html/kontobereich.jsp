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

<form action="${pageContext.request.contextPath}/Kontobereich" method="post">
			<fieldset>
				<legend> Persönliche Daten bearbeiten</legend>
				<div>
					<label for="firstName"> Vorname </label><br> <input
						name="firstName" id="firstName" type="text"
						value="${user.firstname}">
				</div>
				<div>
					<label for="lastName">Lastname: </label><br> <input
						name="lastName" type="text" id="lastName"
						value="${user.lastname}">
				</div>
				<div>
					<label for="email"> E-Mail : </label> <br> <input name="email"
						type="email" id="email"
						value="${user.email}">
				</div>
				<div>
					<button class="button" name="submit" type="submit">Daten ändern und
						speichern</button>
					<button class="button" name="reset" type="reset">Zurücksetzen</button>
				</div>
			</fieldset>
		</form>
		<form id="password" action="${pageContext.request.contextPath}/Password" method="post">
			<fieldset>
				<legend>Passwort ändern</legend>
				<div>
					<label for="pw"> old Password : </label> <br> <input
						type="password" name="oldPassword" id="pw" size="10"
						maxlength="10">
				</div>
				<div>
					<label for="newPassword"> new Password : </label> <br> <input
						type="password" name="newPassword" id="newPassword" size="10"
						maxlength="10" required>
				</div>
				<div>
					<label for="passwordConfirmation"> new Password
						Confirmation: </label><br> <input type="password"
						id="passwordConfirmation" name="passwordConfirmation" size="10"
						maxlength="10" required>
				</div>
				<div>
					<button class="button" name="submit" type="submit"> Passwort ändern</button>
				</div>
			</fieldset>

		
		</form>
		<br>
	
	
</body>
</html>
