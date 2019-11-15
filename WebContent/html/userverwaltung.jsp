<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="de">
    <head>
    	<base href="${pageContext.request.requestURI}" />
  		<meta http-equiv="Content-Type" charset="UTF-8"> <!-- ka was des http-Zeug is!! -->
  		<title>Userverwaltung</title>
    </head>

    <body>
    <header> 
    	<h1> Userverwaltung </h1>
    </header>
    <nav>
    	<%@include file="../jspf/navigation.jspf"%>
    </nav>	
	<article>
      <form id="UserverwaltungAdmin" action="${pageContext.request.contextPath}/UserverwaltungAdmin" method="post">
          <button name="seiteLaden" id="seiteLaden" type="submit">Useransicht laden!</button>
      </form>
	</article>
	
	<article>
        <table>
            <tbody>
                <h2>Userverwaltung</h2>
                <tr>
                    <th> ID </th>
                    <th> Email </th>
                    <th> Passwort </th>
                    <th> Vorname </th>
                    <th> Nachname </th>
                    <th> Straße u. Hausnr. </th>
                    <th> PLZ u. Ort </th>
                    <th> Admin </th>
                </tr>
                <c:forEach var="userverwaltung" items="${userverwaltungAdminList}">
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
    </article>
	
    </body>
</html>
