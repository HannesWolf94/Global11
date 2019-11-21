/* Michael   quelle: https://www.w3schools.com/jsref/prop_style_border.asp */
'use strict';
document.addEventListener("DOMContentLoaded", init);

var pw3;
var pw4;

function init() {
	// set DOM
	pw3 = document.getElementById("pwRegi");
	pw4 = document.getElementById("pwRegiR");

	// set Event Listener

	pw3.addEventListener("input", function(e) {
		comparePasswordRegi();
	});
	pw4.addEventListener("input", function(e) {
		comparePasswordRegi();
	});
}

function comparePasswordRegi() {
	if (pw3.value != pw4.value) {
		pw3.style.border = "5px groove red";
		pw4.style.border = "5px groove red";
	} else {
		pw3.style.border = "5px groove #00ff00";
		pw4.style.border = "5px groove #00ff00";
	}
}