includeJS("C1.js");
includeJS("C2.js");
includeJS("C3.js");

function main(){
	// test();
	// testCreareObiecte();
	// testCreareClase();
	// testSiruri();
	// testDate();
	// testExceptions();
	testPolimorfism();
	
}

function test(){
	var test = "Test JavaScript!";
	alert(test);
	console.log(test)
};

function includeJS(jsPath){
	  var script = document.createElement("script");
	  script.setAttribute("type", "text/javascript");
	  script.setAttribute("src", jsPath);
	  document.getElementsByTagName("head")[0].appendChild(script);
}

function IncludeJavaScript(jsFile)
{
  document.write('<script type="text/javascript" src="'
    + jsFile + '"></scr' + 'ipt>'); 
}