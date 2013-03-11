package org.app.startjsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Info implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String URL = "https://sites.google.com/a/wildstartech.com/adventures-in-java/Java-Platform-Enterprise-Edition/JavaServer-Faces/javaserver-faces-20/configuring-javaserver-faces-20-to-run-on-the-google-appengine";
	public String getLink(){
		return URL;
	}
	
	public void setLink(String url){
		
	}
}


/*
http://localhost:8888/faces/hello.xhtml
http://localhost:8888/faces/welcome.xhtml

http://startjsf.appspot.com/faces/welcome.xhtml

https://sites.google.com/a/wildstartech.com/adventures-in-java/Java-Platform-Enterprise-Edition/JavaServer-Faces/javaserver-faces-20/configuring-javaserver-faces-20-to-run-on-the-google-appengine
http://myfaces.apache.org/core20/myfaces2-googleappengine-eclipse-tutorial.html
*/