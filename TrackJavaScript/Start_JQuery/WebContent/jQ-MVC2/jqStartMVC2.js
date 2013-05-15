function init(){

	// testCustomEvent();	
	var model = new ListModel(['PHP', 'JavaScript']);
	var view = new ListView(
		{
	        'list' : $("#list"), 
	        'addButton' : $("#plusBtn"), 
	        'delButton' : $("#minusBtn")
	    }
	);
	var controller = new ListController(model, view);
	
}

function testCustomEvent(){
	if (typeof(MyObject) === "undefined") 
		MyObject = {};
	$(MyObject).bind("main", function(event, theData) {
		alert(theData);
	});
	$(MyObject).trigger("main", "Welcome to the main event");	 
}