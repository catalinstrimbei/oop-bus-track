/* Resposibilities
 * - binding [data model] - to - [form fields] [synchronization]
 */
function bindingForm(){
	console.log(" - bindingForm ... " + Date());
	// bind data navigation component
	bindDataBrowseComponent();
	// bind form fields
	bindFormFields();
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