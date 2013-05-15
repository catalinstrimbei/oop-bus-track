function ListView(elements) {
    this._elements = elements;
    var _this = this;
    // attach listeners to HTML controls
    $("#list").change(
		function (e) {
	    	console.log('list.onchange');
	    	$(_this).trigger("listModified", { index : this.selectedIndex });
	    }    		
    );
    
    $("#plusBtn").click(
		function () {
	    	console.log('addButton.onClick');
	    	$(_this).trigger("addButtonClicked");
	    }    		
    );    
    
    $("#minusBtn").click(
		function () {
	    	console.log('delButton.onClick');
	    	$(_this).trigger("delButtonClicked");
	    	
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
    
    handle : function(event, model){
    	console.log('view.handle ' + event.type);
    	this.rebuildList(model.getItems());
    },
    
    setEvents : function(controller){
    	$(this).bind("listModified", 
    			function handleAddButtonClicked(event, args){
    				controller.handle(event, args);
    			}
    		);
    		
    	$(this).bind("addButtonClicked", 
    		function handleAddButtonClicked(event, args){
    			controller.handle(event, args);
    		}
    	);

    	$(this).bind("delButtonClicked", 
    		function handleAddButtonClicked(event, args){
    			controller.handle(event, args);
    		}
    	);     	
    }
};