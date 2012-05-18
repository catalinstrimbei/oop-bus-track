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

//
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

