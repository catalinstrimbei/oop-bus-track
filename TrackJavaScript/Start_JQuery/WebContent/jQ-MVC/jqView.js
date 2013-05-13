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
    
    console.log('start listview events');
    this.listModified = new EventListModified();
    this.listModified = $.extend(this.listModified, new Event(_this));
    
    this.addButtonClicked = new EventAddButtonClicked();
    this.addButtonClicked = $.extend(this.addButtonClicked, new Event(_this));
    
    this.delButtonClicked = new EventDelButtonClicked();
    this.delButtonClicked = $.extend(this.delButtonClicked, new Event(_this));    
    console.log('end listview events');

    // attach listeners to HTML controls
    $("#list").change(
		function (e) {
	    	console.log('list.onchange');
	        _this.listModified.notify({ index : e.target.selectedIndex });
	    }    		
    );
    
    $("#plusBtn").click(
		function () {
	    	console.log('addButton.onClick');
	        _this.addButtonClicked.notify();
	    }    		
    );    
    
    $("#minusBtn").click(
		function () {
	    	console.log('delButton.onClick');
	        _this.delButtonClicked.notify();
	    }    		
    );     
}

ListView.prototype = {
    show : function (model) {
        this.rebuildList(model.getItems());
    },

    rebuildList : function (items) {
        var list, key;

        list = this._elements.list;
        list.html('');

        for (key in items) {
            if (items.hasOwnProperty(key)) {
                list.append($('<option>' + items[key] + '</option>'));
            }
        }
    },
    
    handle : function(event, args){
    	console.log('view.handle EventAddButtonClicked');
    	this.rebuildList(event.getSender().getItems());
    }    
};