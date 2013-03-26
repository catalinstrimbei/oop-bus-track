package org.app.myfaces;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.app.entities.TestPersistenta;

@ManagedBean
@SessionScoped
public class FormTestPersistenta implements Serializable{
	private String output = "[No result ... yet]";

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}
	
	
	public void runTest(ActionEvent evt) {
		this.output = TestPersistenta.test();
	}
	
	
}

/*
 * http://localhost:8888/faces/FormTestPersistenta.xhtml
 * 
 */
