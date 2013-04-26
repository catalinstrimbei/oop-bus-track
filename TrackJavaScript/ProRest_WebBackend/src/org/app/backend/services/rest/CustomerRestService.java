package org.app.backend.services.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.sun.jersey.multipart.BodyPart;
import com.sun.jersey.multipart.MultiPart;
import com.sun.jersey.multipart.MultiPartMediaTypes;

// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/customer")
public class CustomerRestService {

  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
    return "Hello CUSTOMER REST";
  }

  // This method is called if XML is request
  @GET
  @Produces(MediaType.TEXT_XML)
  @Path("/getxml")
  public String sayXMLHello() {
    return "<?xml version=\"1.0\"?>" + "<hello> Hello CUSTOMER REST!" + "</hello>";
  }

  // This method is called if HTML is request
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello() {
    return "<html> " + "<title>" + "Hello CUSTOMER ... REST" + "</title>"
        + "<body><h1>" + "Hello CUSTOMER REST SERVICE" + "</body></h1>" + "</html> ";
  }
  
  // JSON output
  @GET
  @Path("/json/getcustomer")
  @Produces(MediaType.APPLICATION_JSON)
  public Customer getJSONCustomer(){
	  Customer customer = new Customer();
	  customer.setId(1001l);
	  customer.setName("First Customer");
	  return customer;
  }

  @GET
  @Path("/json/getcustomers")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Customer> getJSONCustomers(){
	  List<Customer> customers = new ArrayList<>();
	  customers.add(new Customer(1001l, "First Customer"));
	  customers.add(new Customer(1002l, "Second Customer"));
	  customers.add(new Customer(1003l, "Third Customer"));
	  return customers;
  }  
  
  @POST
  @Path("/json/savecustomer")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Customer saveJSONCustomer(Customer jsonCustomer){
	  System.out.println("JSON ID: " + jsonCustomer.getId());
	  System.out.println("JSON Name: " + jsonCustomer.getName());
	  jsonCustomer.setName(jsonCustomer.getName() + "_");
	  return jsonCustomer;
  }    
  
  @GET
  @Produces(MediaType.TEXT_XML)
  @Path("/getxmlcustomersdo")
  public String getXMLCustomersData() throws IOException {
	  String xmlTagSchema = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
	  String xmlTagData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	  
	  System.out.println(xmlTagSchema);
	  
	  String beginEnvelope = "<envelope>\n";
	  String endEnvelope = "\n</envelope>";
	  
	  String schema = convertXMLFileToString("sdo/data/customerSDO.xsd")
			  .replace(xmlTagSchema, "");
	  System.out.println("Schema \n " + schema);
	  String data = convertXMLFileToString("sdo/data/customerSDO.xml")
			  .replace(xmlTagSchema, "\n");
	  
	  return beginEnvelope + schema + data + endEnvelope;
  }    
  
  @GET
  @Produces(MediaType.TEXT_XML)
  @Path("/getxmlcustomers")
  public String getXMLCustomers() throws IOException {
	 //return convertXMLFileToString("sdo/data/customerSDO.xsd") + "\n" + convertXMLFileToString("sdo/data/customerSDO.xml");
	  return convertXMLFileToString("sdo/data/customerSDO.xml");
  }  
  
  @GET
  @Produces(MediaType.TEXT_XML)
  @Path("/getxsdcustomers")
  public String getXSDCustomers() throws IOException {
	  return convertXMLFileToString("sdo/data/customerSDO.xsd");
  }  

  private String convertXMLFileToString(String fileName) { 
	    try{ 
	      DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance(); 
	      InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
	      org.w3c.dom.Document doc = documentBuilderFactory.newDocumentBuilder().parse(inputStream); 
	      StringWriter stw = new StringWriter(); 
	      Transformer serializer = TransformerFactory.newInstance().newTransformer(); 
	      serializer.transform(new DOMSource(doc), new StreamResult(stw)); 
	      return stw.toString(); 
	    } 
	    catch (Exception e) { 
	      e.printStackTrace(); 
	    } 
	      return null; 
	      
  }  
  
	@GET
	@Path("/getxmlcustomersmultipart")
	@Produces("application/xml")
	public Response getMediaTypeMappings() {
		  
	      MultiPart multiPart = new MultiPart()
		 	.bodyPart(new BodyPart(convertXMLFileToString("sdo/data/customerSDO.xsd"), MediaType.APPLICATION_XML_TYPE))
		 	.bodyPart(new BodyPart(convertXMLFileToString("sdo/data/customerSDO.xml"), MediaType.APPLICATION_XML_TYPE));
	  
	  
	  return Response.ok(multiPart, MultiPartMediaTypes.MULTIPART_MIXED).build();
	  // return Response.ok(multiPart, MediaType.MULTIPART_FORM_DATA).build(); 
	  // Response.ok(multiPart, MultiPartMediaTypes.MULTIPART_MIXED).build(); 
	}
  
//  	@GET
//  	@Path("/getxmlcustomersmultipart")
//		@Produces("application/xml")
	public Response getFile() throws IOException {
		File fileResponse = new File("customerSDO_out.xml");
		String fileName = "sdo/data/customerSDO.xsd";
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
		FileOutputStream outputStream=new FileOutputStream(fileResponse);
		IOUtils.copy(inputStream, outputStream);
		
		ResponseBuilder response = Response.ok((Object) fileResponse);
		response.header("Content-Disposition",
				"attachment; customerSDO_out.xml");
		return response.build();

	}  
} 
  /*
  @Produces(MediaType.APPLICATION_XML)
  public Response getXMLCustomersMultiPart(){
	  //
	 MultiPart multiPart = new MultiPart()
	 	.bodyPart(new BodyPart(convertXMLFileToString("sdo/data/customerSDO.xsd"), MediaType.APPLICATION_XML_TYPE))
	 	.bodyPart(new BodyPart(convertXMLFileToString("sdo/data/customerSDO.xml"), MediaType.APPLICATION_XML_TYPE));
	 
	 return Response.ok(multiPart, MultiPartMediaTypes.MULTIPART_MIXED_TYPE).build(); 
  }
  
  @GET
  @Path("/getxmlcustomersmultipart")
  @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_XML})   
  public Map<String, MediaType> getMediaTypeMappings() {
      Map<String, MediaType> m = new HashMap<String, MediaType> ();
      m.put(convertXMLFileToString("sdo/data/customerSDO.xsd"), MediaType.APPLICATION_XML_TYPE);
      m.put(convertXMLFileToString("sdo/data/customerSDO.xml"), MediaType.APPLICATION_XML_TYPE);
      return m;
  }  
  
  */


/*
	http://localhost:8080/ProRest_WebBackend/services/customer
	http://localhost:8080/ProRest_WebBackend/services/customer/json/getcustomers
	http://localhost:8080/ProRest_WebBackend/services/customer/sayXMLHello
	http://localhost:8080/ProRest_WebBackend/services/customer/getxml
	http://localhost:8080/ProRest_WebBackend/services/customer/getxmlcustomers
	http://localhost:8080/ProRest_WebBackend/services/customer/getxmlcustomersmultipart
	
	http://theopentutorials.com/examples/java-ee/jax-rs/create-a-simple-restful-web-service-using-jersey-jax-rs/
	http://www.vogella.com/articles/REST/article.html	
	
	
  <!-- Second REST Service -->
  <servlet>
    <servlet-name>Customer_REST_Service</servlet-name>
    <servlet-class>com.sun.jersey.spi.container.servlet.ServletContainer</servlet-class>
    <init-param>
      <param-name>com.sun.jersey.config.property.packages</param-name>
      <param-value>org.app.backend.services.rest</param-value>
    </init-param>
	<init-param>
       <param-name>com.sun.jersey.api.json.POJOMappingFeature</param-name>
       <param-value>true</param-value>
    </init-param>    
    <load-on-startup>1</load-on-startup>
  </servlet>
  
  <servlet-mapping>
    <servlet-name>Customer_REST_Service</servlet-name>
    <url-pattern>/customer/*</url-pattern>
  </servlet-mapping>	
  
  
  
<?xml version="1.0" encoding="UTF-8"?>
<customer xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:type="customer">
   <address>
      <street>123 Any Street</street>
   </address>
   <name>Jobs Steve</name>
</customer>  
*/
