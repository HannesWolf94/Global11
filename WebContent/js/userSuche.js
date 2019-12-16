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

	console.log("Scherzer");
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

			var ausgabe = "<table><tr><th>Id</th><th>Email</th><th>Vorname</th><th>Nachname</th></tr>";
			console.log(usersList.length);
			for (var i = 0; i < usersList.length; i++) {
				
				console.log(usersList[i].Id);
				console.log(usersList[i].Email);
				console.log(usersList[i].Firstname);
				console.log(usersList[i].Lastname);
					
				ausgabe += "<tr><td>";
				ausgabe += usersList[i].Id;
				ausgabe += "</td><td>";
				ausgabe += usersList[i].Email;
				ausgabe += "</td><td>";
				ausgabe += usersList[i].Firstname;
				ausgabe += "</td><td>";
				ausgabe += usersList[i].Lastname;
				ausgabe += "</td><td>";
				ausgabe += usersList[i].street;
				ausgabe += "</td><td>";
				ausgabe += usersList[i].city;
				ausgabe += "</td></tr>";
			}
			ausgabe += "</table>";
			
			console.log("===ausgabe start===");
			console.log(ausgabe);
			console.log("===ausgabe ende===");
			document.getElementById("hitlist").innerHTML = ausgabe;
		}
	};
	xmlhttp.open("GET", searchURL, true);
	xmlhttp.send();
}
