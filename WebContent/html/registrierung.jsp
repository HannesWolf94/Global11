<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="head.jspf" %> 
<link rel="stylesheet" type="text/css" href="../style/style.css">
<form action = "../RegistrierungServlet" method="GET">
	<main>
	<h1>Neues Konto</h1>
    <label for ="n">Name <br></label>
    <input type="text" name="name" id="n" required autofocus>
    <br>
    <label for ="vn">Vorname</label> <br>
    <input type="text" name="vorname" id="vn" required>
    <br>
	<label for ="gebdat">Geburtsdatum</label> <br>
    <input type="date" name="gebdat" id="gebdat" required>
    <br>
    <label for ="m">Email</label> <br>
    <input type="email"  name="email" id="m" required>
    <br>
    <label for ="str">Straße </label> <br>
    <input type="text" name="strasse" id="str" required>
    <br>
    <label for = "hnr">Hausnummer</label> <br>
    <input type="text" name="hausnummer" id="hnr" required>
    <br>
    <label for ="o">Ort </label><br>
    <input type="text" name="ort" id="o" required>
    <br>
    <label for ="plz">Postleitzahl </label>
    <br>
    <input type="text" name="postleitzahl" id="plz" required>
	<br>
    <label for ="pw">Passwort </label>
    <br>
    <input type="password" name="passwort" id="pw"  required>
	<br>
    <label for ="pw2">Wiederhole Passwort</label> <br>
    <input type="password" name="passwort2" id="pw2"  required>
    <span id="message"></span>
	<br>
	<br>
    <button type="submit" id="account">Registrieren</button> 
    <br>    
	<a href="login.jsp"> Sie haben bereits ein Konto? Hier geht´s zum Login!</a>
	</main>
</form>
<%@ include file="footer.jspf" %>