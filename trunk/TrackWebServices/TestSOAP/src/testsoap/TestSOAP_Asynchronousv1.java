/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testsoap;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPBinding;


/**
 * Test with Asynchronous Programming Model
 * @author catalin.strimbei
 */
public class TestSOAP_Asynchronousv1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, SOAPException {
        String testMessage = "JavaSE Testing ... DII";
        System.out.println(hello(testMessage));
    }
    
    private static String hello(java.lang.String msg) throws MalformedURLException, SOAPException {
        // init service meta
        String wsdlURL = "http://localhost:8080/CalculatorWSApplication/CalculatorWS?wsdl";
        String namespace = "http://calculator.me.org/";
        String serviceName = "CalculatorWSService";
        // service endpoint interface SEI invocation
        QName serviceQN = new QName(namespace, serviceName);
        String portName = "CalculatorWSPort";
        //QName for Port As defined in wsdl.
        QName portQN = new QName(namespace, portName);
        //Endpoint Address
        String  endpointAddress = "http://localhost:8080/CalculatorWSApplication/CalculatorWS";
        
        // Create a dynamic Service instance
        Service service = Service.create(new URL(wsdlURL), serviceQN);
        // Add a port to the Service
        //service.addPort(portQN, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
        
        
        //Create a dispatch instance
        Dispatch<SOAPMessage> dispatch = 
            service.createDispatch(portQN, SOAPMessage.class, Service.Mode.MESSAGE);
        // Use Dispatch as BindingProvider
        BindingProvider bp = (BindingProvider) dispatch;
        // Optionally Configure RequestContext to send SOAPAction HTTP Header
        Map<String, Object> rc = bp.getRequestContext();
        rc.put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
        rc.put(BindingProvider.SOAPACTION_URI_PROPERTY, "hello");

        // service endpoint interface SEI invocation
        // Obtain a preconfigured SAAJ MessageFactory
        MessageFactory factory =
           ((SOAPBinding) bp.getBinding()).getMessageFactory();

        // Create SOAPMessage Request
        SOAPMessage request = factory.createMessage();

        // Request Header
        SOAPHeader header = request.getSOAPHeader();

        // Request Body
        SOAPBody body = request.getSOAPBody();

        // Compose the soap:Body payload
        QName payloadName =
           new QName("http://calculator.me.org/", "hello", "ns1");

        SOAPBodyElement payload = body.addBodyElement(payloadName); 

        SOAPElement message = payload.addChildElement("name");

        message.addTextNode(msg);

        // Invoke the endpoint synchronously
        SOAPMessage reply = null;

        try {
                //Invoke Endpoint Operation and read response
                reply = dispatch.invoke(request);
        } catch (WebServiceException wse){
                wse.printStackTrace();
        }

        // process the reply
        body = reply.getSOAPBody();

        QName responseName =
           new QName("http://calculator.me.org/", "helloResponse");

        SOAPBodyElement bodyElement = (SOAPBodyElement) body.getChildElements(responseName).next();
        String messageR = bodyElement.getValue();


        return messageR;
    }
}
