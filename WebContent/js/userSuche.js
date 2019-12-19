"use strict";
document.addEventListener("DOMContentLoaded", init);
function init() {
	document.getElementById("button2").addEventListener("click", changeContent);
}

function changeContent() {
	var searchURL = "../UserSuche";
	var lastName = document.getElementById("lastName2").value;
	if (lastName != null && lastName.length > 0)
		searchURL += "?lastName2=" + encodeURIComponent(lastName);

	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			console.log(xmlhttp.responseText);
			var usersList = JSON.parse(xmlhttp.responseText);
			console.log(usersList);
			if (usersList == null || usersList.length == 0) {
				document.getElementById("hitlist").innerHTML = "Keine Treffer";
				return;
			}

			var ausgabe = "<table><tr><th>ID</th><th>Email</th><th>Vorname</th><th>Nachname</th><th>Straße u. Hausnr.</th><th>PLZ u. Ort</th></tr>";
			console.log(usersList.length);
			for (var i = 0; i < usersList.length; i++) {
							
				ausgabe += "<tr><td>";
				ausgabe += usersList[i].Id;
				ausgabe += "</td><td>";
				ausgabe += usersList[i].Email;
				ausgabe += "</td><td>";
				ausgabe += usersList[i].Firstname;
				ausgabe += "</td><td>";
				ausgabe += usersList[i].Lastname;
				ausgabe += "</td><td>";
				ausgabe += usersList[i].Street;
				ausgabe += "</td><td>";
				ausgabe += usersList[i].City;
				ausgabe += "</td></tr>";
			}
			ausgabe += "</table>";
			
			document.getElementById("hitlist").innerHTML = ausgabe;
		}
	}
	xmlhttp.open("GET", searchURL, true);
	xmlhttp.send();
}
