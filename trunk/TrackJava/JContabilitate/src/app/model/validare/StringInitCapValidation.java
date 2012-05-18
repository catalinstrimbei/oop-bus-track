/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.validare;

import app.exceptii.AppException;
import app.exceptii.ExceptieValidare;

/**
 *
 * @author catalin
 */
public class StringInitCapValidation extends Validator {

    public StringInitCapValidation(String message) {
        super(message);
    }

    @Override
    public boolean validate(Object valueToValidate) throws AppException {
        if (valueToValidate == null) {
            throw new AppException("Validare valoare NULL !?!");
        }

        String value = (String) valueToValidate;
        if (value.substring(0, 1).toUpperCase().equals(value.substring(0,1))) {
            return true;
        }
        throw new ExceptieValidare(this.message);
    }
}
