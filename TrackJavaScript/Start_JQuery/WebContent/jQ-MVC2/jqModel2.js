/**
 * http://www.alexatnet.com/articles/model-view-controller-mvc-javascript
 * 
 * The Model. Model stores items and notifies
 * observers about changes.
 */

function EventItemAdded(){this.setClass();};
function EventItemRemoved(){this.setClass();};
function EventSelectedIndexChanged(){this.setClass();};

function ListModel(items) {
    this._items = items;
    this._selectedIndex = -1;

    console.log('start model events');
    /*
    EventItemAdded.prototype = new Event(this);
    this.itemAdded = new EventItemAdded();
    
    EventItemRemoved.prototype = new Event(this);
    this.itemRemoved = new EventItemRemoved();
    
    EventSelectedIndexChanged.prototype = new Event(this);
    this.selectedIndexChanged = new EventSelectedIndexChanged();
    */
    console.log('end model events');
}

ListModel.prototype = {
    getItems : function () {
        return [].concat(this._items);
    },

    addItem : function (item) {
    	console.log('model addItem');
        this._items.push(item);
        //this.itemAdded.notify({ item : item });
        $(this).trigger("itemAdded", this);
    },

    removeItemAt : function (index) {
        var item;

        item = this._items[index];
        this._items.splice(index, 1);
        
        //this.itemRemoved.notify({ item : item });
        $(this).trigger("itemRemoved", this);
        
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
        
        // this.selectedIndexChanged.notify({ previous : previousIndex });
        $(this).trigger("selectedIndexChanged", this);
        
    }
};

