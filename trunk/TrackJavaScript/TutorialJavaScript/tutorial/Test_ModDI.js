var addressModule = (function(printer) {
	var address = [ 'street', 'city', 'state', 'zip', ];
	return {
		street : function(street) {
			address[0] = street;
			return this;
		},
		city : function(city) {
			address[1] = city;
			return this;
		},
		state : function(state) {
			address[2] = state;
			return this;
		},
		zip : function(zip) {
			address[3] = zip;
			return this;
		},
		format : function() {
			return printer.format(address);
		}
	};
})(printerModule);
addressModule.street('123 Easy Street').city('Lawrence').state('KS').zip(
		'123456');

console.log(addressModule.format());