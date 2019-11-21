/* Michael   quelle: https://www.w3schools.com/jsref/prop_style_border.asp */
'use strict';
document.addEventListener("DOMContentLoaded", init);

var password;
var passwordRepeat;

function init() {
	// set DOM
	password = document.getElementById("newPassword");
	passwordRepeat = document.getElementById("passwordRepeat");

	// set Event Listener

	password.addEventListener("input", function(e) {
		comparePasswords();
	});
	passwordRepeat.addEventListener("input", function(e) {
		comparePasswords();
	});
}

function comparePasswords() {
	if (password.value != passwordRepeat.value) {
		password.style.border = "5px groove red";
		passwordRepeat.style.border = "5px groove red";
	} else {
		password.style.border = "5px groove #00ff00";
		passwordRepeat.style.border = "5px groove #00ff00";
	}
}