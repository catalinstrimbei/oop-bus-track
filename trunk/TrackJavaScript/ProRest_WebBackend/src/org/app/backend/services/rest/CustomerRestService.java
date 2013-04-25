package org.app.backend.services.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

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
  @Path("/getxmlcustomers")
  public String getXMLCustomers() throws IOException {
	  InputStream fis = Thread.currentThread().getContextClassLoader().getResourceAsStream("sdo/data/customerSDO.xml");
	  
	  BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
	  StringBuilder sb = new StringBuilder();
	    try {
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        String everything = sb.toString();
	    } finally {
	        br.close();
	    }	

	    return sb.toString() ;
    
    /*
     ------------------------
     //String getXMLCustomers(@Context HttpServletResponse  serv) throws IOException
	    ServletOutputStream o =serv.getOutputStream();
	    StringBuffer sb = new StringBuffer();
	    try {
	        FileInputStream fis = new FileInputStream(new File("src/sdo/data/customerSDO.xml"));
	        int c;

	        while ((c = fis.read()) != -1) {
	           o.write(c);
	           sb.append(b)
	        }

	        fis.close();
	        o.close();
	    } catch (Exception e) {
	        System.err.println("e");
	    } 

	    return "OK" ;
	    -------------------------     
      @GET
      @Produces("multipart/mixed")
      public MultipartOutput get()
      {
         MultipartOutput output = new MultipartOutput();
         output.addPart(new Customer("bill"), MediaType.APPLICATION_XML_TYPE);
         output.addPart(new Customer("monica"), MediaType.APPLICATION_XML_TYPE);
         return output;
      }    
    */
  }  
} 


/*
	http://localhost:8080/ProRest_WebBackend/services/customer
	http://localhost:8080/ProRest_WebBackend/services/customer/json/getcustomers
	http://localhost:8080/ProRest_WebBackend/services/customer/sayXMLHello
	http://localhost:8080/ProRest_WebBackend/services/customer/getxml
	http://localhost:8080/ProRest_WebBackend/services/customer/getxmlcustomers
	
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
*/
