package cap3.exemplu5;

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

	// supraincarcate getInregistrari()
	// si invocare operatiune supraincarcata
	public List<InregistrareContabila> getInregistrari(String tip) {

		List<InregistrareContabila> result = new ArrayList<InregistrareContabila>();
		if (tip.equals("Debit")) {
			for (InregistrareContabila i : getInregistrari())
				if (i instanceof InregistrareDebit)
					result.add(i);
		}
		if (tip.equals("Credit")) {
			for (InregistrareContabila i : getInregistrari())
				if (i instanceof InregistrareCredit)
					result.add(i);
		}

		return result;
	}

}
