package org.model.subiecte.contabilitate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

//Superclasa OperatiuneContabila implementeaza Validatable, Comparable
public class OperatiuneContabila implements Validatable, IOperatieContabila, 
		Comparable<OperatiuneContabila>{
	
	private Integer idOperatiune;
	private Date dataContabilizare;
	protected List<InregistrareContabila> inregistrari =
            new ArrayList<InregistrareContabila>();
	
	public OperatiuneContabila(Integer idOperatiune, Date dataContabilizare) {
		this.idOperatiune = idOperatiune;
		this.dataContabilizare = dataContabilizare;
	}
	
	public OperatiuneContabila() {
	}


	// operatii ale proprietatilor ce vor fi mostenite
	public Integer getIdOperatiune() {
        return idOperatiune;
	}
	public void setIdOperatiune(Integer idOperatiune) {
        this.idOperatiune = idOperatiune;
	}	

	public void setDataContabilizare(Date dataContabilizare) {
        this.dataContabilizare = dataContabilizare;
	}
		

	public Double getDebit(){
        Double debit = 0.0;
        for (InregistrareContabila i: this.getInregistrari()){
            if (i instanceof InregistrareDebit)
                debit += i.getSuma();
        }
        return debit;
	}
	public Double getCredit(){
        Double credit = 0.0;
        for (InregistrareContabila i: this.getInregistrari()){
            if (i instanceof InregistrareCredit)
                credit += i.getSuma();
        }
        return credit;
	}

	//----------------------------------------------------------------
	// Implementare operatii ale interfetelor Validatable si Comparable
	@Override
	public boolean isValid(){
        if (getDebit().equals(getCredit()))
            return true;
        throw new ExceptieValidare(
				"Operatiune dezechilibrata: debit # credit!");
    }	


	@Override
	public int compareTo(OperatiuneContabila op) {
        if (this.getDataContabilizare()
				.after(op.getDataContabilizare()))
            		return 1;
        if (this.getDataContabilizare()
				.before(op.getDataContabilizare()))
            		return -1;
        return 0;
    }

	//----------------------------------------------------------------
	// implementare op din interfata IOperatiuneContabile
	@Override
	public List<InregistrareContabila> getInregistrari() {
		return inregistrari;
	}
	public void setInregistrari(List<InregistrareContabila> inregistrari){
		this.inregistrari = inregistrari;
	}
	@Override
	public void addInregistrareContabila (
				InregistrareContabila inregistrare){
		this.inregistrari.add(inregistrare);
	}
	@Override
	public Date getDataContabilizare() {
        return dataContabilizare;
	}
	@Override
	public Double getSold(){
        return getDebit() - getCredit();
	}	
	@Override
	public void removeInregistrareContabila(InregistrareContabila inregistrare) {
		if (this.inregistrari.contains(inregistrare)){
			this.inregistrari.remove(inregistrare);
		}
	}	
	//----------------------------------------------------------------

}