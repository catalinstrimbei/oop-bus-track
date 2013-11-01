package cap2.exemplu6;

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



	public OperatiuneContabila(Integer idOperatiune, Date dataContabilizare,
			Map<Integer, InregistrareContabila> inregistrari) {
		this(idOperatiune, dataContabilizare);
		this.inregistrari = inregistrari;
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
}

class InregistrareContabila {
	private Integer id;
	private Cont cont;
	private Double suma;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cont getCont() {
		return cont;
	}
	public void setCont(Cont cont) {
		this.cont = cont;
	}
	public Double getSuma() {
		return suma;
	}
	public void setSuma(Double suma) {
		this.suma = suma;
	}
	public InregistrareContabila(Integer id, Cont cont, Double suma) {
		super();
		this.id = id;
		this.cont = cont;
		this.suma = suma;
	}
	public InregistrareContabila() {
	}
}

