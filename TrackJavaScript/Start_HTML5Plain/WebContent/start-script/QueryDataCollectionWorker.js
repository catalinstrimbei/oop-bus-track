function loopSearchCollection(key, keyCollection){
	//console.log("QueryDataCollectionWorker in progrress: loopSearchCollection for " + key + " in " + keyCollection);
	for(var i = 0; i < keyCollection.length; i++) {
		if (keyCollection[i].id == key)
			return keyCollection[i];
	}	
}

onmessage = function(event){
	//console.log("QueryDataCollectionWorker in progrress: " + event.data);
	var currentKey = event[0];
	var currentKeyCollection = event[1];
	var value = null; 
	
	//if (currentKey && currentKeyCollection){
		value = loopSearchCollection(currentKey, currentKeyCollection);
	//}
	
	postMessage(value);
}