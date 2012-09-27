/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.calculator;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author catalin.strimbei
 */
//Service Endpoint Interface
@WebService
public interface CalculatorWSHello {
    @WebMethod 
    public String hello(
            @WebParam(name = "name", targetNamespace = "")
                    String name
            );
}
