package org.model.subiecte.contabilitate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiciuContabilitate {
    private Map<String, Cont> planContabil = new HashMap<String, Cont>(); 
    private List<OperatiuneContabila> jurnal = new ArrayList<OperatiuneContabila>();
    
    public ServiciuContabilitate(){}
    
    public ServiciuContabilitate(Map<String, Cont> planContabil){
        this.setPlanContabil(planContabil); 
    }
    public Map<String, Cont> getPlanContabil() {
		return planContabil;
	}
	public void setPlanContabil(Map<String, Cont> planContabil) {
		this.planContabil = planContabil;
	}
	public List<OperatiuneContabila> getJurnal() {
		return jurnal;
	}
	public void setJurnal(List<OperatiuneContabila> jurnal) {
		this.jurnal = jurnal;
	}
	public void adaugaOperatiuneContabila(OperatiuneContabila op){
		if (jurnal.contains(op)){
			int indexOp = jurnal.indexOf(op);
			jurnal.set(indexOp, op);
		}else{
			jurnal.add(op);
		}
	}
	public void adaugaCont(Cont cont){
		planContabil.put(cont.getCod(), cont);
	}
	public Double getRulajCreditor(Cont cont){
		Double rulaj = .0;
		for (OperatiuneContabila op: jurnal){
			System.out.println("1 - " + op.getIdOperatiune());
			for(InregistrareContabila i: op.getInregistrari()){
				System.out.println("2 - " + i.getId());
				if (i instanceof InregistrareCredit
						&& cont.equals(i.getCont())){
					rulaj += i.getSuma();
					System.out.println("3 - " + i.getId() + "/" + rulaj);
				}
			}
		}
		System.out.println("4 - " + rulaj);
		return rulaj;
	}
    public Double getRulajDebitor(Cont cont){
		Double rulaj = .0;
		for (OperatiuneContabila op: jurnal){
			for(InregistrareContabila i: op.getInregistrari()){
				if (i instanceof InregistrareDebit
						&& cont.equals(i.getCont()))
					rulaj += i.getSuma();
			}
		}
		return rulaj;
    }
    public Double getSoldFinal(Cont cont){
        Double rulajDebitor = getRulajDebitor(cont);
        Double rulajCreditor = getRulajCreditor(cont);
        System.out.println("5D - " + rulajDebitor);
        System.out.println("5C - " + rulajCreditor);
        System.out.println("6 - " + (rulajDebitor - rulajCreditor));
        return rulajDebitor - rulajCreditor;
    }
}
