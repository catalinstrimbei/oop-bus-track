/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.model.validare;

import app.exceptii.AppException;

/**
 *
 * @author catalin
 */
public abstract class Validator {
    protected String message;

    public Validator(String message) {
        this.message = message;
    }

    public abstract boolean validate(Object valueToValidate) throws AppException;
}
