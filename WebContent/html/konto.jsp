<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="head.jspf" %> 
<link rel="stylesheet" type="text/css" href="../style/style.css">
	<form method="post" class="modal-content animate" action="../UpdateServlet">
	<main>
	<br>
	<div class="konto">
	<h2>Mein Account</h2>
	<br><b>Name: </b>${account.name}
	<br><b>Vorname: </b>${account.vorname}
	<br><b>Adresse: </b>${account.strasse} ${account.hnr} ${account.plz} ${account.stadt}
	<br><b>Email: </b>${account.email}
	<br>
	</div>
	<button onclick="document.getElementById('id01')" class="bearb">Account bearbeiten</button>
	<div id="id01" class="modal">
			 <c:choose>
				<c:when test="${pwfalsch > 0}">
					<br>
					<a class = "rot">Passwörter stimmen nicht überein!</a>
				</c:when>
			</c:choose>
			</div>
			<h1>Account bearbeiten</h1>
		    <label>Name <br></label>
		    <input type="text" name="name" id="name" value="${account.name}" required autofocus>
		    <br>
		    <label>Vorname</label> <br>
		    <input type="text" name="vorname" value="${account.vorname}" required>
		    <br>
			<label>Geburtsdatum</label> <br>
			<input type="date" name="gebdat" value="${account.gebdat}" required>
			<br>
		    <label>Email</label> <br>
		    <input type="email"  name="email" value="${account.email}" required>
		    <br>
		    <label>Straße </label> <br>
		    <input type="text" name="strasse" value="${account.strasse}" required>
		    <br>
		    <label>Hausnummer</label>
		    <br>
		    <input type="text" name="hausnummer" value="${account.hnr}" required>
		    <br>
		    <label>Ort </label><br>
		    <input type="text" name="ort" value="${account.ort}" required>
		    <br>
		    <label>Postleitzahl </label>
		    <br>
		    <input type="text" name="postleitzahl" value="${account.plz}" required>
			<br>
		    <label>Passwort </label>
		    <br>
		    <input type="password" name="passwort" value="${account.passwort}" onkeyup="check()" required>
			<br>
		    <label>Wiederhole Passwort</label> <br>
		    <input type="password" name="passwort2" value="${account.passwort2}" onkeyup="check()" required>
		    <span id="message"></span>
			<br>
			<br>
		    <button type="submit" class="account" onclick="document.getElementById('id01')">Aktualisieren!</button> 
		    <br>
		</main>
		</form>
<%@ include file="footer.jspf" %>