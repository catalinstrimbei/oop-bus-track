// define something like:
// org.app.components, sau
// org.lib.component
function testDefNamespace(){	
	//var module = app.namespace("org.app.components");
	//org.app.components.Pojo = {};
	//org.app.components.Pojo.name = "POJO";
	//console.log("Type of object: " + (typeof org.app.components.Pojo));
	
	app = app.namespace("org.app.components");
	var module = org.app.components;
	console.log("End point ... " + module);
}


var app = {};
app.namespace = function(ns){
	var inners = ns.split('.');
	var parent = app;
	
	//if (inners[0] === "org")
	//	inners = inners.slice(1);
	
	for(var i = 0; i < inners.length; i++){
		if (typeof parent[inners[i]] === "undefined"){
			parent[inners[i]] = new Object();
			console.log("init parent.inners[" + i + "]  = " + parent[inners[i]]);
		}
		parent = parent[inners[i]];
	}
	
	return parent;
};
