//erstellt von Michael Haid
/* Quelle: https://www.w3schools.com/jsref/prop_style_border.asp */
'use strict';
document.addEventListener("DOMContentLoaded", init);

var email;
var emailRepeat;

function init() {
	// set DOM
	email = document.getElementById("email");
	emailRepeat = document.getElementById("emailRepeat");

	// set Event Listener

	email.addEventListener("input", function(e) {
		compareEmails();
	});
	emailRepeat.addEventListener("input", function(e) {
		compareEmails();
	});
}

function compareEmails() {
	if (email.value != emailRepeat.value) {
		email.style.border = "5px groove red";
		emailRepeat.style.border = "5px groove red";
	} else {
		email.style.border = "5px groove #00ff00";
		emailRepeat.style.border = "5px groove #00ff00";
	}
}