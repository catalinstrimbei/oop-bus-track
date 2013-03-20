/* Resposibilities
 * - binding [data model] - to - [form fields] [synchronization]
 */
function bindingForm(){
		console.log(" - bindingForm ... " + Date());
		//document.getElementById("FormCustomer").disabled=false;
		// bind data navigation component
		bindDataBrowseComponent();
		// bind form fields
		bindFormFields();
		
		// enable form
		disableFormContent(false);			
}

function bindDataBrowseComponent(){
	if (customers){
		console.log(" - bindDataBrowseComponent .... " + Date());
		var selectCustomers = document.getElementById("customers");
		// reset
		while(selectCustomers.options.length > 0){
			selectCustomers.removeChild(selectCustomers.options[0]);
		}
		// repopulate
		for(var i = 0; i < customers.length; i++) {
		    var customerElement = document.createElement("option");
		    customerElement.textContent = customers[i].name;
		    customerElement.value = customers[i].id;
		    selectCustomers.appendChild(customerElement);
		}		
		customer = customers[0];		
	}	
}

function bindFormFields(){
	if (customer){
		console.log(" - bindFormFields .... " + Date());
		document.getElementById("customerID").value = customer.id;
		document.getElementById("customerName").value = customer.name;				
		document.getElementById("registrationDate").value = customer.registrationDate;
		// log
		document.getElementById("response").innerHTML = customers[0].id + " - " + customers[0].name;		
	}	
}

function selectCurrentCustomer(){
	
	var selectCustomers = document.getElementById("customers");
	var currentId = selectCustomers.value;
	console.log("selectCurrentCustomer - currentId = " + currentId + " in " + customers);
	
	if(currentId){
		/*
		for(var i = 0; i < customers.length; i++) {
			if (customers[i].id == currentId)
				customer = customers[i];
		}
		
		// refresh form
		console.log("customer.id = " + customer.id);
		document.getElementById("customerID").value = customer.id;
		document.getElementById("customerName").value = customer.name;	
		*/
		
		/* using worker */
		disableFormContent(true);
		// disable form
		var worker = new Worker("start-script/QueryDataCollectionWorker.js");
		// prepare worker
		worker.onmessage = function(event){
			console.log("selectCurrentCustomer - worker done: " + event.data);
			customer = event.data;
			// refresh form
			console.log("selectCurrentCustomer - customer.id = " + customer.id);
			document.getElementById("customerID").value = customer.id;
			document.getElementById("customerName").value = customer.name;
			// enable form
			disableFormContent(false);			
		}
		worker.postMessage([currentId, customers]);
	}
}