/**
 * http://www.alexatnet.com/articles/model-view-controller-mvc-javascript
 * 
 * JavaScript Event-based Observer Implementation
 * 
 */
function Event(sender) {
    this._sender = sender;
    this._listeners = [];
    this.setClass();
}

Event.prototype = {
    getEventType : function() {
		return Object.prototype.toString.call(this);
	},
	getEventClass : function() {
        if (this && this.constructor && this.constructor.toString) {
            var arr = this.constructor.toString().match(
                /function\s*(\w+)/);

            if (arr && arr.length == 2) {
                return arr[1];
            }
        }

        return undefined;
    },	
	attach : function (listener) {
        this._listeners.push(listener);
    },
    notify : function (args) {
        var index;

        for (index = 0; index < this._listeners.length; index += 1) {
            this._listeners[index].handle(this, args);
        }
    },
    getSender : function(){
    	return this._sender;
    },
    setClass : function() {
      console.log("Old Event class: " + this._class);
      this._class =  this.get_class(this);
      console.log("New Event class: " + this._class);
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
