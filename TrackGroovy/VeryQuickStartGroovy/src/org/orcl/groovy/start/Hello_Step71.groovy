package org.orcl.groovy.start

// Step 7: Using wrapping class (called Script) with main-method automatically generated. Name of wrapping class is name of .groovy file

//class Hello_Step71 {
    
    def sayHello(name) {
        println("Hello $name- Step 7.1 ! As script");
    }
    
//    def static main(String[] args) {
    
//        Hello_Step71 hello = new Hello_Step71();
        def name = 'world'; 
//        hello.sayHello(name);
		sayHello(name);
//    }
//}
		
		
		println(this.class.getName())