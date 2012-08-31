package org.orcl.groovy.start

// Step2:  An Alternate Way to Code the Example Program: things are public by default
class Hello_Step2 {
    String name;
    
    void sayHello() {
        System.out.println("Hello "+getName()+" - Step 2 !");
    }
    
    void setName(String name) {
        this.name = name;
    }
    
    String getName() {
        return name;
    }
    
    static void main(String[] args) {
    
        Hello_Step2 hello = new Hello_Step2();
        hello.setName("world");
        hello.sayHello();
    }
}