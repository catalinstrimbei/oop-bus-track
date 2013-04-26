var urlRestSDO = "http://localhost:8080/ProRest_WebBackend/services/customer/getxmlcustomers";
var customerServiceSDO = new CustomerServiceSDO(urlRestSDO);

//window.onload = loadSDO;


// Util functions
function loadSDO(){
	console.log("Loading SDOForm. " + Date());
	customerServiceSDO.getCustomers(showData);
	
}

function showData(data){
	console.log(JSON.stringify(data));
}

function CustomerServiceSDO(url){
	// service configuration attributes
	this.urlRestBase = url;
	
	// service operations/functions - map to REST operations
	this.getCustomers =  function(dataHandler){
		var reqRest = new XMLHttpRequest();
		reqRest.onload = function(){
			if (reqRest.status == 200){
				console.log("REST Response: " + reqRest.responseText);
				// get objects from REST response
				customers = xml2json.parser(reqRest.responseText);
				// callback
				dataHandler(customers);
			}else{
				console.log("REST Request problem or ERROR ");
			}
		};
		reqRest.open("GET", this.urlRestBase);
		reqRest.send(null);		
	}
}


// Changes XML to JSON
function xmlToJson(xml) {
	
	// Create the return object
	var obj = {};

	if (xml.nodeType == 1) { // element
		// do attributes
		if (xml.attributes.length > 0) {
		obj["@attributes"] = {};
			for (var j = 0; j < xml.attributes.length; j++) {
				var attribute = xml.attributes.item(j);
				obj["@attributes"][attribute.nodeName] = attribute.nodeValue;
			}
		}
	} else if (xml.nodeType == 3) { // text
		obj = xml.nodeValue;
	}

	// do children
	if (xml.hasChildNodes()) {
		for(var i = 0; i < xml.childNodes.length; i++) {
			var item = xml.childNodes.item(i);
			var nodeName = item.nodeName;
			if (typeof(obj[nodeName]) == "undefined") {
				obj[nodeName] = xmlToJson(item);
			} else {
				if (typeof(obj[nodeName].length) == "undefined") {
					var old = obj[nodeName];
					obj[nodeName] = new Array();
					obj[nodeName].push(old);
				}
				obj[nodeName].push(xmlToJson(item));
			}
		}
	}
	return obj;
}


function xml2bf(node) {
    var json = {};
    var cloneNS = function(ns) {
        var nns = {};
        for (var n in ns) {
            if (ns.hasOwnProperty(n)) {
                nns[n] = ns[n];
            }
        }
        return nns;
    };
    var process = function (node, obj, ns) {
        if (node.nodeType === 3) {
            if (!node.nodeValue.match(/[\S]+/)) return;
            if (obj["$"] instanceof Array) {
                obj["$"].push(node.nodeValue);
            } else if (obj["$"] instanceof Object) {
                obj["$"] = [obj["$"], node.nodeValue];
            } else {
                obj["$"] = node.nodeValue;
            }
        } else if (node.nodeType === 1) {
            var p = {};
            var nodeName = node.nodeName;
            for (var i = 0; node.attributes && i < node.attributes.length; i++) {
                var attr = node.attributes[i];
                var name = attr.nodeName;
                var value = attr.nodeValue;
                if (name === "xmlns") {
                    ns["$"] = value;
                } else if (name.indexOf("xmlns:") === 0) {
                    ns[name.substr(name.indexOf(":") + 1)] = value;
                } else {
                    p["@" + name] = value;
                }
            }
            for (var prefix in ns) {
                if (ns.hasOwnProperty(prefix)) {
                    p["@xmlns"] = p["@xmlns"] || {};
                    p["@xmlns"][prefix] = ns[prefix];
                }
            }
            if (obj[nodeName] instanceof Array) {
                obj[nodeName].push(p);
            } else if (obj[nodeName] instanceof Object) {
                obj[nodeName] = [obj[nodeName], p];
            } else {
                obj[nodeName] = p;
            }
            for (var j = 0; j < node.childNodes.length; j++) {
                process(node.childNodes[j], p, cloneNS(ns));
            }
        } else if (node.nodeType === 9) {
            for (var k = 0; k < node.childNodes.length; k++) {
                process(node.childNodes[k], obj, cloneNS(ns));
            }
        }
    };
    process(node, json, {});
    return json;
}
//

function bf2xml(json) {
    if (typeof json !== "object") return null;
    var cloneNS = function(ns) {
        var nns = {};
        for (var n in ns) {
            if (ns.hasOwnProperty(n)) {
                nns[n] = ns[n];
            }
        }
        return nns;
    };
    var processLeaf = function(lname, child, ns) {
        var body = "";
        if (child instanceof Array) {
            for (var i = 0; i < child.length; i++) {
                body += processLeaf(lname, child[i], cloneNS(ns));
            }
            return body;
        } else if (typeof child === "object") {
            var el = "<" + lname;
            var attributes = "";
            var text = "";
            if (child["@xmlns"]) {
                var xmlns = child["@xmlns"];
                for (var prefix in xmlns) {
                    if (xmlns.hasOwnProperty(prefix)) {
                        if (prefix === "$") {
                            if (ns[prefix] !== xmlns[prefix]) {
                                attributes += " " + "xmlns=\"" + xmlns[prefix] + "\"";
                                ns[prefix] = xmlns[prefix];
                            }
                        } else if (!ns[prefix] || (ns[prefix] !== xmlns[prefix])) {
                            attributes += " xmlns:" + prefix + "=\"" + xmlns[prefix] + "\"";
                            ns[prefix] = xmlns[prefix];
                        }
                    }
                }
            }
            for (var key in child) {
                if (child.hasOwnProperty(key) && key !== "@xmlns") {
                    var obj = child[key];
                    if (key === "$") {
                        text += obj;
                    } else if (key.indexOf("@") === 0) {
                        attributes += " " + key.substring(1) + "=\"" + obj + "\"";
                    } else {
                        body += processLeaf(key, obj, cloneNS(ns));
                    }
                }
            }
            body = text + body;
            return (body !== "") ? el + attributes + ">" + body + "</" + lname + ">" : el + attributes + "/>"
        }
    };
    for (var lname in json) {
        if (json.hasOwnProperty(lname) && lname.indexOf("@") == -1) {
            return processLeaf(lname, json[lname], {});
        }
    }
    return null;
}


//A simple call - myXML is a string containing your XML:
//myJsonObject=xml2json.parser(myXML);
 
// A 2:nd, optional, parameter is "tags not to convert" - for example <b> and <i>:
//myJsonObject=xml2json.parser(myXML,'b,i');
 
// A 3:rd, optional, parameter gives us a string showing us the JSON structure 
// instead of the actual JSON object:
//myString=xml2json.parser(myXML,'','html');
 
// - use "compact" for output without linebreaks or tabbing
// - use "normal" for output with linebreaks and tabbing
// - use "html" for a html representation