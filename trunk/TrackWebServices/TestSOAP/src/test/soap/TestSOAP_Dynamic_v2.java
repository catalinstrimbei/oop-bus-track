/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.me.calculator.CalculatorWS;


/**
 * Test with Dispatch Client Model
 * @author catalin.strimbei
 */
public class TestSOAP_Dynamic_v2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException {
        String testMessage = "JavaSE Testing ... DII";
        System.out.println(hello(testMessage));
    }
    
    private static String hello(java.lang.String name) throws MalformedURLException {
        // init service meta
        String wsdlURL = "http://localhost:8080/CalculatorWSApplication/CalculatorWS?wsdl";
        String namespace = "http://calculator.me.org/";
        String serviceName = "CalculatorWSService";
        QName serviceQN = new QName(namespace, serviceName);
        Service service = Service.create(new URL(wsdlURL), serviceQN);
        
        // init port meta
        String portName = "CalculatorWSPort";
        QName portQN = new QName(namespace, portName);
        
        // service endpoint interface SEI invocation
        // TODO
        
        return null;
    }
}
