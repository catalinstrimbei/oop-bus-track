package app.teste.threads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import app.exceptii.AppException;
import app.model.contabilitate.InregistrareContabila;
import app.model.contabilitate.InregistrareCredit;
import app.model.contabilitate.InregistrareD;
import app.model.contabilitate.InregistrareDebit;
import app.model.contabilitate.OperatiuneContabila;
import app.model.contabilitate.RegistruClaseConturi;
import app.model.contabilitate.RegistruConturi;
import app.model.contabilitate.RegistruOperatiuni;
import app.model.contabilitate.conturi.Cont;

public class TestCalculBalanta {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initRegistri();
		
		// TODO Exemplu fire de executie
		// 1. Calcul credit si debit cu fire de executie separate
		// (pentru creare fir, start si stop)
		// 2. Afisare date calcul cu fir de executie separat care asteapta incheierea
		// firelor de executie care efecueaza calculele (pentru wait si resume)
		// 3. Cum poate fi exemplificata corect concurenta pe aceleassi resurse
		// (pentru sincronyze)
		
		Set<Cont> conturi = registruConturi.getConturi();
		Set<OperatiuneContabila> operatiuni = registruOperatiuni.getOperatiuni();
		
		Map<Cont, Double> debiteConturi ;
		Map<Cont, Double> crediteConturi;

		new Thread(new CalculDebitCredit(conturi, operatiuni, "Debit")).start();
		new Thread(new CalculDebitCredit(conturi, operatiuni, "Credit")).start();
		
		
	}

    private static RegistruConturi registruConturi;
    private static RegistruOperatiuni registruOperatiuni;
    private static RegistruClaseConturi registruClaseConturi;
    private static void initRegistri() {
        // creare entity manager
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("EntitatiContabilitate");
        EntityManager em = emf.createEntityManager();

        // initializare registri
        registruConturi = new RegistruConturi(em);
        registruOperatiuni = new RegistruOperatiuni(em);
        registruClaseConturi = new RegistruClaseConturi(em);
    }
}

class CalculDebitCredit implements Runnable{
	private Set<Cont> conturi;
	private Set<OperatiuneContabila> operatiuni;
	private Map<Cont, Double> sumeConturi = new HashMap<Cont, Double>();
	private String tipCalcul;
	
	public Map<Cont, Double> getSumeConturi() {
		return sumeConturi;
	}

	public void setSumeConturi(Map<Cont, Double> sumeConturi) {
		this.sumeConturi = sumeConturi;
	}

	public CalculDebitCredit(Set<Cont> conturi,
			Set<OperatiuneContabila> operatiuni, String tipCalcul) {
		super();
		this.conturi = conturi;
		this.operatiuni = operatiuni;
		this.tipCalcul = tipCalcul;
	}

	@Override
	public void run() {
		System.out.println("Start Thread " + tipCalcul);
		doCalcul(tipCalcul);
		System.out.println("End Thread " + tipCalcul);
	}
	
	private static final String DEBIT = "Debit";
	private static final String CREDIT = "Credit";
	private void doCalcul(String tipCalcul){
		Class tipInregistrare = null;
		if (DEBIT.equals(tipCalcul))
			tipInregistrare = InregistrareDebit.class;
		if (CREDIT.equals(tipCalcul))
			tipInregistrare = InregistrareCredit.class;
		
		if (tipInregistrare == null)
			throw new AppException("Tip inregistrare gresit: " + tipCalcul);
			
		Double suma;
		sumeConturi = new HashMap<Cont, Double>();
		for (OperatiuneContabila operatiune : operatiuni){
			for(InregistrareContabila inregContabila : operatiune.getInregistrari()){
				if (tipInregistrare.isInstance(inregContabila)){
					suma = (sumeConturi.containsKey(inregContabila.getCont())) ? 
							sumeConturi.get(inregContabila.getCont()) : .0;
					sumeConturi.put(inregContabila.getCont(), suma + inregContabila.getSuma());
				}
			} 
		}
		
	}
}