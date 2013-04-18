// define something like:
// org.app.components, sau
// org.lib.component

function testDefNamespace(){
	app.namespace("org.app.components");
	org.app.components.Pojo = {};
	org.app.components.Pojo.name = "POJO";
	console.log("Type of object: " + (typeof org.app.components.Pojo));
}

var app = {};
app.namespace = function(ns){
	var inners = ns.split('.');
	parent = "org";
	
	if (inners[0] === "org")
		inners = inners.slice(1);
	
	for(var i = 0; i < inners.length; i++){
		console.log("parent.inners[i]: " + parent + "." + inners[i] + " :" + parent[inners[i]]);
		if (typeof parent[inners[i]] === "undefined"){
			parent[inners[i]] = {};
			console.log("parent.inners[i] = " + parent + "." + inners[i] + " :" + parent[inners[i]]);
		}
		console.log("parent.inners[i]: " + parent + "." + inners[i] + " :" + parent[inners[i]]);
		parent = parent[inners[i]];
	}
	
	return parent;
}