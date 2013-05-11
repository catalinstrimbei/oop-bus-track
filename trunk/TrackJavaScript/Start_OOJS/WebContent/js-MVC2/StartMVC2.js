function init(){
	var model = new ListModel(['PHP', 'JavaScript']),
    
	view = new ListView({
        'list' : document.getElementById("list"), 
        'addButton' : document.getElementById("plusBtn"), 
        'delButton' : document.getElementById("minusBtn")
    }),
    controller = new ListController(model);
	
	view.listModified.attach(controller);
	view.addButtonClicked.attach(controller);
	view.delButtonClicked.attach(controller);
	
	model.itemAdded.attach(view);
	model.itemRemoved.attach(view);
	
	view.show(model);	
}