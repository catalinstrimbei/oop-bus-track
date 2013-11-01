package cap3.exemplu12;

//Definitie clasă de implementare
public class ServiciuOperatiuni implements IServiciuOperatiuni {
    public Double getSold(OperatiuneContabila o){
        return getDebit(o) - getCredit(o);
    }
    public Double getDebit(OperatiuneContabila o){
        Double debit = 0.0;
        for (InregistrareContabila i: o.getInregistrari()){
            if (i instanceof InregistrareDebit)
                debit += i.getSuma();
        }
        return debit;
    }

    public Double getCredit(OperatiuneContabila o){
        Double credit = 0.0;
        for (InregistrareContabila i: o.getInregistrari()){
            if (i instanceof InregistrareCredit)
                credit += i.getSuma();
        }
        return credit;
    }
}