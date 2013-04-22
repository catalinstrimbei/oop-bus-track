console.log("Load DefNamespace3.js ...");

/*--- BEGIN Loading API/Library --------------------------*/
var org = {};
var API = {};

// API Functions: //add packaging prefix: org.app.components, or org.lib.component
API.package = function(ns){
	var inners = ns.split('.');
	
	var parent = org;
	if (inners[0] === "org")
		inners = inners.slice(1);
	
	for(var i = 0; i < inners.length; i++){
		if (typeof parent[inners[i]] === "undefined"){
			parent[inners[i]] = {};
		}
		parent = parent[inners[i]];
	}
	return parent;
};

API.package('org.app.components.API');

// API def
org.app.components.API.showOff = function(){
	console.log("org.app.components.API.showOff CALL!");
}
/*--- END Loading API/Library ---------------------------*/


/*--- Testing context -----------------------------------*/
function testDefPackage(){	
	console.log("End point ... ");
	org.app.components.API.showOff();
}



