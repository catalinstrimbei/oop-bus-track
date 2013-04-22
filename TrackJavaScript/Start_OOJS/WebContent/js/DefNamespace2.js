console.log("Load DefNamespace2.js ...");

/*--- BEGIN Loading API/Library --------------------------*/
var MOD = {};

// API Functions: //add packaging prefix: org.app.components, or org.lib.component
MOD.namespace = function(ns){
	var inners = ns.split('.');
	
	//var parent = inners[0];
	//inners = inners.slice(1);
	var parent = MOD;
	
	for(var i = 0; i < inners.length; i++){
		if (typeof parent[inners[i]] === "undefined"){
			parent[inners[i]] = {};
		}
		parent = parent[inners[i]];
	}
	
	return parent;
};

MOD.namespace('org.app.components');

// Module def
MOD.org.app.components.showOff = function(){
	console.log("MOD.org.app.components.showOff CALL!");
}
/*--- END Loading API/Library ---------------------------*/


/*--- Testing context -----------------------------------*/
function testDefNamespace(){	
	console.log("End point ... ");
	MOD.org.app.components.showOff();
}



