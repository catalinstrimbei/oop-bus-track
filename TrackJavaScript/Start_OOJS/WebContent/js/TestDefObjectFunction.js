function test(){
	console.log("Test Object Function!");
	
	var poj = new Object(1);
	poj.id = 1001;
	for (pro in poj){
		console.log("Object property " + pro + ":" + poj[pro]);
	}
	console.log("Type of object: " + (typeof poj));
	console.log("Object super: " + poj.prototype);
};


