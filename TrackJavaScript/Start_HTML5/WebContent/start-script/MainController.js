/* Resposibilities
 * - control resource access
 * - backend services integration
 * - host global/application state vars (data structures)
 * 	 - configuration as URLS
 *   - data model and local persistence 
 * - control form lifecycle (ex. initialization)
 */

// CFG: backend services integration configuration
var urlRestBase = "http://localhost:8080/ProRest_WebBackend/services/customer/json/";

// CFG: data model definition
var customerService = new CustomerService(urlRestBase);
var customer;
var customers;


// Form life-cycle: init
window.onload = function(){
	console.log("Loading StartForm. " + Date() + " WebWorkers support: " + typeof(Worker));
	initDataModel();
	
};
// Form life-cycle: ending
window.onunload = function(){
	console.log("UnLoading StartForm ... " + Date());
	// save to localStorage the application state
	// cleanup resource usage
}

// Form life-cycle callbacks: data model 
function initDataModel(){
	console.log(" - initDataModel ... " + Date());
	// asynchronous binding form 
	customerService.getCustomers(bindingForm);
	// Disable form
	disableFormContent(true);	
}



/* INFOS
 * - Change HTTP Preview Default Port in .metadata.plugins\org.eclipse.wst.server.core/servers.xml
 * 		-- add port="8081"
 * 
 * 
 */