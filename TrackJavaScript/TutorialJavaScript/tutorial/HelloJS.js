/**
 * JavaScript Startup App
 */

console.log("Hello JavaScript");

/*Script imports*/
//include('scrum.model.js');
phantom.page.injectJs('./scrum.model.js');

var p = new Project(1, "Phantom project", new Date());
console.log(p.numeProiect);

console.log("End tutorial!");
phantom.exit();

/*--------------------------------------------------------------------*/
// import js file
function include(filename)
{
	var doc = document.implementation.createHTMLDocument('');
	var head = document.getElementsByTagName('head')[0];

    var script = doc.createElement('script');
    script.src = filename;
    script.type = 'text/javascript';

    head.appendChild(script);
    console.log(filename + " imported!");
}

/*
 * npm install requirejs
*/