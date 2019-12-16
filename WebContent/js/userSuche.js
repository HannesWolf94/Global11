"use strict";
document.addEventListener("DOMContentLoaded", init);
function init() {
	document.getElementById("button2").addEventListener("click", changeContent);
}

function changeContent() {
	var searchURL = "../../UserSuche";
	var lastName = document.getElementById("lastName2").value;
	if (lastName != null && lastName.length > 0)
		searchURL += "?lastName=" + encodeURIComponent(lastName);

	System.out.println("Scherzer");
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var usersList = JSON.parse(xmlhttp.responseText);
			if (usersList == null || usersList.length == 0) {
				document.getElementById("hitlist").innerHTML = "Keine Treffer";
				return;
			}

			var ausgabe = "<table><tr><th>Id</th><th>Email</th><th>Vorname</th><th>Nachname</th></tr>";
			for (var i = 0; i < usersList.length; i++) {
				ausgabe += "<tr><td>";
				ausgabe += usersList[i].userId;
				ausgabe += "</td><td>";
				ausgabe += usersList[i].email;
				ausgabe += "</td><td>";
				ausgabe += usersList[i].firstName;
				ausgabe += "</td><td>";
				ausgabe += usersList[i].lastName;
				ausgabe += "</td><td>";
				ausgabe += usersList[i].street;
				ausgabe += "</td><td>";
				ausgabe += usersList[i].city;
				ausgabe += "</td></tr>";
			}
			ausgabe += "</table>";
			document.getElementById("hitlist").innerHTML = ausgabe;
		}
	};
	xmlhttp.open("GET", searchURL, true);
	xmlhttp.send();
}
