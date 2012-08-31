package org.orcl.groovy.start

// Step 3: Shortening the Program: eliminate get/set  
class Hello_Step3 {
    String name;
    
    void sayHello() {
        System.out.println("Hello "+getName()+" - Step 3 !");
    }
    
    static void main(String[] args) {
    
        Hello_Step3 hello = new Hello_Step3();
        hello.setName("world");
        hello.sayHello();
    }
}