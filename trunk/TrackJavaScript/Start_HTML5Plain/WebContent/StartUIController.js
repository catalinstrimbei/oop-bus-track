// event handler for "invalid" events
function invalidHandler(evt) {
	var validity = evt.srcElement.validity;
	// check the validity to see if a particular constraint failed
	if (validity.valueMissing) {
		// present a UI to the user indicating that the field is missing a value
	}
	// perhaps check additional constraints here…
	// If you do not want the browser to provide default validation feedback,
	// cancel the event as shown here
	evt.preventDefault();
}
// register an event listener for "invalid" events
myField.addEventListener("invalid", invalidHandler, false);