package org.model.subiecte.contabilitate;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestServiciuContabilitate {

	public static void main(String[] args) {
		new TestServiciuContabilitate().test2();
	}

	void test1(){
		// Creare plan conturi
		Map<String, Cont> planContabil = new HashMap<String, Cont>();
		planContabil.put("401", new Cont("401", "Furnizori"));
		planContabil.put("301", new Cont("301", "Materii prime"));
		planContabil.put("5121", new Cont("5121", "Conturi la bãnci în lei"));
		// Creare serviciu contabilitate
		ServiciuContabilitate serviciuContabilitate = new ServiciuContabilitate(planContabil);
		
		// Inregistrare achizitionare
		OperatiuneContabila achizitionare = new OperatiuneContabila(1, new Date());
		List<InregistrareContabila> inregistrari = new ArrayList<InregistrareContabila>();
		inregistrari.add(new InregistrareDebit(1, serviciuContabilitate.getPlanContabil().get("301"), 1250.0));
		inregistrari.add(new InregistrareCredit(2, serviciuContabilitate.getPlanContabil().get("401"), 1250.0));
		achizitionare.setInregistrari(inregistrari);
		serviciuContabilitate.adaugaOperatiuneContabila(achizitionare);
		// Inregistrare plata
		OperatiuneContabila plata = new OperatiuneContabila(1, new Date());
		inregistrari = new ArrayList<InregistrareContabila>();
		inregistrari.add(new InregistrareDebit(1, serviciuContabilitate.getPlanContabil().get("401"), 1250.0));
		inregistrari.add(new InregistrareCredit(2, serviciuContabilitate.getPlanContabil().get("5121"), 1250.0));
		plata.setInregistrari(inregistrari);
		serviciuContabilitate.adaugaOperatiuneContabila(plata);

		// Inregistrare vinzare
		serviciuContabilitate.adaugaCont(new Cont("411", "Clienti"));
		serviciuContabilitate.adaugaCont(new Cont("707", "Venituri din vinzarea marfurilor"));
		OperatiuneContabila vinzare = new OperatiuneContabila(1, new Date());
		inregistrari = new ArrayList<InregistrareContabila>();
		inregistrari.add(new InregistrareDebit(1, serviciuContabilitate.getPlanContabil().get("411"), 1250.0));
		inregistrari.add(new InregistrareCredit(2, serviciuContabilitate.getPlanContabil().get("707"), 1250.0));
		vinzare.setInregistrari(inregistrari);
		serviciuContabilitate.adaugaOperatiuneContabila(vinzare);
		// Inregistrare incasare
		OperatiuneContabila incasare = new OperatiuneContabila(1, new Date());
		inregistrari = new ArrayList<InregistrareContabila>();
		inregistrari.add(new InregistrareDebit(1, serviciuContabilitate.getPlanContabil().get("5121"), 1250.0));
		inregistrari.add(new InregistrareCredit(2, serviciuContabilitate.getPlanContabil().get("411"), 1250.0));
		incasare.setInregistrari(inregistrari);
		serviciuContabilitate.adaugaOperatiuneContabila(incasare);
		
		
		System.out.println("Sold cont 401 = " + serviciuContabilitate.getSoldFinal(serviciuContabilitate.getPlanContabil().get("401")));
		
		System.out.println("----------------------------------------------------------------------");
        OperatiuneContabila opj = null;
        String descriereOpj = null;
        List<OperatiuneContabila> jurnal = serviciuContabilitate.getJurnal();
        // initializare iterator pentru colectia jurnal
        Iterator<OperatiuneContabila> j = jurnal.iterator() ;
        //Factura f = null;
        //DocumentPlata p = null;
        // pentru fiecare operaţiune contabilă din jurnal accesată prin iteratorul j
        while(j.hasNext()){
        	// iniţializez variabila ce va conţine referinţa următoare operaţiuni accesate
            opj =  j.next()	;
            descriereOpj = "Operatiune din data " + opj.getDataContabilizare() + "\n";
            for (InregistrareContabila inregistrare: opj.getInregistrari()){
            	if (inregistrare instanceof InregistrareDebit)
            		descriereOpj += " debitare " + inregistrare.getCont().getCod() + " cu suma " + inregistrare.getSuma() + "\n";
            	if (inregistrare instanceof InregistrareCredit)
            		descriereOpj += " creditare " + inregistrare.getCont().getCod()  + " cu suma " + inregistrare.getSuma() + "\n"; 
            	
            }
            descriereOpj += "Sold final: " + opj.getSold(); 
            System.out.println(descriereOpj);
            System.out.println("----------------------------------------------------------------------");
        }
	}
	
	void test2(){
		// Creare plan conturi
		Map<String, Cont> planContabil = new HashMap<String, Cont>();
		planContabil.put("401", new Cont("401", "Furnizori"));
		planContabil.put("301", new Cont("301", "Materii prime"));
		planContabil.put("5121", new Cont("5121", "Conturi la bãnci în lei"));
		// Creare serviciu contabilitate
		ServiciuContabilitate serviciuContabilitate = new ServiciuContabilitate(planContabil);
		
		// Inregistrare achizitionare
		Cumparare achizitionare = new Cumparare(1, new Date());
		List<InregistrareContabila> inregistrari = new ArrayList<InregistrareContabila>();
		inregistrari.add(new InregistrareDebit(1, serviciuContabilitate.getPlanContabil().get("301"), 1250.0));
		inregistrari.add(new InregistrareCredit(2, serviciuContabilitate.getPlanContabil().get("401"), 1250.0));
		achizitionare.setInregistrari(inregistrari);
		serviciuContabilitate.adaugaOperatiuneContabila(achizitionare);
		// Inregistrare plata
		OperatiuneContabila plata = new OperatiuneContabila(1, new Date());
		inregistrari = new ArrayList<InregistrareContabila>();
		inregistrari.add(new InregistrareDebit(1, serviciuContabilitate.getPlanContabil().get("401"), 1250.0));
		inregistrari.add(new InregistrareCredit(2, serviciuContabilitate.getPlanContabil().get("5121"), 1250.0));
		plata.setInregistrari(inregistrari);
		serviciuContabilitate.adaugaOperatiuneContabila(plata);

		// Inregistrare vinzare
		serviciuContabilitate.adaugaCont(new Cont("411", "Clienti"));
		serviciuContabilitate.adaugaCont(new Cont("707", "Venituri din vinzarea marfurilor"));
		Vinzare vinzare = new Vinzare(1, new Date());
		inregistrari = new ArrayList<InregistrareContabila>();
		inregistrari.add(new InregistrareDebit(1, serviciuContabilitate.getPlanContabil().get("411"), 1250.0));
		inregistrari.add(new InregistrareCredit(2, serviciuContabilitate.getPlanContabil().get("707"), 1250.0));
		vinzare.setInregistrari(inregistrari);
		serviciuContabilitate.adaugaOperatiuneContabila(vinzare);
		// Inregistrare incasare
		OperatiuneContabila incasare = new OperatiuneContabila(1, new Date());
		inregistrari = new ArrayList<InregistrareContabila>();
		inregistrari.add(new InregistrareDebit(1, serviciuContabilitate.getPlanContabil().get("5121"), 1250.0));
		inregistrari.add(new InregistrareCredit(2, serviciuContabilitate.getPlanContabil().get("411"), 1250.0));
		incasare.setInregistrari(inregistrari);
		serviciuContabilitate.adaugaOperatiuneContabila(incasare);
		
		
		System.out.println("Sold cont 401 = " + serviciuContabilitate.getSoldFinal(serviciuContabilitate.getPlanContabil().get("401")));
		System.out.println("----------------------------------------------------------------------");
        OperatiuneContabila opj = null;
        String descriereOpj = null;
        List<OperatiuneContabila> jurnal = serviciuContabilitate.getJurnal();
        // initializare iterator pentru colectia jurnal
        Iterator<OperatiuneContabila> j = jurnal.iterator() ;
        //Factura f = null;
        //DocumentPlata p = null;
        // pentru fiecare operaţiune contabilă din jurnal accesată prin iteratorul j
        while(j.hasNext()){
        	// iniţializez variabila ce va conţine referinţa următoare operaţiuni accesate
            opj =  j.next()	;
            descriereOpj = "Operatiune din data " + opj.getDataContabilizare() + "\n";
            for (InregistrareContabila inregistrare: opj.getInregistrari()){
            	if (inregistrare instanceof InregistrareDebit)
            		descriereOpj += " debitare " + inregistrare.getCont().getCod() + " cu suma " + inregistrare.getSuma() + "\n";
            	if (inregistrare instanceof InregistrareCredit)
            		descriereOpj += " creditare " + inregistrare.getCont().getCod()  + " cu suma " + inregistrare.getSuma() + "\n"; 
            	
            }
            descriereOpj += "Sold final: " + opj.getSold(); 
            System.out.println(descriereOpj);
            System.out.println("----------------------------------------------------------------------");
        }

	}
}
