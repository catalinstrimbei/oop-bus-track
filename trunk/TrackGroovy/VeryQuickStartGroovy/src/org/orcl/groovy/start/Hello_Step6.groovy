package org.orcl.groovy.start

// Step 6: Dot Notation  
class Hello_Step6 {
    String name;
    
    void sayHello() {
        println("Hello $name- Step 6 !");
    }
    
    static void main(String[] args) {
    
        Hello_Step6 hello = new Hello_Step6();
        hello.name = 'world'; // Dot Notation
        hello.sayHello();
    }
}