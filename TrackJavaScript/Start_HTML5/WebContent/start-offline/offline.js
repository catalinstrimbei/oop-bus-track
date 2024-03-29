/*
 * log each of the events fired by window.applicationCache
 */
window.applicationCache.onchecking = function(e) {
	log("Checking for application update");
}

window.applicationCache.onnoupdate = function(e) {
	log("No application update found");
}

window.applicationCache.onupdateready = function(e) {
	log("Application update ready");
	if (confirm("A new version of this application is available. Reload now?")) {
		window.location.reload();
	}
}

window.applicationCache.onobsolete = function(e) {
	log("Application obsolete");
}

window.applicationCache.ondownloading = function(e) {
	log("Downloading application update");
}

window.applicationCache.oncached = function(e) {
	log("Application cached");
}

window.applicationCache.onerror = function(e) {
	log("Application cache error");
}

window.addEventListener("online", function(e) {
	log("Online");
}, true);

window.addEventListener("offline", function(e) {
	log("Offline");
}, true);

/*
 * Convert applicationCache status codes into messages
 */
showCacheStatus = function(n) {
	statusMessages = [ "Uncached", "Idle", "Checking", "Downloading",
			"Update Ready", "Obsolete" ];
	return statusMessages[n];
}

install = function() {
	clearLog();
	log("Checking for updates");
	
	
	try {
		window.applicationCache.update();
	} catch (e) {
		applicationCache.onerror();
	}
	
}

on_off = function() {
	var online = navigator.onLine;
	var onlineURL = "http://localhost:8081/Start_HTML5/StartOnlineApp.html";
	if(online){
		document.getElementById("statusButon").innerHTML = "ONLINE";
		if (confirm("Online version is available. Switch to online ?[" + onlineURL + "]"))
			window.location.href = onlineURL;
	}else{
		document.getElementById("statusButon").innerHTML= "OFFLINE";
	}
}

/*
 * START processing
 * 
 * Demos:
 * http://html5demos.com/
 * 
 * Chrome offline apps:
 * chrome://appcache-internals/
 * 
 * 
*/
onload = function(e) {
	// Check for required browser features
	if (!window.applicationCache) {
		log("HTML5 Offline Applications are not supported in your browser.");
		return;
	}
	if (!window.localStorage) {
		log("HTML5 Local Storage not supported in your browser.");
		return;
	}
	log("Initial cache status: "
			+ showCacheStatus(window.applicationCache.status));
	
	document.getElementById("statusButon").onclick = on_off;
	document.getElementById("installButton").onclick = install;
}