package org.comenzi.uiforms;

import java.io.IOException;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

public interface Page {

	void buildView(FacesContext context, UIViewRoot root) throws IOException;
	
}
