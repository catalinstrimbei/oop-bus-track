package org.comenzi.forms;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

public class PhaseTracker implements
	javax.faces.event.PhaseListener {

	public void afterPhase(PhaseEvent event) {
//		FacesContext.getCurrentInstance().getExternalContext().log("AFTER - "+
//                                  event.getPhaseId());
		System.out.println("AFTER - "+ event.getPhaseId());
	}
	public void beforePhase(PhaseEvent event) {
//		FacesContext.getCurrentInstance().getExternalContext().log("BEFORE - "+
//                                 event.getPhaseId());
		System.out.println("BEFORE - "+ event.getPhaseId());
	}
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}