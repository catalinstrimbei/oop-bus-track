function dataTableSelectOneRadio(radio) {
	
	var id = radio.name.substring(radio.name.lastIndexOf(':'));
    var el = radio.form.elements;
    var next_el_id = radio.name.substring(0, radio.name.lastIndexOf(':')) + ":txtNr";
    var next_el = document.getElementById(next_el_id);
    
    /*
    alert(radio.name);    
    alert(next_el_id);
    */
    for (var i = 0; i < el.length; i++) {
        if (el[i].name.substring(el[i].name.lastIndexOf(':')) == id) {
        	if (el[i].name != radio.name){
            	el[i].checked = false;
            	getRow(el[i]).className = "";
        	}
        }
    }
    
    getRow(radio).className = "rowHighlighted";
    next_el.focus();
    
}
function getRow(element){
	var currentRow = element.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
	return currentRow;
}
function dataTableSelectUIComponent(component) {
	alert("test");
	
	var id = component.name.substring(component.name.lastIndexOf(':'));
    var el = component.form.elements;

    
    alert(component);
    /*
    alert(radio.name);    
    alert(next_el_id);
    */
    for (var i = 0; i < el.length; i++) {
        if (el[i].name.substring(el[i].name.lastIndexOf(':')) == id) {
        	if (el[i].name != component.name){
            	getRow(el[i]).className = "";
        	}
        }
    }
    getRow(component).className = "rowHighlighted";    
}