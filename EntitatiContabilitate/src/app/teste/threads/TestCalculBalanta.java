package app.teste.threads;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	public static volatile boolean endCalculDebit;
	public static volatile boolean endCalculCredit;
	public static final Object lockObject = new Object();
	
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

		Date startTime = new Date();
		Date endTime;
		Thread threadCalculDebit = new Thread(new CalculDebitCredit(conturi, operatiuni, "Debit"));
		Thread threadCalculCredit = new Thread(new CalculDebitCredit(conturi, operatiuni, "Credit"));
		threadCalculDebit.setName("threadCalculDebit");
		threadCalculCredit.setName("threadCalculCredit");
		
		threadCalculDebit.start();
		threadCalculCredit.start();
		
		/*
		// var 1
		try {
			threadCalculDebit.join();
			threadCalculCredit.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		// var 2
		synchronized (lockObject) {
			while (!(endCalculDebit && endCalculCredit)){
				try {
					lockObject.wait();
					System.out.println("In wait! " + endCalculDebit + "/" + endCalculCredit);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Out of wait! " + endCalculDebit + "/" + endCalculCredit);
		}
		
		
		endTime = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SS");
		
		System.out.println("End calcul Debit and Credit: " + format.format(startTime) + "  |   " + format.format(endTime)
				+ " -- thread: " + Thread.currentThread().getName() + "//" +  Thread.currentThread().getId());
		
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
		System.out.println("Start Thread " + tipCalcul + " -- thread: " + Thread.currentThread().getName() + "//" +  Thread.currentThread().getId());
		doCalcul(tipCalcul);
		
		if (DEBIT.equals(tipCalcul))
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (CREDIT.equals(tipCalcul))
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
		System.out.println("End Thread " + tipCalcul + " -- thread: " + Thread.currentThread().getName() + "//" +  Thread.currentThread().getId());
		
		synchronized (TestCalculBalanta.lockObject) {
			if (DEBIT.equals(tipCalcul))
				TestCalculBalanta.endCalculDebit = true;
			if (CREDIT.equals(tipCalcul))
				TestCalculBalanta.endCalculCredit = true;
			TestCalculBalanta.lockObject.notifyAll();
		}
		
		
	}
	
	private static final String DEBIT = "Debit";
	private static final String CREDIT = "Credit";
	
	private synchronized void doCalcul(String tipCalcul){
		
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