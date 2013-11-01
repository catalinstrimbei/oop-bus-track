package cap1.exemplu3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperatiuneContabila {
    String debit = "Debit";
    String credit = "Credit";

    Integer idOperatiune;
    Date dataContabilizare;

    List<InregistrareContabila> inregistrari = 
			new ArrayList<InregistrareContabila>();
    // fata de: InregistrareContabila[] inregistrari

    public OperatiuneContabila() {
    }

    public OperatiuneContabila(Integer idOperatiune, 
				Date dataContabilizare,
				List<InregistrareContabila> inregistrari) {
        this.idOperatiune = idOperatiune;
        this.dataContabilizare = dataContabilizare;
        this.inregistrari = inregistrari;
    }

    
}
