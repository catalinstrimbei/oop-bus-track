package org.app.backend.services.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
} 


/*
	http://localhost:8080/ProRest_WebBackend/services/customer
	
	
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
