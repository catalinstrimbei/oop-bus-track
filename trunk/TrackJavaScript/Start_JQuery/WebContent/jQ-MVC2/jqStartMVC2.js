function init(){

	// testCustomEvent();
	
	var model = new ListModel(['PHP', 'JavaScript']);
	
//	view = new ListView({
//        'list' : $("#list").get(0), 
//        'addButton' : $("#plusBtn").get(0), 
//        'delButton' : $("#minusBtn").get(0)
//    }),
	
	var view = new ListView({
        'list' : $("#list"), 
        'addButton' : $("#plusBtn"), 
        'delButton' : $("#minusBtn")
    });	
	
    var controller = new ListController(model);
	
	/*
	view.listModified.attach(controller);
	view.addButtonClicked.attach(controller);
	view.delButtonClicked.attach(controller);
	*/
	$(view).bind("listModified", controller.handler);
	$(view).bind("addButtonClicked", controller.handler);
	$(view).bind("delButtonClicked", controller.handler);
	
	/*
	model.itemAdded.attach(view);
	model.itemRemoved.attach(view);
	*/
	$(model).bind("itemAdded", view.handler);
	$(model).bind("itemRemoved", view.handler);
	
	
	view.show(model);	
}

function testCustomEvent(){
	/*
	if (typeof(MyObject) === "undefined") 
		MyObject = {};
	$(MyObject).bind("main", function(event, theData) {
		alert(theData);
	});
	$(MyObject).trigger("main", "Welcome to the main event");	
	*/
	
	
	// Test Custom events
	
	var obj = {};
	$(obj).bind("addButtonClicked", 
		function(event, theData) {
			console.log("Handle " + event.type + ": " + theData);
	});
	$(obj).trigger("addButtonClicked", " arguments ");		
	
	/*
	var obj = {};
	var evt = $.Event();
	evt.type = "addButtonClicked";
	$(obj).bind(evt.type, 
		function(event, theData) {
			console.log("Handle " + event.type + ": " + theData);
	});
	$(obj).trigger(evt.type, " ... arguments ... ");		
	*/ 
	 
}