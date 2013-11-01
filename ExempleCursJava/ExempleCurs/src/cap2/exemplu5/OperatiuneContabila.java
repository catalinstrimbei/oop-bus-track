package cap2.exemplu5;

import java.util.List;

public class OperatiuneContabila {
	List<InregistrareContabila> inregistrari;
	
    public List<InregistrareContabila> getInregistrari() {
		return inregistrari;
	}
    
  //---------------------------------------------//
	public Double getSold(){
        return getDebit() - getCredit();
    }
	
	//---------------------------------------------//
    private Double getDebit(){
        Double debit = 0.0;
        for (InregistrareContabila i: this.getInregistrari()){
            if (i instanceof InregistrareDebit)
                debit += i.getSuma();
        }
        return debit;
    }
    private Double getCredit(){
        Double credit = 0.0;
        for (InregistrareContabila i: this.getInregistrari()){
            if (i instanceof InregistrareCredit)
                credit += i.getSuma();
        }
        return credit;
    }

}
