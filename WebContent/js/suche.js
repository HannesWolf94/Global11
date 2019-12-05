"use strict";
document.addEventListener("DOMContentLoaded", init);
function init() {
	document.getElementById("button").addEventListener("click", changeContent);
}

function changeContent() {
	var searchURL = "Suche";
	var label = document.getElementById("label").value;
	if (label != null && label.length>0)
		searchURL += "?label=" + encodeURIComponent(label);
	
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("hitlist").innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET", searchURL , true);
	xmlhttp.send();
}


//function changeContent() {
//	var searchURL = "Suche";
//	var label = document.getElementById("label").value;
//	if (label != null && label.length > 0)
//		searchURL += "?label=" + encodeURIComponent(label);
//
//	var xmlhttp = new XMLHttpRequest();
//	xmlhttp.onreadystatechange = function() {
//		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
//			var productList = JSON.parse(xmlhttp.responseText);
//			if (productList == null || productList.length == 0) {
//				document.getElementById("hitlist").innerHTML = "Keine Treffer";
//				return;
//			}
//
//			var ausgabe = "<table><tr><th>Id</th><th>Hersteller</th><th>Type</th><th>Farbe</th><th>Preis</th></tr>";
//			for (var i = 0; i < productList.length; i++) {
//				ausgabe += "<tr><td>";
//				ausgabe += productList[i].prodId;
//				ausgabe += "</td><td>";
//				ausgabe += productList[i].label;
//				ausgabe += "</td><td>";
//				ausgabe += productList[i].type;
//				ausgabe += "</td><td>";
//				ausgabe += productList[i].colour;
//				ausgabe += "</td></tr>";
//				ausgabe += productList[i].price;
//				ausgabe += "</td></tr>";
//			}
//			ausgabe += "</table>";
//			document.getElementById("hitlist").innerHTML = ausgabe;
//		}
//	};
//	xmlhttp.open("GET", searchURL, true);
//	xmlhttp.send();
//}