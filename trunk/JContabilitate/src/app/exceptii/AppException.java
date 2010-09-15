/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.exceptii;

/**
 *
 * @author catalin
 */
public class AppException extends RuntimeException{

    public AppException(String message) {
        super(message);
    }

    public AppException() {
    }
    
}
