function dataTableSelectOneRadio(radio) {
	 window.alert("You clicked radio");
	var id = radio.name.substring(radio.name.lastIndexOf(':'));
    var el = radio.form.elements;
    for (var i = 0; i < el.length; i++) {
        if (el[i].name.substring(el[i].name.lastIndexOf(':')) == id) {
            el[i].checked = false;
        }
    }
    radio.checked = true;
    //getRow(radio).className = "rowHighlighted";
}
function getRow(element){
	currentRow = elements.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
	return currentRow;
}