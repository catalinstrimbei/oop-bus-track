function init(){
	var model = new ListModel(['PHP', 'JavaScript']),
    
//	view = new ListView({
//        'list' : $("#list").get(0), 
//        'addButton' : $("#plusBtn").get(0), 
//        'delButton' : $("#minusBtn").get(0)
//    }),
	
	view = new ListView({
        'list' : $("#list"), 
        'addButton' : $("#plusBtn"), 
        'delButton' : $("#minusBtn")
    }),	
	
    controller = new ListController(model);
	
	view.listModified.attach(controller);
	view.addButtonClicked.attach(controller);
	view.delButtonClicked.attach(controller);
	
	model.itemAdded.attach(view);
	model.itemRemoved.attach(view);
	
	view.show(model);	
}