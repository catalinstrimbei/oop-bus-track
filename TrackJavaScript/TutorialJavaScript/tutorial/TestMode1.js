/**
 * Testing JS modularization
 */
/*
var doc = document.implementation.createHTMLDocument('');
doc.open();
doc.write(html);
doc.close();
*/

function htmlToDoc(markup) {
  var parser = new DOMParser();
  return parser.parseFromString(markup, "text/html");
}

var htmlString = "<title>foo bar</title><div>a div</div>";

htmlToDoc(htmlString);