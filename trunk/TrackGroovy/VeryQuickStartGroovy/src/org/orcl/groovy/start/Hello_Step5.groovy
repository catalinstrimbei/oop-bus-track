package org.orcl.groovy.start

// Step 5: Strings with Double Quotation Marks and Single Quotation Marks  
class Hello_Step5 {
    String name;
    
    void sayHello() {
        println("Hello $name- Step 5 !");
    }
    
    static void main(String[] args) {
    
        Hello_Step5 hello = new Hello_Step5();
        hello.setName('world');
        hello.sayHello();
    }
}