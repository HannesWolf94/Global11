<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<meta http-equiv="Content-Type" charset="UTF-8">
<title>Startseite</title>
</head>

<body>
	<div id="header">
		<%@include file="jspf/header.jspf"%>
	</div>
	<p class="blocksatz">Wir von Global 11 begrüßen dich recht herzlich
		in unserem Sport Online Shop und wünschen dir viel Spaß beim Shoppen.
		Bei uns findest du eine reichhaltige Artikel Auswahl rund um das Thema
		Fußballschuhe.</p>

	<nav class="nav">
		<h1 class="logotext">GLOBAL 11</h1>
		<div class="logonav">
			<button class="logonavbtn">
				<span class="logonavbtntxt" onclick="opentab(event, 'start')"
					id="defaultOpen">Start</span>
			</button>

			<button class="logonavbtn">
				<span class="logonavbtntxt" onclick="opentab(event, 'news')">Neuheiten</span>
			</button>

			<button class="logonavbtn">
				<span class="logonavbtntxt" onclick="opentab(event, 's1')">Serie
					1</span>
			</button>

			<button class="logonavbtn">
				<span class="logonavbtntxt" onclick="opentab(event, 's2')">Serie
					2</span>
			</button>
			<button class="logonavbtn">
				<span class="logonavbtntxt" onclick="opentab(event, 's3')">Serie
					3</span>
			</button>
		</div>
	</nav>
	<div class="body">

		<div id="start" class="tabcontent">
			<!--tabstart.html-->
		</div>

		<div id="news" class="tabcontent">
			<!--tabnews.html-->
		</div>

		<div id="s1" class="tabcontent">
			<!--tabs1.html-->
		</div>

		<div id="s2" class="tabcontent">
			<!--tabs2.html-->
		</div>

		<div id="s3" class="tabcontent">
			<!--tabs3.html-->
		</div>

	</div>




	<div id="footer">
		<%@include file="jspf/footer.jspf"%>
	</div>
</body>
</html>