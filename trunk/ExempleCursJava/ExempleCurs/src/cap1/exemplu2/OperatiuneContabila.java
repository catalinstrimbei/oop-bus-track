package cap1.exemplu2;

import java.util.Date;

public class OperatiuneContabila {
    String debit = "Debit";
    String credit = "Credit";

    Integer idOperatiune;
    java.util.Date dataContabilizare;
    // membru referinta multiplicitate > 1
    InregistrareContabila[] inregistrari;

    public OperatiuneContabila() {
    }
    public OperatiuneContabila(Integer idOperatiune, 
				Date dataContabilizare,
				InregistrareContabila[] inregistrari) {
        this.idOperatiune = idOperatiune;
        this.dataContabilizare = dataContabilizare;
        this.inregistrari = inregistrari;
    }
    
}
