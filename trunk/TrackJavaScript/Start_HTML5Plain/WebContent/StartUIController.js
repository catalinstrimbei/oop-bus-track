console.log("Loading StartForm ... " + Date());

window.onload = function(){
	getCustomer();
};

//
function getCustomer(){
	var urlRest = "http://localhost:9999/restbackend/customer/json/getcustomer";
	//var urlRest = "http://localhost:9999/restbackend/hello/json/getcustomer";
	//var urlRest = "http://localhost:8080/ProRest_WebBackend/rest/hello/json/getcustomer";
	var reqRest = new XMLHttpRequest();
	reqRest.onload = function(){
		if (reqRest.status == 200){
			console.log("REST Response: " + reqRest.responseText);
			
			var customer = JSON.parse(reqRest.responseText);

			console.log("ID: " + customer.id);
			console.log("Name: " + customer.name);

			document.getElementById("customerID").value = customer.id;
			document.getElementById("customerName").value = customer.name;
		}else{
			console.log("REST Request problem: " + reqRest.responseText);
		}
	};
	reqRest.open("GET", urlRest);
	reqRest.send(null);
}
function getCustomers(){
	var urlRest = "http://localhost:9999/restbackend/customer/json/getcustomers";
	var reqRest = new XMLHttpRequest();
	reqRest.onload = function(){
		if (reqRest.status == 200){
			console.log("REST Response: " + reqRest.responseText);
			
			var customers = JSON.parse(reqRest.responseText);
			var selectCustomers = document.getElementById("customers");
			var defaultElement = document.getElementById("defCustomerElement");
			selectCustomers.removeChild(defaultElement);
			for(var i = 0; i < customers.length; i++) {
			    var customerElement = document.createElement("option");
			    customerElement.textContent = customers[i].name;
			    customerElement.value = customers[i].id;
			    selectCustomers.appendChild(customerElement);
			}		

			document.getElementById("response").innerHTML = customers[0].id + " - " + customers[0].name;
			
		}else{
			console.log("REST Request problem: ");
		}
	};
	reqRest.open("GET", urlRest);
	reqRest.send(null);
}
//--allow-file-access-from-files --disable-web-security
// file:///E:/Professional/Programare_OO/JavaScript/oop-bus-track-javascript/Start_HTML5Plain/WebContent/StartForm.html