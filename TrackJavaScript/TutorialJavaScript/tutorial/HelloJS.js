/**
 * JavaScript Startup App
 */

console.log("Hello JavaScript");

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


/*--------------------------------------------------------------------*/
// import js file
function include(filename)
{
	var doc = document.implementation.createHTMLDocument('');
	var head = document.getElementsByTagName('head')[0];

    var script = doc.createElement('script');
    script.src = filename;
    script.type = 'text/javascript';

    head.appendChild(script)
}
