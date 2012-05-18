function testCreareObiecte(){
	console.log("TESTE CREARE OBIECTE");
	
	// definire conturi
	var c_411 = {};
	c_411.numeOrganizatie = "Gama SA";
	c_411.cod = 411;
	c_411.denumire = "Clienti";

	var c_401 = {
		numeOrganizatie : "Gama SA",
		cod : 401,
		denumire : "Furnizori"
	};

	var c_401 = {
		numeOrganizatie : "Gama SA",
		cod : 401,
		denumire : "Furnizori"
	};
	
	var c_5121 = {
		numeOrganizatie : "Gama SA",
		cod : 5121,
		denumire : "Banca"
	};
	
	var cont = function(_cont, _denumire){
		var cont = {cod : _cont, denumire : _denumire };
		return cont;
	}
	
	var c_5131 = cont(5131, "Casa");
	c_5131.numeOrganizatie = "Gama SA";
	
	// definire Inregistrari Contabile
	var i1 = {
		id : 1,
		nrOrdine : 1,
		tip : "Debit",
		suma : 120.0,
		cont : c_411
	};
	var i2 = {
		id : 2,
		nrOrdine : 1,
		tip : "Credit",
		suma : 120.0,
		cont : c_5121
	};
	
	// definire Operatiuni Contabile
	var op = new Object();
	op.idOperatiune = 1;
	op.dataContabilizare = new Date();
	op.inregistrari = [i1, i2];
	
	alert("cont 411 : [" + c_411.cod + ", " + c_411.denumire + ", " + c_411.numeOrganizatie + "] -- type of " + typeof c_411);
	console.log("cont : [" + c_401.cod + ", " + c_401.denumire + ", " + c_401.numeOrganizatie + "]");
	console.log("cont : [" + c_5131.cod + ", " + c_5131.denumire + ", " + c_5131.numeOrganizatie + "]");
	
	console.log("Inregistrare contabila : [" + i1.id + ", " + i1.nrOrdine + ", " + i1.tip + ", " + ", " + i1.cont.cod + ", " + i1.suma + "]");
	console.log("Inregistrare contabila : [" + i2.id + ", " + i2.nrOrdine + ", " + i2.tip + ", " + ", " + i2.cont.cod + ", " + i2.suma + "]");
	
	console.log("Operatiune contabila : [" + op.idOperatiune + ", " + op.dataContabilizare + ", " + op.inregistrari.length + "]");
	
	// parcurgerea tablourilor - varianta clasica
	for (var i = op.inregistrari.length; i--; ){
		console.log(" - inregistrarea i--: [" + 
				op.inregistrari[i].id + ", " + 
				op.inregistrari[i].nrOrdine + ", " + 
				op.inregistrari[i].tip + ", " + ", " + 
				op.inregistrari[i].cont.cod + ", " + 
				op.inregistrari[i].suma + "]");
	}	
	//for (var i = o.inregistrari.length; i--; ){
	for (var i = 0; i < op.inregistrari.length; i++){
		console.log(" - inregistrarea i++: [" + 
				op.inregistrari[i].id + ", " + 
				op.inregistrari[i].nrOrdine + ", " + 
				op.inregistrari[i].tip + ", " + ", " + 
				op.inregistrari[i].cont.cod + ", " + 
				op.inregistrari[i].suma + "]");
	}
	
	// parcurgerea tablourilor - varianta orientata obiect
	for (var e in op.inregistrari){
		console.log(" - inregistrarea - e in : [" + 
				op.inregistrari[e].id + ", " + 
				op.inregistrari[e].nrOrdine + ", " + 
				op.inregistrari[e].tip + ", " + ", " + 
				op.inregistrari[e].cont.cod + ", " + 
				op.inregistrari[e].suma + "]");
	}
	
	
	// obiect serviciu
	var serviciuOperatiuni = {};
	serviciuOperatiuni.getDebit = function(o){
		var debit = 0.0;
		for(var i in o.inregistrari){
			if (o.inregistrari[i].tip === "Debit")
				debit += o.inregistrari[i].suma;
		}
		return debit;
	};
	serviciuOperatiuni.getCredit = function(o){
		var credit = 0.0;
		for(var i in o.inregistrari){
			if (o.inregistrari[i].tip === "Credit")
				credit += o.inregistrari[i].suma;
		}
		return credit;
	};
	serviciuOperatiuni.getSold = function(o){
		return this.getDebit(o) - this.getCredit(o);
	};
	
	console.log("Operatiune contabila : " + op.idOperatiune + " debit : " + serviciuOperatiuni.getDebit(op));
	console.log("Operatiune contabila : " + op.idOperatiune + " credit : " + serviciuOperatiuni.getCredit(op));
	console.log("Operatiune contabila : " + op.idOperatiune + " sold : " + serviciuOperatiuni.getSold(op));
	
	op.inregistrari["I"] = i1;
	op.inregistrari["II"] = i2;
	for(var i in op.inregistrari){
		console.log(" - inregistrarea - i(" + i + ")  in : [" + 
				op.inregistrari[i].id + ", " + 
				op.inregistrari[i].nrOrdine + ", " + 
				op.inregistrari[i].tip + ", " + ", " + 
				op.inregistrari[i].cont.cod + ", " + 
				op.inregistrari[i].suma + "]");		
	}
}
// ========================================================================== //

/* C1: Intro - universul obiectelor
 * 1.1 Modelul de obiecte JavaScript
 * 
 * 1.2 Definire si creare
 * - creare/initializare declarativa instanta Object: {} sau new Object();
 * - definire dinamica structura object
 * - creare instanta si definire structurala dinamica prin invocare functie_valoare-obiect-anonima; 
 * - conventional: definire tip si instantiere prin declaratie functie constructor
 * [locul de definire a structurii obiectelor nu este o definitie de clasa, ci codul procedural al unei functii speciale constructor]
 * 
 * 
 * 1.3 Interactiune - apeluri intre obiecte
 * ???
 * 
 */

/* QA: 
 * - statics;
 * - multi-script-path with common-named functions;
 * - typed objects (rather than literal objects);
 * - initializare prin prototipizare
 */