package cap1.exemplu1;

public class OperatiuneContabila {
    String debit = "Debit";
    String credit = "Credit";

    Integer idOperatiune;
    java.util.Date dataContabilizare;
    // membru referinta multiplicitate > 1
    InregistrareContabila[] inregistrari;

}
