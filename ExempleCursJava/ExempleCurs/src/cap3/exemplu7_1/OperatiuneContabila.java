package cap3.exemplu7_1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

//Superclasa OperatiuneContabila implementeaza Validatable, Comparable
public class OperatiuneContabila implements Comparable, Validatable{
	private Integer idOperatiune;
	private Date dataContabilizare;
	protected Map<Integer, InregistrareContabila> inregistrari =
            new TreeMap<Integer, InregistrareContabila>();
	
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
	public Date getDataContabilizare() {
        return dataContabilizare;
	}
	public void setDataContabilizare(Date dataContabilizare) {
        this.dataContabilizare = dataContabilizare;
	}
	
	//---------------------------------------------------------------- 
	public List<InregistrareContabila> getInregistrari() {
        List<InregistrareContabila> result = 
				new ArrayList<InregistrareContabila>();
        result.addAll(inregistrari.values());
        return result;
	}
 
	public void addInregistrareContabila (
				InregistrareContabila inregistrare){
        TreeSet<Integer> cheiInregistrari = 
				new TreeSet<Integer>();
        cheiInregistrari.addAll(inregistrari.keySet());
        if (cheiInregistrari.size() > 0)
            inregistrare.setNrOrdine(cheiInregistrari.last() + 1);
        else
            inregistrare.setNrOrdine(1);
        inregistrare.setOperatiune(this);

        this.inregistrari.put(inregistrare.getNrOrdine(), 
				inregistrare);
	}
	public Double getSold(){
        return getDebit() - getCredit();
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

	// Implementare operatii ale interfetelor
	@Override
	public boolean isValid(){
        if (getDebit().equals(getCredit()))
            return true;
        throw new ExceptieValidare(
				"Operatiune dezechilibrata: debit # credit!");
    }	


	@Override
	public int compareTo(Object o) {
		if (!(o instanceof OperatiuneComerciala))
			return -1;
		
		OperatiuneContabila op =  (OperatiuneComerciala)o;
        if (this.getDataContabilizare()
				.after(op.getDataContabilizare()))
            		return 1;
        if (this.getDataContabilizare()
				.before(op.getDataContabilizare()))
            		return -1;
        return 0;
    }

}
