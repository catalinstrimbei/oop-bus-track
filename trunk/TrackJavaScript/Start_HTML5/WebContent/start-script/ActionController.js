/* Resposibilities
 * - host user action handlers/listeners
 * - manual bind for action components to handlers
 */



function disableFormContent(enable){
	document.getElementById("fldsNav").disabled= enable;
	document.getElementById("fldsId").disabled= enable;
	document.getElementById("fldsDetails").disabled= enable;
	document.getElementById("fldsAdress").disabled= enable;
	document.getElementById("fldsActions").disabled= enable;
}