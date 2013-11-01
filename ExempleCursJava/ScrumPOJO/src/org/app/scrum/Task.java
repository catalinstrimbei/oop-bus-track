package org.app.scrum;

import java.util.Date;

public class Task {
	private Integer idTask;
	private String denumire;
	private String descriere;
	private Date dataStart;
	private Integer timpEstimat; // initial
	private Integer timpRamas; // actualizat
	private StatusTask statusTask;
	private CategorieTask categorieTask;
	public Integer getIdTask() {
		return idTask;
	}
	public void setIdTask(Integer idTask) {
		this.idTask = idTask;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	public Date getDataStart() {
		return dataStart;
	}
	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}
	public Integer getTimpEstimat() {
		return timpEstimat;
	}
	public void setTimpEstimat(Integer timpEstimat) {
		this.timpEstimat = timpEstimat;
	}
	public Integer getTimpRamas() {
		return timpRamas;
	}
	public void setTimpRamas(Integer timpRamas) {
		this.timpRamas = timpRamas;
	}
	public StatusTask getStatusTask() {
		return statusTask;
	}
	public void setStatusTask(StatusTask statusTask) {
		this.statusTask = statusTask;
	}
	public CategorieTask getCategorieTask() {
		return categorieTask;
	}
	public void setCategorieTask(CategorieTask categorieTask) {
		this.categorieTask = categorieTask;
	}
	public Task(Integer idTask, String denumire, String descriere,
			Date dataStart, Integer timpEstimat, StatusTask statusTask,
			CategorieTask categorieTask) {
		super();
		this.idTask = idTask;
		this.denumire = denumire;
		this.descriere = descriere;
		this.dataStart = dataStart;
		this.timpEstimat = timpEstimat;
		this.statusTask = statusTask;
		this.categorieTask = categorieTask;
	}
	public Task() {
		super();
	}
	
	
}

enum StatusTask{
	IN_CURS, BLOCAT, FINALIZAT, SUSPENDAT;
}

enum CategorieTask{
	ANALIZA, DESIGN, IMPLEMENTARE, TEST;
}
