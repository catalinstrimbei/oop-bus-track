/**
 * http://www.alexatnet.com/articles/model-view-controller-mvc-javascript
 * 
 * JavaScript Event-based Observer Implementation
 * 
 */
function Event(sender) {
    this._sender = sender;
    this._listeners = [];
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
    }
};
