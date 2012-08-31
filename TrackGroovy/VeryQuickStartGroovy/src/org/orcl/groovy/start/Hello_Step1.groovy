package org.orcl.groovy.start

// Step1: Example Program - Java Class as Start Grooving Class
public class Hello_Step1 {
    String name;
    
    public void sayHello() {
        System.out.println("Hello "+getName()+" - Start Class !");
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public static void main(String[] args) {
    
        Hello_Step1 hello = new Hello_Step1();
        hello.setName("world");
        hello.sayHello();
    }
}