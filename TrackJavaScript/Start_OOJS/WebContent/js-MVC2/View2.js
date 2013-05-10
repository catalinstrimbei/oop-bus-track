/**
 * http://www.alexatnet.com/articles/model-view-controller-mvc-javascript
 * 
 * The View. View presents the model and provides
 * the UI events. The controller is attached to these
 * events to handle the user interraction.
 */
function ListView(model, elements) {
    this._model = model;
    this._elements = elements;

    this.listModified = new Event(this);
    this.addButtonClicked = new Event(this);
    this.delButtonClicked = new Event(this);

    var _this = this;

    // attach model listeners
    this._model.itemAdded.attach(function () {
        _this.rebuildList();
    });
    this._model.itemRemoved.attach(function () {
        _this.rebuildList();
    });

    // attach listeners to HTML controls
    this._elements.list.onchange = function (e) {
        _this.listModified.notify({ index : e.target.selectedIndex });
    };
    /*
    this._elements.addButton.click(function () {
        _this.addButtonClicked.notify();
    });
    this._elements.delButton.click(function () {
        _this.delButtonClicked.notify();
    });
    */
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

    rebuildList : function () {
        var list, items, key;

        list = this._elements.list;
        //list.html('');
        list.length = 0;

        items = this._model.getItems();
        for (key in items) {
            if (items.hasOwnProperty(key)) {
                //list.append($('<option>' + items[key] + '</option>'));
            	var opt = document.createElement('option');
            	opt.text = items[key];
            	list.add(opt);
            }
        }
        this._model.setSelectedIndex(-1);
    }
};