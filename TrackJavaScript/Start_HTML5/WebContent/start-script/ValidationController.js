/* Resposibilities
 * - host user validation handlers/listeners for fields and form
 */

// Custom field validation
function enableFieldValidation(){
	document.FormCustomer.customerName.addEventListener(
		"invalid", 
		function(evt) {
			var validity = evt.srcElement.validity;
			if (validity.valueMissing) {
				alert(evt.srcElement.name + " is required !!!");
			}
			evt.preventDefault();
		}, 
		false);
}

//Custom form validation
function checkFormCustomerValidation(){
	var emailValidation = document.FormCustomer.email.checkValidity();
	if (emailValidation == false){
		alert("email is invalid!");
		// how to prevent defaults validation ?
	}
}