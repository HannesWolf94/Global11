/**
 * Martin Scherzer
 */
"use strict";
var password = document.getElementById("password");
var passwordrepeat = document.getElementById("passwordrepeat");

function matchPassword() {
    if (password.value !== passwordrepeat.value) {
    	passwordrepeat.setCustomValidity("Passwörter stimmen nicht überein");
    } else {
    	passwordrepeat.setCustomValidity("");
    }
}

password.onchange = matchPassword;
passwordrepeat.onkeyup = matchPassword;