package org.app.groovy

import org.app.java.JavaContext

class GroovyContext {
	def message = 'empty groovy'
	
	static void main(def args){
		def jcontext= new JavaContext();
		jcontext.message = '... groovy context...'
		println jcontext
	}
	
	String toString(){
		return "GroovyContext [message from $message]";
	}
}
