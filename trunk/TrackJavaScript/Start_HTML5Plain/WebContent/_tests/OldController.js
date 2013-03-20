
// backend services integration configuration
var urlRestBase = "http://localhost:8080/ProRest_WebBackend/services/customer/json/";

// data model definition
var customer;
var customers;


console.log("Loading StartForm ... " + Date());
window.onload = function(){
	getCustomers();
};



function getCustomer(){
	var urlRest = urlRestBase + "getcustomer";
	
	var reqRest = new XMLHttpRequest();
	reqRest.onload = function(){
		if (reqRest.status == 200){
			console.log("REST Response: " + reqRest.responseText);
			
			customer = JSON.parse(reqRest.responseText);

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
	//var urlRest = "http://localhost:9999/restbackend/customer/json/getcustomers";
	var urlRest = urlRestBase + "getcustomers";
	
	var reqRest = new XMLHttpRequest();
	reqRest.onload = function(){
		if (reqRest.status == 200){
			console.log("REST Response: " + reqRest.responseText);
			// populate selectCustomers navigator combo from REST response
			customers = JSON.parse(reqRest.responseText);
			var selectCustomers = document.getElementById("customers");
			// reset options
			//var defaultElement = document.getElementById("defCustomerElement");
			//selectCustomers.removeChild(defaultElement);
			while(selectCustomers.options.length > 0){
				selectCustomers.removeChild(selectCustomers.options[0]);
			}
			for(var i = 0; i < customers.length; i++) {
			    var customerElement = document.createElement("option");
			    customerElement.textContent = customers[i].name;
			    //customerElement.value = customers[i];
			    customerElement.value = customers[i].id;
			    selectCustomers.appendChild(customerElement);
			}		
			customer = customers[0];
			// refresh form
			console.log("customer.id = " + customer.id);
			document.getElementById("customerID").value = customer.id;
			document.getElementById("customerName").value = customer.name;				
			document.getElementById("response").innerHTML = customers[0].id + " - " + customers[0].name;
			
		}else{
			console.log("REST Request problem: ");
		}
	};
	reqRest.open("GET", urlRest);
	reqRest.send(null);
}


function selectCurrentCustomer(){
	var selectCustomers = document.getElementById("customers");
	var currentId = selectCustomers.value;
	console.log("currentId = " + currentId);
	for(var i = 0; i < customers.length; i++) {
		if (customers[i].id == currentId)
			customer = customers[i];
	}
	// refresh form
	console.log("customer.id = " + customer.id);
	document.getElementById("customerID").value = customer.id;
	document.getElementById("customerName").value = customer.name;	
}

function postFormCustomer(){
	alert("Submit form customer");
	var myJsonText=JSON.stringify(customer);
	var myJsonObject=JSON.parse(myJsonText);
	
	alert("myJsonObject = " + JSON.stringify(myJsonObject));
	
	//var urlRest = "http://localhost:9999/restbackend/customer/json/savecustomer";
	var urlRest = urlRestBase + "savecustomer";
	
	var reqRest = new XMLHttpRequest();
	reqRest.onload = function(){
		if (reqRest.status == 200){
			console.log("REST Response: " + reqRest.responseText);
			
			customer = JSON.parse(reqRest.responseText);
			
			document.getElementById("customerID").value = customer.id;
			document.getElementById("customerName").value = customer.name;	
			
			document.getElementById("response").innerHTML = reqRest.responseText;
		}else{
			console.log("REST Request problem: " + reqRest.responseText);
		}
	};
	reqRest.open("POST", urlRest, true);
	reqRest.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
	reqRest.send(JSON.stringify(myJsonObject));	
	
	
	
	console.log("Submited form ... ");
}

function postFormCustomer2(){
	
	var myJsonText=JSON.stringify(customer);
	alert("Submit form customer: " + myJsonText);
	
	var myJsonObject=JSON.parse(myJsonText);
	
	alert("myJsonObject = " + JSON.stringify(myJsonObject));
	
	//var urlRest = "http://localhost:9999/restbackend/customer/json/savecustomer";
	var urlRest = urlRestBase + "savecustomer";
	var requestNumber = JSONRequest.post(
				urlRest, 
				myJsonObject,
				function (requestNumber, value, exception) {
					alert(value);
			        if (value) {
			            alert(value);
			        } else {
			        	alert(exception);
			        }
			    }				
			);
	
	
	
	document.getElementById("response").innerHTML = requestNumber;
}
//--allow-file-access-from-files --disable-web-security
// file:///E:/Professional/Programare_OO/JavaScript/oop-bus-track-javascript/Start_HTML5Plain/WebContent/StartForm.html