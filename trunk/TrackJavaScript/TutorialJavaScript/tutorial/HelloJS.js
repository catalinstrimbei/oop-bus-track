/**
 * JavaScript Startup App
 */

console.log("Hello JavaScript");

/*Script imports*/
//include('tutorial/scrum_model.js');
var doc = window.document.createElement('script');

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
}

/*
 * npm install requirejs
*/