'use strict';
document.addEventListener("DOMContentLoaded", init);

var id;
var idRepeat;

function init() {
	// set DOM
	id = document.getElementById("prodId");
	idRepeat = document.getElementById("prodIdRepeat");

	// set Event Listener

	id.addEventListener("input", function(e) {
		compareProdId();
	});
	idRepeat.addEventListener("input", function(e) {
		compareProdId();
	});
}

function compareProdId() {
	if (id.value != idRepeat.value) {
		id.style.border = "5px groove red";
		idRepeat.style.border = "5px groove red";
	} else {
		id.style.border = "5px groove #00ff00";
		idRepeat.style.border = "5px groove #00ff00";
	}
}