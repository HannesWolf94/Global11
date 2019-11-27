<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" charset="UTF-8">
<title>Startseite</title>

<link rel="stylesheet" type="text/css" href="css/startseite.css" />
</head>

<body>
	<div id="header">
		<%@include file="jspf/header.jspf"%>
	</div>
	<h1>GLOBAL 11 - Ihr Webshop für Fußballschuhe</h1>
	<div>
		<img src="img/Start.jpg" width=800 height=400 alt="start"
			class="responsive">
	</div>
	<p class="blocksatz">Wir von Global 11 begrüßen Dich recht herzlich
		in unserem Sport Online Shop und wünschen Dir viel Spaß beim Shoppen.
		Bei uns findest Du eine große Artikelauswahl rund um das Thema
		Fußballschuhe.</p>

<!--  vgl. https://www.w3schools.com/howto/howto_js_slideshow.asp -->
<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext">1 / 4</div>
  <img src="img/Start.jpg" width=1000 height=500 alt="start">
  <div class="text">Start</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 4</div>
  <img src="img/Nike.jpg" width=1000 height=500 alt="nike">
  <div class="text">Nike</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 4</div>
  <img src="img/Puma.jpg" width=1000 height=500 alt="puma">
  <div class="text">Puma</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">4 / 4</div>
  <img src="img/Adidas.jpg" width=1000 height=500 alt="adidas">
  <div class="text">Adidas</div>
</div>

<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
<a class="next" onclick="plusSlides(1)">&#10095;</a>

</div>
<br>

<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span> 
  <span class="dot" onclick="currentSlide(2)"></span> 
  <span class="dot" onclick="currentSlide(3)"></span>
  <span class="dot" onclick="currentSlide(4)"></span> 
</div>

<script>
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}
</script>
	<div id="footer">
		<%@include file="jspf/footer.jspf"%>
	</div>
</body>
</html>