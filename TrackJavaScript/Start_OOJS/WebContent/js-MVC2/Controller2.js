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

    getObjectClass : function(obj) {
        if (obj && obj.constructor && obj.constructor.toString) {
            var arr = obj.constructor.toString().match(
                /function\s*(\w+)/);

            if (arr && arr.length == 2) {
                return arr[1];
            }
        }

        return undefined;
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
    },
    
    get_class : function(obj) {
    	  // http://kevin.vanzonneveld.net
    	  // +   original by: Ates Goral (http://magnetiq.com)
    	  // +   improved by: David James
    	  // +   improved by: David Neilsen
    	  // *     example 1: get_class(new (function MyClass() {}));
    	  // *     returns 1: "MyClass"
    	  // *     example 2: get_class({});
    	  // *     returns 2: "Object"
    	  // *     example 3: get_class([]);
    	  // *     returns 3: false
    	  // *     example 4: get_class(42);
    	  // *     returns 4: false
    	  // *     example 5: get_class(window);
    	  // *     returns 5: false
    	  // *     example 6: get_class(function MyFunction() {});
    	  // *     returns 6: false
    	  if (obj && typeof obj === 'object' &&
    	      Object.prototype.toString.call(obj) !== '[object Array]' &&
    	      obj.constructor && obj !== this.window) {
    	    var arr = obj.constructor.toString().match(/function\s*(\w+)/);

    	    if (arr && arr.length === 2) {
    	      return arr[1];
    	    }
    	  }

    	  return false;
    	}    
};