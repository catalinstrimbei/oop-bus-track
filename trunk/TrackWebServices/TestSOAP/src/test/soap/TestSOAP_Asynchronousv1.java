/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.soap;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
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
    static Logger logger = Logger.getLogger(TestSOAP_Asynchronousv1.class.getName());
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String testMessage = "JavaSE Testing ... DII";
        logger.info(hello(testMessage));
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
        
        // v1. Create a dynamic Service instance
        // Service service = Service.create(serviceQN);
        // Add a port to the Service
        // service.addPort(portQN, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
        
        
        // v2. Create a dynamic Service instance using WSDL
        URL wsdlLocation = new URL(wsdlURL);
        Service service = Service.create(wsdlLocation, serviceQN);
        
        
        //Create a dispatch instance
        Dispatch<SOAPMessage> dispatch = service.createDispatch(portQN, SOAPMessage.class, Service.Mode.MESSAGE);
        //Dispatch<Source> dispatch = service.createDispatch(portQN, javax.xml.transform.Source.class,Service.Mode.PAYLOAD);
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
        QName payloadQN =
           new QName(namespace, "hello", "ns1");
        SOAPBodyElement payload = body.addBodyElement(payloadQN); 
        SOAPElement message = payload.addChildElement("name");
        message.addTextNode(msg);
        request.saveChanges();
        
        /*
        SOAPElement operation = body.addChildElement("hello", "ns1", namespace);
        SOAPElement value = operation.addChildElement("name");
        value.addTextNode(msg);
        request.saveChanges();
        */
        // Invoke the endpoint synchronously
        SOAPMessage reply = null;
        //Invoke Endpoint Operation and read response
        reply = dispatch.invoke(request);
        // process the reply
        body = reply.getSOAPBody();
        QName responseName =
           new QName(namespace, "helloResponse");
        SOAPBodyElement bodyElement = (SOAPBodyElement) body.getChildElements(responseName).next();        
        String messageR = bodyElement.getTextContent();
        logger.info(bodyElement.getValue());
        return messageR;
    }
    
    private static String hello2(java.lang.String msg) throws Exception {
        String wsdlURL = "http://localhost:8080/CalculatorWSApplication/CalculatorWS?wsdl";
        URL wsdlLocation = new URL(wsdlURL);
        String namespace = "http://calculator.me.org/";
        String serviceName = "CalculatorWSService";        
        QName serviceQN = new QName(namespace, serviceName);
        Service service = Service.create(wsdlLocation, serviceQN);
        String portName = "CalculatorWSPort";
        QName portQN = new QName(namespace, portName);
        
        /** Create a Dispatch instance from a service.**/ 
        Dispatch<SOAPMessage> dispatch = service.createDispatch(portQN, SOAPMessage.class, Service.Mode.MESSAGE);

        /** Create SOAPMessage request. **/
        // compose a request message
        MessageFactory mf = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);

        // Create a message.  This example works with the SOAPPART.
        SOAPMessage request = mf.createMessage();
        SOAPPart part = request.getSOAPPart();

        // Obtain the SOAPEnvelope and header and body elements.
        SOAPEnvelope env = part.getEnvelope();
        SOAPHeader header = env.getHeader();
        SOAPBody body = env.getBody();

        // Construct the message payload.
        SOAPElement operation = body.addChildElement("hello", "ns1", namespace);
        SOAPElement value = operation.addChildElement("name");
        value.addTextNode(msg);
        request.saveChanges();

        /** Invoke the service endpoint. **/
        SOAPMessage response = dispatch.invoke(request);

        /** Process the response. **/        
        logger.info(response.getSOAPBody().getValue());
        return response.getSOAPBody().getTextContent();
    }
}
