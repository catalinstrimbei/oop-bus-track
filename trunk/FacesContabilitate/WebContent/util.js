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
    
    //Trimite cerere Ajax pentru a stabili inregistrarea curenta
    
    
    next_el.focus();
    
}
function getRow(element){
	var currentRow = element.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
	return currentRow;
}

//dataTableSelectRow
function dataTableSelectRow(radio) {
	
	var id = radio.name.substring(radio.name.lastIndexOf(':'));
    var el = radio.form.elements;
    var next_el_id = radio.name.substring(0, radio.name.lastIndexOf(':')) + ":txtNr";
    var next_el = document.getElementById(next_el_id);
    var btnActionSelect_id = radio.name.substring(0, radio.name.lastIndexOf(':')) + ":btnSelect";
    var btnActionSelect = document.getElementById(btnActionSelect_id);
    
    //alert(btnActionSelect);
    
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
    btnActionSelect.click();
    
}

function selectTableRow(radio, event) {
	
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
    
    //Trimite cerere Ajax pentru a stabili inregistrarea curenta
    jsf.ajax.request(
    	radio, 
    	event, 
    	{
    		render:'formOperatiuniSecond:txtNrInregCurenta', 
    		onevent:'formOperatiuniSecond.selectInregistrareCurenta'
    	}
    );
    //jsf.ajax.request('formConturi:cboConturi',event,{render:'formConturi:txtCod formConturi:txtDenumire formConturi:cboSubClasaCont','javax.faces.behavior.event':'valueChange'})    
    //next_el.focus();
    
}