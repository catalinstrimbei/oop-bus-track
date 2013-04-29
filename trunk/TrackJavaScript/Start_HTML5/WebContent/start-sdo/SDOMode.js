var XMLSDORequest = function(_wsurl, _wsquery){
	var wsurl = _wsurl;
	var wsquery = _wsquery;
	
	this.sdodata = null;
	
	this.sendRequest = function(){
		var url = wsurl + "?query=" + wsquery;
		open("GET", url);
		send(null);			
	};
	
	this.onload = function(){
		if (this.status == 200){
			var xotree = new XML.ObjTree();
			this.sdodata = xotree.parseXML(reqRest.responseText);
			// callback
			dataHandler(data);
		}else{
			console.log("REST Request problem or ERROR ");
		}
	};
	
	this.getSDOSchema = function(){
		return this.sdodata["envelope"]["xsd:schema"];
	};

	this.getSDOData = function(){
		return this.sdodata["envelope"]["sdodata"];
	};
	
};
XMLSDORequest.prototype = new XMLHttpRequest();
