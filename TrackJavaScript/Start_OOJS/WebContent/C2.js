includeJS("C2.ContabDOM.js");

function testCreareClase(){
	console.log("C2: TESTE CREARE CLASE");
	
	/*
	 * Pentru C2.ContabDOM.js
	 */
	// Instanta Cont
	// var c_401 = new Cont("401", "Clienti");	
	//var c_401 = new Cont();
	var c_401 = getObjectOfType("Cont");	
	
	console.log("cont : (a) [" + c_401.getCod() + ", " + c_401.getDenumire() + ", " + c_401.numeOrganizatie + "] - " + typeof c_401);
	
	c_401.setCod("401");
	c_401.setDenumire("Clienti");
	console.log("cont : (b) [" + c_401.getCod() + ", " + c_401.getDenumire() + ", " + c_401.numeOrganizatie + "] - " + typeof c_401);
	
	c_401.setDenumire("Cont clienti 401 ");
	console.log("cont : (c) [" + c_401.getCod() + ", " + c_401.getDenumire() + ", " + c_401.numeOrganizatie + "] - " + typeof c_401);
	console.dir(c_401);
	
	// Instanta InregistrareDebit
	//var i1 = new InregistrareDebit();
	var i1 = getObjectOfType("InregistrareDebit");
	console.log("Inregistrare contabila : [" + i1.id + ", " + i1.nrOrdineDebit + ", " + i1.tip + ", " + i1.cont.getCod() + ", " + i1.suma + "]");
	
	i1.id =1;
	i1.cont = c_401;
	i1.suma = 1000;	
	console.log("Inregistrare contabila : [" + i1.id + ", " + i1.nrOrdineDebit + ", " + i1.tip + ", " + i1.cont.getCod() + ", " + i1.suma + "]");
	console.dir(i1);
	
	InregistrareDebit.prototype.suma = 1500;
	i1 = new InregistrareDebit();
	console.log("Inregistrare contabila : [" + i1.id + ", " + i1.nrOrdineDebit + ", " + i1.tip + ", " + i1.cont.getCod() + ", " + i1.suma + "]");
	
	InregistrareDebit.prototype.suma = 2000;
	console.log("Inregistrare contabila : [" + i1.id + ", " + i1.nrOrdineDebit + ", " + i1.tip + ", " + i1.cont.getCod() + ", " + i1.suma + "]");
	
	console.log("Inregistrare contabila : [" 
			+ "i1 instanceof InregistrareContabila : " + (i1 instanceof InregistrareContabila) + ", " 
			+ "i1 instanceof InregistrareDebit : " + (i1 instanceof InregistrareDebit) + ", " 
			+ typeof i1 + "]");
	
	// Invocare functie constructor incapsulata, obtinere obiect cu structura incapsulata
	var j = getObjectOfType("Jurnal");
	j.setId("1");
	j.setDescriere("Jurnal Contabil")
	console.log("Jurnal (a) : [" + j.getId() + ", " + j.getDescriere() + "] - " + typeof j);
	
	j.prototype = {};
	j.prototype.spec = "Contabil";
	j.spec = "Vanzari";
	console.log("Jurnal (a) : [" + j.getId() + ", " + j.getDescriere() + ", proto-spec: " + j.prototype.spec + ", obj.spec: "  + j.spec + "] - " + typeof j);
	
	// Expresii foarte dinamice
	var defDescriere = getObjectOfType("Jurnal").getDescriere();
	console.log(defDescriere);
	
	var defDenCont = new Cont("401", "Clienti-def").getDenumire();
	console.log(defDenCont);
}

function testSiruri(){
	console.log("C2: TESTE SIRURI");
	
	// instantierea
	var str_1 = "pro";
	var str_2 = "pro";
	var str_3 = new String("pro");
	var str_4 = str_3.valueOf();
	
	console.log("str_1 = " + str_1);
	console.log("str_2 = " + str_2);
	console.log("str_3 = " + str_3);
	console.log("str_4 = " + str_4);
	
	// imutabilitate si comparare exacta
	// - identity operator
	console.log("str_1 === str_2 :" + (str_1===str_2));
	console.log("str_1 === str_3 :" + (str_1===str_3));
	console.log("str_1 === str_4 :" + (str_1===str_4));
	console.log("str_3 === str_4 :" + (str_3===str_4));
	str_1 = str_3;
	console.log("str_1 === str_3 :" + (str_1===str_3));
	// - equality operator
	console.log("str_1 == str_2 :" + (str_1==str_2));
	console.log("str_1 == str_3 :" + (str_1==str_3));
	console.log("str_1 == str_4 :" + (str_1==str_4));
	console.log("str_3 == str_4 :" + (str_3==str_4));
	
	// subsiruri
	var str_6 = "SELECT * FROM Table WHERE 1=1";
	var str_SELECT = str_6.substr(0,8);
	console.log("str_SELECT : [" + str_SELECT + "]");
	var str_FROM = str_6.substr(str_6.substr(0,8).length + 1, str_6.indexOf("WHERE") - (str_6.substr(0,8).length + 1));
	console.log("str_FROM : [" + str_FROM + "]");
	var str_WHERE = str_6.substr(str_6.indexOf("WHERE"));
	console.log("str_WHERE : [" + str_WHERE + "]");
	
	// comparare regex
	var rgx_format = /SELECT([A-z]|\s|[*])+FROM([A-z]|\s|[*])+WHERE?/i;
	var found = str_6.match(rgx_format)
	console.log("SELECT match [/SELECT([A-z]|\s|[*])+FROM([A-z]|\s|[*])+WHERE?]: [" + found + "]");
	var search = str_6.search(rgx_format);
	console.log("SELECT search [/SELECT([A-z]|\s|[*])+FROM([A-z]|\s|[*])+WHERE?]: [" + search + "]");
	
	// concatenare
	var multiply_operator_plus = function(){
		var str = "AAA_";
		var startTime = new Date();
		for (var i=1; i < 5000; i++){
			str+="AAA_";
		}
		var stopTime = new Date();
		return stopTime - startTime;
	};
	
	var multiply_operator_concat = function(){
		var str = "AAA_";
		var startTime = new Date();
		for (var i=1; i < 5000; i++){
			str = str.concat("AAA_");
		}
		var stopTime = new Date();
		return stopTime - startTime;
	};
	
	var concat_t1 = multiply_operator_plus();
	console.log("multiply_operator_plus : " + concat_t1);
	var concat_t2 = multiply_operator_concat();
	console.log("multiply_operator_concat : " + concat_t2);
}

function testDate(){
	// Data curenta
	var dataCurenta = new Date();
	
	// Initializare date Moth 00..11
	var date1 = new Date(2012, 04, 01);
	var date2 = new Date("May 1, 2012");
	console.log("date1 : " + date1.toDateString());
	console.log("date2 : " + date2.toDateString());
	
	console.log("date1 == date2 : " + (date1 == date2));
	console.log("date1 === date2 : " + (date1 === date2));
	console.log("date1 - date2 : " + (date1 - date2));
	console.log("date1 == date2 valueOf: " + (date1.valueOf() == date2.valueOf()));
	
	// Manipulare
	var date3 = new Date(date1.setDate(date1.getDate() + 14));
	console.log("date3 with 2 weeks after date2 : " + date3.toDateString());
}


function testExceptions(){
	// bloc standard
	var a = 100;
	try {
	   console.log("Value of variable a is : " + a );
	}catch ( e ) {
	   console.log("Error: " + e.description );
	}finally {
	   console.log("Finally block will always execute!" );
	}

	// exceptii standard	
	var tablou = new Array();
	tablou[0] = "A";
	try {
		// console.log("tablou[1] : " + tablou[1]); // undefined
	    // tablou.delete(2); // TypeError
		// colours[2] = "red";  // ReferenceError
		var someArr = new Array(89723742304323248456);  // RangeError
		// var count  99; // SyntaxError
	}catch ( e ) {
		if (e instanceof TypeError)
			console.log("TypeError: " + e.message );
		if (e instanceof ReferenceError)
			console.log("ReferenceError: " + e.message );		
		if (e instanceof RangeError)
			console.log("RangeError: " + e.message );
		if (e instanceof SyntaxError)
			console.log("SyntaxError: " + e.message );			
		console.log("Gen-Error: " + e.message );
	    console.dir(e);
	}finally {
	   console.log("Common standard errors examples!" );
	}		
	
	// exceptii utilizator
	var b = 999;
	try{
		if (b < 1000)
			throw "Less than 1000 error";
	}catch(e){
		console.log("String-Error-Message: " + e);
	}

	var b = 999;
	// 1. Create customized error type
	function CustomizedError(message){
		this.message = message;
	}
	CustomizedError.prototype = new Error();
	
	try{
		if (b < 1000)
			throw new CustomizedError("Less than 1000 error");
	}catch(e){
		if (e instanceof CustomizedError)
			console.log("CustomizedError: " + e.message );
	}	
	// 2. Create error with standard types and customized message
	try{
		if (b < 1000)
			throw new TypeError("Less than 1000 error");
	}catch(e){
		if (e instanceof TypeError)
			console.log("TypeError customized: " + e.message );		
	}
	
	// niveluri de tratare exceptii
	function throwExceptionCtx(b){
		if (b < 500)
			throw new TypeError("Less than 500 error");		
		return 'OK';
	}
	try{
		try{
			var c = throwExceptionCtx(399);
		}catch(e){
			if (e instanceof TypeError){
				console.log("TypeError from level-2: " + e.message );
				throw new CustomizedError(e.message);
			}
		}
	}catch(e){
		if (e instanceof CustomizedError)
			console.log("CustomizedError from level-1: " + e.message );
	}finally {
	   console.log("Customized errors examples!" );
	}			
}

// support pentru import obiecte-functii din alte fisiere
function includeJS(jsPath){
	  var script = document.createElement("script");
	  script.setAttribute("type", "text/javascript");
	  script.setAttribute("src", jsPath);
	  document.getElementsByTagName("head")[0].appendChild(script);
}

/* C2: Proiectarea [claselor] - tipurilor de obiecte
 * 2.2 [Clase si tipuri] Tipuri-de-obiecte si implementare
 * - Implementare tip obiect prin functie constructor - C2.ContabDOM.js_5
 * (declaratie de tip explicita pentru membri interni nu exista,
 * un workaround este sugerarea unei valori default cu sintaxa <?> ... )
 * 
 * 2.3 Principii OO
 * - Incapsulare proprietati: definire membri get/set - C2.ContabDOM.js_10+14
 * (de fapt membrii structurali ai unui obiect nu pot fi ascunsi, in sensul vizibilitatii, 
 * dar ar putea fi definiti prin var si nu prin this:
 * - var echivaland cu private -  C2.ContabDOM.js_6
 * - this echivaland cu public -  C2.ContabDOM.js_47)
 * - Incapsulare si ascundere [clase] definitie implementare tipuri obiecte: C2.ContabDOM.js_66
 * (de fapt ascunderea unei functii-constructor intr-o functie conventionala numita)
 * 
 * 2.4 Reutilizare
 * - prin compunere: membrii unui obiect pot fi alte obiecte - C2.ContabDOM.js_48;
 * - prin mostenire: definirea si folosirea unui prototip comun C2.ContabDOM.js_57, 
 *	 sau al unui lant comun de prototipizare
 * (Obiectul obtinut prin prototipizare va avea copii-proprii ai membrilor prototipului,
 * dar va avea si referinta catre obiectul prototip - ai carui membri se vor comporta 
 * static, adica vor avea valori comune pentru toate obiectele definite din acelasi prototip).
 * 
 * 2.5 Obiecte fundamentale: siruri de caractere si alte primitive
 * 
 * 2.6 Obiecte exceptii
 * 
 * 2.7 Obiecte pentru reprezentarea timpului
 */

/* QA
 * - spatii de nume (namespaceuri) - (ca pachete in java);
 * - import declaratii din alt fisier js;
 * 
 */

