function ListController(model, view) {
    this._model = model;
    this._this = this;
    model.setEvents(view);
    view.setEvents(this);
    view.show(model);
}

ListController.prototype = {
    addItem : function () {
        var item = window.prompt('Add item:', '');
        if (item) {
            this._model.addItem(item);
        }
    },

    delItem : function () {
        var index;

        index = this._model.getSelectedIndex();
        if (index !== -1) {
            this._model.removeItemAt(this._model.getSelectedIndex());
        }
    },

    updateSelected : function (index) {
        this._model.setSelectedIndex(index);
    },    
    
    handle : function(event, args){
    	console.log('controller.handle : ');
    	if (event.type == "addButtonClicked"){
    		console.log('controller.handle addButtonClicked');
    		this.addItem();
    	}
    	if (event.type == "delButtonClicked"){
    		console.log('controller.handle delButtonClicked');
    		this.delItem();
    	}   
    	if (event.type == "listModified"){
    		console.log('controller.handle listModified');
    		this.updateSelected(args.index);
    	}
    }
    
};