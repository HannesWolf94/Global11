<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" charset="UTF-8">
<title>Startseite</title>
<script src="js/cookieCheck.js"></script>
<script src="js/slideshow.js"></script>
<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/startseite.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div id="header">
		<%@include file="jspf/header.jspf"%>
	</div>
	<h1>GLOBAL 11 - Ihr Webshop für Fußballschuhe</h1>
	<div class="image">
		<img src="img/Startcut.jpg" alt="start">
	</div>
	<p class="blocksatz">Wir von Global 11 begrüßen Dich recht herzlich
		in unserem Sport Online Shop und wünschen Dir viel Spaß beim Shoppen.
		Bei uns findest Du eine große Artikelauswahl rund um das Thema
		Fußballschuhe.</p>

	<!--  vgl. https://www.w3schools.com/howto/howto_js_slideshow.asp -->
	<div class="slideshow-container">
		<div class="mySlides fade">
			<div class="numbertext">1 / 4</div>
			<img src="img/Sport.jpg" width=960 height=600 alt="sport">
			<div class="text">Sport</div>
		</div>
		<div class="mySlides fade">
			<div class="numbertext">2 / 4</div>
			<img src="img/Nike.jpg" width=960 height=600 alt="nike">
			<div class="text">Nike</div>
		</div>
		<div class="mySlides fade">
			<div class="numbertext">3 / 4</div>
			<img src="img/Puma.jpg" width=960 height=600 alt="puma">
			<div class="text">Puma</div>
		</div>
		<div class="mySlides fade">
			<div class="numbertext">4 / 4</div>
			<img src="img/Adidas.jpg" width=960 height=600 alt="adidas">
			<div class="text">Adidas</div>
		</div>
		<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a class="next"
			onclick="plusSlides(1)">&#10095;</a>
	</div>
	<br>
	<div class="point">
		<span class="dot" onclick="currentSlide(1)"></span> <span class="dot"
			onclick="currentSlide(2)"></span> <span class="dot"
			onclick="currentSlide(3)"></span> <span class="dot"
			onclick="currentSlide(4)"></span>
	</div>

	<script src="js/slideshow.js"></script>
	<div id="footer">
		<%@include file="jspf/footer.jspf"%>
	</div>
</body>
</html>