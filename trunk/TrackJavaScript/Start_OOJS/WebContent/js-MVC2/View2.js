/**
 * http://www.alexatnet.com/articles/model-view-controller-mvc-javascript
 * 
 * The View. View presents the model and provides
 * the UI events. The controller is attached to these
 * events to handle the user interaction.
 */
function EventListModified(){};
function EventAddButtonClicked(){};
function EventDelButtonClicked(){};

function ListView(elements) {
    this._elements = elements;
    var _this = this;
    
    
    EventListModified.prototype = new Event(_this);
    this.listModified = new EventListModified();
//	console.log("event type: " + (this.listModified instanceof EventListModified)); 
    
    
    EventAddButtonClicked.prototype = new Event(_this);
    this.addButtonClicked = new EventAddButtonClicked();
    
    
    EventDelButtonClicked.prototype = new Event(_this);
    this.delButtonClicked = new EventDelButtonClicked();


    // attach listeners to HTML controls
    console.log('set list.onchange');    
    this._elements.list.onchange = function (e) {
    	console.log('list.onchange');
        _this.listModified.notify({ index : e.target.selectedIndex });
    };
    console.log('set addButton.onClick');
    this._elements.addButton.onclick = function () {
    	console.log('addButton.onClick');
        _this.addButtonClicked.notify();
    };
    console.log('set delButton.onClick');
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