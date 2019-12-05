"use strict";
document.addEventListener("DOMContentLoaded", init);
function init() {
	document.getElementById("button").addEventListener("click", changeContent);
}

function changeContent() {
	var searchURL = "demo16servlet";
	var lastname = document.getElementById("lastname").value;
	if (lastname != null && lastname.length > 0)
		searchURL += "?lastname=" + encodeURIComponent(lastname);

	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var employeeList = JSON.parse(xmlhttp.responseText);
			if (employeeList == null || employeeList.length == 0) {
				document.getElementById("hitlist").innerHTML = "Keine Treffer";
				return;
			}

			var ausgabe = "<table><tr><th>Id</th><th>Vorname</th><th>Nachname</th><th>Alter</th></tr>";
			for (var i = 0; i < employeeList.length; i++) {
				ausgabe += "<tr><td>";
				ausgabe += employeeList[i].id;
				ausgabe += "</td><td>";
				ausgabe += employeeList[i].firstname;
				ausgabe += "</td><td>";
				ausgabe += employeeList[i].lastname;
				ausgabe += "</td><td>";
				ausgabe += employeeList[i].age;
				ausgabe += "</td></tr>";
			}
			ausgabe += "</table>";
			document.getElementById("hitlist").innerHTML = ausgabe;
		}
	};
	xmlhttp.open("GET", searchURL, true);
	xmlhttp.send();
}