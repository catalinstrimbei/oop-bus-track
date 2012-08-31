package org.app.java;

import org.app.groovy.GroovyContext;

public class JavaContext {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "JavaContext [message from" + message + "]";
	}
	
	public static void main(String[] args){
		GroovyContext groovyContext = new GroovyContext();
		groovyContext.setMessage("... Java Context ...");
		System.out.println(groovyContext);
	}
}