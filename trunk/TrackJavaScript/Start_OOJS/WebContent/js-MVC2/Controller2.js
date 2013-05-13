/**
 * http://www.alexatnet.com/articles/model-view-controller-mvc-javascript
 * 
 * The Controller. Controller responds to user actions and
 * invokes changes on the model.
 */
function ListController(model) {
    this._model = model;
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
    	if (event instanceof EventAddButtonClicked){
    		console.log('controller.handle EventAddButtonClicked');
    		this.addItem();
    	}
    	if (event instanceof EventDelButtonClicked){
    		this.delItem();
    	}
    	if (event instanceof EventListModified){
    		this.updateSelected(args.index);
    	}
    }   
};