var SDO = SDO || {};
SDO.XMLSDORequest = function(_wsurl, _wsquery){
	this.wsurl = _wsurl;
	this.wsquery = _wsquery;
	this.sdodata = null;
	this.storeFactoryCallback = null;
	
	this.execute = function(_storeFactoryCallback){
		this.storeFactoryCallback = _storeFactoryCallback;
		var url = wsurl + "?query=" + wsquery;
		open("GET", url);
		send(null);			
	};
	
	this.onload = function(){
		if (this.status == 200){
			var xotree = new XML.ObjTree();
			this.sdodata = xotree.parseXML(reqRest.responseText);
			// callback
			this.storeFactoryCallback(this);
		}else{
			console.log("REST Request problem or ERROR !");
		}
	};
	
	this.getSDOSchema = function(){
		return this.sdodata["envelope"]["xsd:schema"];
	};

	this.getSDOData = function(){
		return this.sdodata["envelope"]["sdodata"];
	};
	
};
SDO.XMLSDORequest.prototype = new XMLHttpRequest();

/*---------------------------------------------------------------*/
SDO.LocalStoreFactory = function(){
	// create new LocalStore and persist metadata
	this.defineDataStore = function(_wsurl,_wssql, _keyName){
		var storeHashId = computeStoreHashId(_wsurl,_wssql);
		var storeDef = {wsurl: _wsurl, wssql: _wssql};
		localStorage.setItem(storeHashId, storeDef);
	};
	// load data in store
	this.loadData = function(localStore){
		var dataRequest = new SDO.XMLSDORequest(localStore.wsurl, localStore.wsquery);
		dataRequest.execute(this.xmlSDORequestReadyCallback);
	};
	// callback
	this.xmlSDORequestReadyCallback = function(sdoRequest){
		var storeHashId = computeStoreHashId(sdoRequest.wsurl,sdoRequest.wssql);
		var localStore = localStorage.getItem(storeHashId);
		if(localStore.schema === "undefined")
			localStore.schema = sdoRequest.getSDOSchema();
		localStore.removeAll();
		localStore.addAll(sdoRequest.getSDOData());
	};
	// return hash value url and sql
	var computeStoreHashId = function(){
		/* ... ... */
	};
};

/*---------------------------------------------------------------*/
SDO.LocalStore = function(_storeid, _wsurl,_wssql, _keyName){
	this.id = _storeid;
	this.wsurl = _wsurl;
	this.wsquery = _wsquery;	
	this.keyName = _keyName;
	this.schema = null;
	// add new or data
	this.add = function(data){
		if (!validateDataConformance(data))
			throw new TypeError("Schema non conformance!");
		var storedHashKey = computeHashKey(this.id, data[this.keyName]);
		var storedData = getStoreData(storedHashKey);
		if (storedData)
			throw new Error("Uniqueness non conformance!");
		// persist data
		localStorage.setItem(storedHashKey, data);
	};
	this.addAll = function(dataArray){
		for(var i in dataArray)
			this.add(dataArray[i]);
	};
	// check data against schema
	var validateDataConformance = function(data){
		/* ... ... */
		return true;
	};
	// restore persistent data from localStorage
	var getStoreData = function(hashKey){
		return localStorage.getItem(hashKey);
	};
	// return hash value from store id and key value
	var computeHashKey = function(){
		/* ... ... */
	};
	this.removeAll = function(){
		/* ... ... */
	};
};
/*---------------------------------------------------------------*/