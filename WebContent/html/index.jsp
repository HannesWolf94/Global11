<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="head.jspf" %> 
<link rel="stylesheet" type="text/css" href="../style/startseite.css">
	   <main>
			<p class="blocksatz">Wir von Global 11 begrüßen dich recht herzlich in unserem Sport Online Shop und wünschen dir viel Spaß beim Shoppen. Bei uns findest du eine reichhaltige Artikel Auswahl rund um das Thema Fußballschuhe.</p>
<!--  vgl. https://www.w3schools.com/howto/howto_js_slideshow.asp -->
<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext">1 / 4</div>
  <img src="../img/Start.jpg" width=1000 height=500 alt="start">
  <div class="text">Start</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 4</div>
  <img src="../img/Nike.jpg" width=1000 height=500 alt="nike">
  <div class="text">Nike</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 4</div>
  <img src="../img/Puma.jpg" width=1000 height=500 alt="puma">
  <div class="text">Puma</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">4 / 4</div>
  <img src="../img/Adidas.jpg" width=1000 height=500 alt="adidas">
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
		  <div class="leistungen">
		   <h3>Unsere Produkte:</h3>
		   <ul>
			 <li>Adidas</li>
			   <ul>
				 <li>Ace</li>
				 <li>Copa</li>
				 <li>X</li>
			   </ul>
			 <li>Nike</li>
			 <ul>
				 <li>Magista</li>
				 <li>Mercurial</li>
				 <li>Tiempo</li>
			   </ul>
			 <li>Puma</li>
			 <ul>
				 <li>Future</li>
				 <li>Klassiker</li>
				 <li>One</li>
			   </ul>
			  </ul>
			 </div>
			<p>Sie haben noch kein Konto? Dann <a href="registrierung.jsp">registrieren</a> Sie sich jetzt!</p>
			<p>Sie sind bereits Kunde? Dann <a href="login.jsp">loggen</a> Sie sich ein!</p>
		</main>
<%@ include file="footer.jspf" %> 