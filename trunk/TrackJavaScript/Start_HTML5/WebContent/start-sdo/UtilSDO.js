var urlRestSDO = "http://localhost:8080/ProRest_WebBackend/services/customer/getxmlcustomersdo";
var customerServiceSDO = new CustomerServiceSDO(urlRestSDO);

//window.onload = loadSDO;


// Util functions
function loadSDO(){
	console.log("Loading SDOForm. " + Date());
	customerServiceSDO.getCustomers(showData);
	
}

function showData(data){
	console.log("Show JSON FULL: ");
	console.log(JSON.stringify(data));
	console.log("Show JSON XML SCHEMA: ");
	console.log(JSON.stringify(data.envelope["xsd:schema"]));	
	console.log("Show JSON DATA: ");
	console.log(JSON.stringify(data.envelope.customer));
}

function CustomerServiceSDO(url){
	// service configuration attributes
	this.urlRestBase = url;
	
	// service operations/functions - map to REST operations
	this.getCustomers =  function(dataHandler){
		var reqRest = new XMLHttpRequest();
		reqRest.onload = function(){
			if (reqRest.status == 200){
				console.log("REST Response: " + reqRest.responseText);
				// get objects from REST response
				//customers = xml2json.parser(reqRest.responseText);
				var xotree = new XML.ObjTree();
				customers = xotree.parseXML(reqRest.responseText);
				// callback
				dataHandler(customers);
			}else{
				console.log("REST Request problem or ERROR ");
			}
		};
		reqRest.open("GET", this.urlRestBase);
		reqRest.send(null);		
	}
}