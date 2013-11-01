package cap2.exemplu7;

import java.util.List;

import app.model.validare.Validatable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OperatiuneContabila implements Comparable, Serializable,
		Validatable {

	private Integer idOperatiune;
	private Date dataContabilizare;

	public OperatiuneContabila() {
	}

	public OperatiuneContabila(Integer idOperatiune, Date dataContabilizare) {
		this.idOperatiune = idOperatiune;
		this.dataContabilizare = dataContabilizare;
	}

	private Map<Integer, InregistrareContabila> inregistrari = new TreeMap<Integer, InregistrareContabila>();

	public Date getDataContabilizare() {
		return dataContabilizare;
	}

	public void setDataContabilizare(Date dataContabilizare) {
		this.dataContabilizare = dataContabilizare;
	}

	public List<InregistrareContabila> getInregistrari() {
		List<InregistrareContabila> result = new ArrayList<InregistrareContabila>();
		result.addAll(inregistrari.values());
		return result;
	}

	public Integer getIdOperatiune() {
		return idOperatiune;
	}

	public void setIdOperatiune(Integer idOperatiune) {
		this.idOperatiune = idOperatiune;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	// Utilizarea operatorului instanceof
	public Double getSold() {
		return getDebit() - getCredit();
	}

	private Double getDebit() {
		Double debit = 0.0;
		for (InregistrareContabila i : this.getInregistrari()) {
			if (i instanceof InregistrareDebit)
				debit += i.getSuma();
		}
		return debit;
	}

	private Double getCredit() {
		Double credit = 0.0;
		for (InregistrareContabila i : this.getInregistrari()) {
			if (i instanceof InregistrareCredit)
				credit += i.getSuma();
		}
		return credit;
	}
}
