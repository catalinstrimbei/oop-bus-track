// Constructor care defineste o pseudo-clasa
// nu contine instructiunea return, returneaza implicit this ...

// like instante members of objects
function Cont(cod, denumire, contParinte){
	var _cod = cod ? cod : "000"; // like default value
	var _denumire = denumire ? denumire : "Cont - nedefinit";
	var _contParinte = contParinte;
	
	this.getCod = function (){
		return _cod;
	};
	
	this.setCod = function(cod){
		_cod = cod;
	};
	
	this.getDenumire = function (){
		return _denumire;
	};
	
	this.setDenumire = function(denumire){
		_denumire = denumire;
	};	
	
	this.getContParinte = function (){
		return _contParinte;
	};
	
	this.setContParinte = function(contParinte){
		_contParinte = contParinte;
	};	
}
// like static members of object (?!, not quite)
Cont.prototype = {
	numeOrganizatie : "Alfa SA"
};

// Reutilizare prin mostenire
/*
 * InregistrareContabila
 * 	<- InregistrareDebit
 * 	<- InregistrareCredit
 */
// Super: InregistrareContabila
function InregistrareContabila(id, tip, cont, suma){
	this.id = id ? id : 0;
	this.cont = cont ? cont : new Cont();
	this.suma = suma ? suma : 0.0;
	this.tip = tip ? tip : "Tip-Undef";
};
// Sub: InregistrareDebit
function InregistrareDebit(nrOrdineDebit){
	this.nrOrdineDebit = nrOrdineDebit ? nrOrdineDebit : 0;
	this.tip = "Debit";
};
InregistrareDebit.prototype = new InregistrareContabila();
// Sub: InregistrareCredit
function InregistrareCredit(nrOrdineCredit){
	this.nrOrdineCredit = nrOrdineCredit ? nrOrdineCredit : 0;
	this.tip = "Credit";
};
InregistrareCredit.prototype = new InregistrareContabila();

// Incapsulare Jurnal
function getObjectOfType(typeName){
	// Implementare tip jurnal - incapsulata - neaccesibila direct
	function Jurnal(){
		var id = "0";
		var descriere = "NULL - desc";
		return {
			getId : function(){return id;},
			setId: function(newId){id = newId;},
			getDescriere : function(){return descriere;},
			setDescriere: function(newDescriere){descriere = newDescriere;},			
		}
	};		
	
	if (typeName === "Cont")
		return new Cont();
	if (typeName === "InregistrareDebit")
		return new InregistrareDebit();
	if (typeName === "Jurnal")
		return new Jurnal();
		
}
