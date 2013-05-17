function ListModel(items) {
    this._items = items;
    this._selectedIndex = -1;
}

ListModel.prototype = {
    getItems : function () {
        return [].concat(this._items);
    },

    addItem : function (item) {
    	console.log('model addItem');
        this._items.push(item);
        //$(this).trigger("itemAdded", this);
        $(this).trigger($.Event("itemAdded", this));
    },

    removeItemAt : function (index) {
        var item;
        item = this._items[index];
        this._items.splice(index, 1);
        //$(this).trigger("itemRemoved", this);        
        $(this).trigger($.Event("itemRemoved", this));
        if (index === this._selectedIndex) {
            this.setSelectedIndex(-1);
        }
    },

    getSelectedIndex : function () {
        return this._selectedIndex;
    },

    setSelectedIndex : function (index) {
        var previousIndex;
        previousIndex = this._selectedIndex;
        this._selectedIndex = index;
        //$(this).trigger("selectedIndexChanged", this);
        $(this).trigger($.Event("selectedIndexChanged", this));        
    },
    
    setEvents : function(view){
    	$(this).on("itemAdded", 
    			$.proxy(view.handle, view)
        );    	
    	$(this).on("itemRemoved", 
    			$.proxy(view.handle, view)
        );
/*    	
        $(this).bind("itemAdded", 
        		function handleAddButtonClicked(event, args){
        			view.handle(event, args);
        		}
        );	
        $(this).bind("itemRemoved", 
    		function handleAddButtonClicked(event, args){
    			view.handle(event, args);
    		}
        );    	
*/
    }
};

