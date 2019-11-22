<!-- erstellt von Martin Scherzer -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produktupload</title>
</head>
<body>
	<div id="header">
		<%@include file="../jspf/header.jspf"%>
	</div>
	<form action="../Produktupload" method="post">
		<div>
			<label for="label"> Marke:</label> <input type="text"
				list="labelList" name="label" id="label" autofocus><br /> <label
				for="label"></label>
			<datalist id="labelList">
				<option value="Adidas">
				<option value="Nike">
				<option value="Puma">
			</datalist>
			<label for="type"> Typ:</label> <input type="text" name="type"
				id="type"><br /> <label for="colour"> Farbe:</label> <input
				type="text" list="colourList" name="colour" id="colour" autofocus><br />
			<label for="colour"></label>
			<datalist id="colourList">
				<option value="weiß">
				<option value="schwarz">
				<option value="blau">
				<option value="gelb">
				<option value="rot">
			</datalist>
			<label for="price"> Preis:</label> <input type="number" name="price"
				id="price" placeholder="100.00"><br /> <label for="size">
				Größe:</label> <input type="text" list="sizeList" name="size" id="size"
				autofocus><br /> <label for="size"></label>
			<datalist id="sizeList">
				<option value="38">
				<option value="39">
				<option value="40">
				<option value="41">
				<option value="42">
				<option value="43">
				<option value="44">
				<option value="45">
			</datalist>
			<label for="image"> Bild: </label> <input type="file" name="image"
				id="image"><br />
			<button class="button" type="submit" value="submit">upload</button>
			<button class="button" name="Reset" type="reset">zurücksetzen</button>

		</div>
	</form>
	<div id="footer">
		<%@include file="../jspf/footer.jspf"%>
	</div>
</body>
</html>