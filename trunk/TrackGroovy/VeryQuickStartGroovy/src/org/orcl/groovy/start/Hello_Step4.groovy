package org.orcl.groovy.start

// Step 4: Further Shortening the Program: System.out.println can be shortened to just println  
class Hello_Step4 {
    String name;
    
    void sayHello() {
        println("Hello "+getName()+" - Step 4 !");
    }
    
    static void main(String[] args) {
    
        Hello_Step4 hello = new Hello_Step4();
        hello.setName("world");
        hello.sayHello();
    }
}