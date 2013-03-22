log = function() {
	var p = document.createElement("p");	
	var message = Array.prototype.join.call(arguments, " ");
	p.innerHTML = message;
	document.getElementById("info").appendChild(p);
}

clearLog = function(){
	var logdiv = document.getElementById("info");
	if (logdiv){
		var logs = logdiv.childNodes;
		if (logs)
			while(logs.length > 0)
				logdiv.removeChild(logs[0]);
	}
}