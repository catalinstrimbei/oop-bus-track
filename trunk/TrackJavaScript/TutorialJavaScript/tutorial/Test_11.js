/**
 * Test 11: JavaScript object instantiation
 */

/*Script imports*/
//include('tutorial/scrum_model.js');
var doc = window.document.createElement('script');

/*--------------------------------------------------------------------*/
var p = new Project(1, "ProjectJS", new Date());
console.log("Nume proiect: " + p.numeProiect);
console.log("Data proiect: " + p.dataStart);


/*--------------------------------------------------------------------*/
// scrum_model.js
function Project(nrProiect, numeProiect, dataStart){
	this.nrProiect = nrProiect;
	this.numeProiect = numeProiect;
	this.dataStart = dataStart;
}
