package app.contabilitate.ui.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import app.model.contabilitate.RegistruConturi;
import app.model.contabilitate.conturi.Cont;

public class ConturiBean {
	List<Cont> conturi;
	RegistruConturi registruConturi;
	Cont cont;
	
	public ConturiBean(){
		registruConturi = ContabRepositoryProvider.getRegistruConturi();
		this.conturi = new ArrayList<Cont>(registruConturi.getConturi());
	}
	
	public List<Cont> getConturi(){
		return conturi;
	}
	
	public Integer getConturiCont(){
		return conturi.size();
	}
	
	public Cont getCont(){
		return cont;
	}
}