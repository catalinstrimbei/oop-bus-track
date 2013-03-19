// JavaScript Wrapper for Customer REST Service
function CustomerService(url){
	// service configuration attributes
	this.urlRestBase = url;
	
	// service operations/functions - map to REST operations
	this.getCustomers =  function(dataHandler){
		var urlRest = urlRestBase + "getcustomers";
		var reqRest = new XMLHttpRequest();
		reqRest.onload = function(){
			if (reqRest.status == 200){
				console.log("REST Response: " + reqRest.responseText);
				// populate selectCustomers navigator combo from REST response
				customers = JSON.parse(reqRest.responseText);
				// callback
				dataHandler(customers);
			}else{
				console.log("REST Request problem or ERROR ");
			}
		};
		reqRest.open("GET", urlRest);
		reqRest.send(null);		
	}
	this.saveCustomers =  function(){
		// TODO
	}
}