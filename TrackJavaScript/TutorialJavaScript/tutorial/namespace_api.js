/**
 * JS Design Pattern: namespace
 * - create a "namespace" object for app or modules
 */
// API
var APP = {};
APP.namespace = function(name){
	var parts = name.split('.');
	var parent = APP;
	for (var i in parts){
		if (!parent[parts[i]])
			parent[parts[i]] = {};
		parent = parent[parts[i]];
	}
}

// Test API
APP.namespace('org.app.model'); // APP.org = {} .. APP.org.app = {} .. APP.org.app.model = {}
APP.org.app.model.project = {name: "test"};
var obj = APP.org.app.model.project 
console.log("APP.org.app.model.project: " + obj.name);

// Exit
phantom.exit();