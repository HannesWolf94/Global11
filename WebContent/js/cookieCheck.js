/* vgl. https://wiki.selfhtml.org/wiki/JavaScript/Navigator/cookieEnabled */
'use strict';
document.addEventListener("DOMContentLoaded", cookieCheck);

function cookieCheck(){
	if (!navigator.cookieEnabled) {
		  alert("Cookies sind deaktiviert , bitte aktivieren Sie die Cookies!");
		} 
}
