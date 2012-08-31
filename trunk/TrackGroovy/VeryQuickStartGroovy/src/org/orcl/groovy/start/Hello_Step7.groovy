package org.orcl.groovy.start

// Step 7: The def Keyword  
class Hello_Step7 {
    
    def sayHello(name) {
        println("Hello $name- Step 7 !");
    }
    
    def static main(String[] args) {
    
        Hello_Step7 hello = new Hello_Step7();
        def name = 'world'; // def as local variable
        hello.sayHello(name);
    }
}