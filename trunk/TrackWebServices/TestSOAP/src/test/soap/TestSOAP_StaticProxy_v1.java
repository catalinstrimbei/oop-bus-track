/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.soap;

/**
 *
 * @author catalin.strimbei
 */
public class TestSOAP_StaticProxy_v1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String testMessage = "JavaSE Testing ... ";
        System.out.println(hello(testMessage));
    }

    private static String hello(java.lang.String name) {
        org.me.calculator.CalculatorWSService service = new org.me.calculator.CalculatorWSService();
        org.me.calculator.CalculatorWS port = service.getCalculatorWSPort();
        // service endpoint interface SEI invocation
        return port.hello(name);
    }

    private static int add(int i, int j) {
        org.me.calculator.CalculatorWSService service = new org.me.calculator.CalculatorWSService();
        org.me.calculator.CalculatorWS port = service.getCalculatorWSPort();
        return port.add(i, j);
    }
    
    
    
}
