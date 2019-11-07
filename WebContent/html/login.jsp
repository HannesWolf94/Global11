<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="head.jspf" %> 
<link rel="stylesheet" type="text/css" href="../style/style.css">
<form action = "../LoginServlet" method="GET">
    	<h2>Login</h2><br>
	    <label for ="e"> Email </label><br>
	    <input type="email" placeholder="Email" name="email" id ="e" required autofocus><br>
	    <label  for ="p"> Passwort </label><br>
	    <input type="password" placeholder="Passwort" name="passwort" id ="p" required><br>
	    <button type="submit" id="loginButton">Login!</button><br>
    <br>
    <a href="registrierung.jsp"> Noch kein Konto? Jetzt registrieren!</a>
</form>
<%@ include file="footer.jspf" %>