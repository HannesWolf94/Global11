<%--
  pattern hab ich von w3 school
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<title>Profil</title>
</head>
<body>
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
