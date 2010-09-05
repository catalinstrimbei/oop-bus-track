package app.contabilitate.ui.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import app.model.contabilitate.RegistruConturi;

public class ContabRepositoryProvider {
	private static RegistruConturi registruConturi;
	
	public static RegistruConturi getRegistruConturi(){
		if (registruConturi == null){
	        // creare entity manager
	        EntityManagerFactory emf = Persistence.
	                createEntityManagerFactory("EntitatiContabilitate");
	        EntityManager em = emf.createEntityManager();
	
	        // initializare registru
	        registruConturi = new RegistruConturi(em);
		}
        
        return registruConturi;
	}
}
