/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.teste;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 *
 * @author catalin.strimbei
 */
public class ContabLogFormatter extends Formatter {

    @Override
    public String format(LogRecord arg0) {
        StringBuilder b = new StringBuilder();
//                b.append(new Date());
//                b.append(" ");
//                b.append(arg0.getSourceClassName());
//                b.append(" ");
//                b.append(arg0.getSourceMethodName());
//                b.append(" ");
        b.append(arg0.getLevel());
        b.append(" ");
        b.append(arg0.getMessage());
        b.append(System.getProperty("line.separator"));
        return b.toString();
    }
}
