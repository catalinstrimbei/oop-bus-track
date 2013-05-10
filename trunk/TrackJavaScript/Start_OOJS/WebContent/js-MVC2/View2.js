/**
 * http://www.alexatnet.com/articles/model-view-controller-mvc-javascript
 * 
 * The View. View presents the model and provides
 * the UI events. The controller is attached to these
 * events to handle the user interraction.
 */
function ListView(elements) {
    this._elements = elements;

    this.listModified = new Event(this);
    this.addButtonClicked = new Event(this);
    this.delButtonClicked = new Event(this);

    var _this = this;

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
    show : function () {
        this.rebuildList();
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
    }
};