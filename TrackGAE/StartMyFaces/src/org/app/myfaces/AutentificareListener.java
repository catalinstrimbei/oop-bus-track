package org.app.myfaces;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AutentificareListener implements javax.faces.event.PhaseListener {
	private static final long serialVersionUID = 1L;
	//private static final Logger log = Logger.getLogger(AutentificareListener.class.getName());	
	
	@Override
	public void afterPhase(PhaseEvent event) {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		
		System.out.println("*************** INTERCEPT AFTER: " + request.getRequestURI());
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		
		System.out.println("*************** INTERCEPT BEFORE: " + request.getRequestURI());
		
		FacesContext context = event.getFacesContext();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(true);
		Info info = (Info) session.getAttribute("info");	
		
		System.out.println("info = " + info);
		
		if (info == null){
			info = new Info();
			session.setAttribute("info", info);
		}
		info.setCurrentURL(request.getRequestURI());
	}

	@Override
	public PhaseId getPhaseId() {
	    //ALL access go through RESTORE_VIEW and RENDER_VIEW (even direct url)
	    return PhaseId.RESTORE_VIEW;
	}

}
