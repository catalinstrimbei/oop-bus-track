function loopSearchCollection(key, keyCollection){
	for(var i = 0; i < keyCollection.length; i++) {
		if (keyCollection[i].id == key)
			return keyCollection[i];
	}	
}

onmessage = function(event){
	var currentKey = event.data[0];
	var currentKeyCollection = event.data[1];
	// DEBUG throw new Error("WORKER FORCE ERROR DEBUG: " + event.data + " - " +  currentKey + " - " + currentKeyCollection);
	var value = null; 
	if (currentKey && currentKeyCollection){
		value = loopSearchCollection(currentKey, currentKeyCollection);
	}	
	postMessage(value);
}