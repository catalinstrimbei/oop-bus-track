package cap3.exemplu8_9_10;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//----------------------------------------------------------------
//Subclase care vor mosteni
//----------------------------------------------------------------
public abstract class OperatiuneComerciala extends OperatiuneContabila {
	private String partener;

	public String getPartener() {
		return partener;
	}

	public void setPartener(String partener) {
		this.partener = partener;
	}

	public OperatiuneComerciala() {
	}

	public OperatiuneComerciala(Integer idOperatiune, Date dataContabilizare) {
		super(idOperatiune, dataContabilizare);
	}

	public OperatiuneComerciala(Integer idOperatiune, Date dataContabilizare,
			String partener) {
		super(idOperatiune, dataContabilizare);
		this.partener = partener;
	}

	// metoda abstracta
	public abstract List<InregistrareContabila> getInregistrari(String tip);
}
