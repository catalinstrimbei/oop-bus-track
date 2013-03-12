package org.app.myfaces;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Info implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String URL = "http://myfaces.apache.org/core20/myfaces2-googleappengine-eclipse-tutorial.html";
	private String currentURL = "NULL";
	
	public String getLink(){
		return URL;
	}
	
	public void setLink(String url){
		
	}
	
	public String getCurrentURL() {
		return currentURL;
	}

	public void setCurrentURL(String currentURL) {
		this.currentURL = currentURL;
	}	
}


/*
http://localhost:8888/welcome.jsf
http://localhost:8888/faces/hello.xhtml
http://localhost:8888/faces/welcome.xhtml
http://localhost:8888/faces/FormClienti.xhtml

http://startmyfaces.appspot.com/faces/welcome.xhtml
http://startmyfaces.appspot.com/faces/FormClienti.xhtml

https://sites.google.com/a/wildstartech.com/adventures-in-java/Java-Platform-Enterprise-Edition/JavaServer-Faces/javaserver-faces-20/configuring-javaserver-faces-20-to-run-on-the-google-appengine

http://myfaces.apache.org/core20/myfaces2-googleappengine-eclipse-tutorial.html
http://myfaces.apache.org/core20/googleappenginesupport.html

http://stackoverflow.com/questions/9401631/my-phaselistener-does-not-work
*/