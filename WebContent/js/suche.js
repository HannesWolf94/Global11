//erstellt von Martin Scherzer
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