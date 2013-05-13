/**
 * http://www.alexatnet.com/articles/model-view-controller-mvc-javascript
 * 
 * The View. View presents the model and provides
 * the UI events. The controller is attached to these
 * events to handle the user interaction.
 */

function EventListModified(){this.setClass();};	
function EventAddButtonClicked(){this.setClass();};
function EventDelButtonClicked(){this.setClass();};

function ListView(elements) {

	
	
    this._elements = elements;
    var _this = this;
    
    console.log('start listview events');
    EventListModified.prototype = new Event(_this);
    this.listModified = new EventListModified();
    
    EventAddButtonClicked.prototype = new Event(_this);
    this.addButtonClicked = new EventAddButtonClicked();
    
    EventDelButtonClicked.prototype = new Event(_this);
    this.delButtonClicked = new EventDelButtonClicked();
    console.log('end listview events');

    // attach listeners to HTML controls
    this._elements.list.onchange = function (e) {
    	console.log('list.onchange');
        _this.listModified.notify({ index : e.target.selectedIndex });
    };
    this._elements.addButton.onclick = function () {
    	console.log('addButton.onClick');
        _this.addButtonClicked.notify();
    };
    this._elements.delButton.onclick = function () {
    	console.log('delButton.onClick');
        _this.delButtonClicked.notify();
    };    
}

ListView.prototype = {
    show : function (model) {
        this.rebuildList(model.getItems());
    },

    rebuildList : function (items) {
        var list, key;

        list = this._elements.list;
        list.length = 0;

        for (key in items) {
            if (items.hasOwnProperty(key)) {
            	var opt = document.createElement('option');
            	opt.text = items[key];
            	list.add(opt);
            }
        }
    },
    
    handle : function(event, args){
    	console.log('view.handle EventAddButtonClicked');
    	this.rebuildList(event.getSender().getItems());
    }    
};