<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produktupload</title>
</head>
<body>
	<form action="../Produktupload" method="post">
		<div>
			<label for="label"> Label:</label> <input type="text" name="label"><br />
			<label for="type"> Typ:</label> <input type="text" name="type"><br />
				 <label for="colour"> Farbe:</label> <input type="text" name="colour"><br />
			<label for="price"> Preis:</label> <input type="text"	name="price"><br /> 
				<label for="size">	Größe:</label> <input type="text" name="size"><br /> 
				<label	for="image"> Bild: </label> <input type="text"	name="image"><br />
			<button class="button" type="submit" value="Submit"> upload</button>
			<button class="button" name="Reset" type="reset">zurücksetzen</button>

		</div>
	</form>

</body>
</html>