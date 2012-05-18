/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.teste;

import app.model.contabilitate.InregistrareCredit;
import app.model.contabilitate.InregistrareDebit;
import app.model.contabilitate.OperatiuneContabila;
import app.model.contabilitate.RegistruClaseConturi;
import app.model.contabilitate.RegistruConturi;
import app.model.contabilitate.RegistruOperatiuni;
import app.model.contabilitate.conturi.ClasaConturi;
import app.model.contabilitate.conturi.Cont;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFileChooser;

/**
 *
 * @author catalin.strimbei
 */
public class TestJContabilitate {
    static final Logger logger = Logger.getLogger(TestJContabilitate.class.getName());
    
    public static void main(String[] args){
        configLogger();
        initRegistri();
        creareConturi();
        creareOperatiuni();

    }

    private static RegistruConturi registruConturi;
    private static RegistruOperatiuni registruOperatiuni;
    private static RegistruClaseConturi registruClaseConturi;
    private static void initRegistri() {
        // creare entity manager
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("JContabilitate_PU");
        EntityManager em = emf.createEntityManager();

        // initializare registri
        registruConturi = new RegistruConturi(em);
        registruOperatiuni = new RegistruOperatiuni(em);
        registruClaseConturi = new RegistruClaseConturi(em);
    }

    private static void creareConturi() {
        logger.info("-- BEGIN Initializare conturi -----------------");
        //System.out.println("-- BEGIN Initializare conturi -----------------");
        List<ClasaConturi> clase = new ArrayList<ClasaConturi>();
        List<ClasaConturi> subClase = new ArrayList<ClasaConturi>();

        // generare 3 clase conturi
        ClasaConturi clasaTest;
        for (int i = 1; i <= 3; i++) {
            clasaTest = new ClasaConturi(String.valueOf(i), "Clasa " + i);
            logger.info(clasaTest.getDenumire());
            //System.out.println(clasaTest.getDenumire());
            clase.add(clasaTest);
        }

        // generare 6 sub-clase conturi
        ClasaConturi subClasaTest;
        for(ClasaConturi clasa: clase){
            for (int i = 1; i <= 2; i++){
                subClasaTest = new ClasaConturi(clasa.getCod() + i, "Sub clasa " + clasa.getCod() + i);
                subClasaTest.setClasaParinte(clasa);
                logger.info(subClasaTest.getDenumire());
                //System.out.println(subClasaTest.getDenumire());
                subClase.add(subClasaTest);
            }
        }

        // generare 30=6*5 conturi
        Cont contTest;
        for(ClasaConturi subClasa: subClase){
            for (int i = 1; i <= 5; i++){
                contTest = new Cont(subClasa.getCod() + i, "Cont " + subClasa.getCod() + i);
                contTest.setSubClasaCont(subClasa);
                logger.info(contTest.getDenumire());
                //System.out.println(contTest.getDenumire());
                registruConturi.addCont(contTest);
            }
        }

        logger.info("-- END Initializare conturi -----------------");
        //System.out.println("-- END Initializare conturi -----------------");
    }

    private static void creareOperatiuni() {
        logger.info("-- BEGIN Executie generare Operatiuni Contabile ------------");
        //System.out.println("-- BEGIN Executie generare Operatiuni Contabile ------------");

        // 100 de operatiuni
        OperatiuneContabila operatiune;
        Random rDb = new Random();
        Random rCr = new Random();
        Random rSuma = new Random();
        Random rContClasa = new Random();
        Random rContSubClasa = new Random();
        Random rCont = new Random();
        Integer rndDb;
        Integer rndCr;
        InregistrareDebit iDebit;
        InregistrareCredit iCredit;
        String codCont;
        for (int i = 1; i <= 10; i++){
            operatiune = new OperatiuneContabila(i, new Date());
            logger.info("Operatiunea: " + i);
            //System.out.println("Operatiunea: " + i);
            // generare inreg debit
            rndDb = rDb.nextInt(3) + 1;
            for (int r = 1; r <= rndDb; r++){
                codCont = String.valueOf(rContClasa.nextInt(2) + 1)
                        + String.valueOf(rContSubClasa.nextInt(1) + 1)
                        + String.valueOf(rCont.nextInt(4) + 1);
                logger.info("-- Cont Debit: " + codCont);
                //System.out.println("-- Cont Debit: " + codCont);
                iDebit = new InregistrareDebit(registruConturi.getCont(codCont), new Double(rSuma.nextInt(1000)));
                operatiune.addInregistrareContabila(iDebit);
            }
            
            // generare inreg credit
            rndCr = rCr.nextInt(3) + 1;
            for (int r = 1; r <= rndCr; r++){
                codCont = String.valueOf(rContClasa.nextInt(2) + 1)
                        + String.valueOf(rContClasa.nextInt(1) + 1)
                        + String.valueOf(rContClasa.nextInt(4) + 1);
                logger.info("-- Cont Credit: " + codCont);
                //System.out.println("-- Cont Credit: " + codCont);
                iCredit = new InregistrareCredit(registruConturi.getCont(codCont), new Double(rSuma.nextInt(1000)));
                operatiune.addInregistrareContabila(iCredit);
            }
            registruOperatiuni.addOperatiuneContabila(operatiune);
        }

        logger.info("-- END Executie generare Operatiuni Contabile ------------");
        //System.out.println("-- END Executie generare Operatiuni Contabile ------------");
    }

    private static void configLogger() {
        
        Properties prop = System.getProperties();
        prop.setProperty(
            "java.util.logging.config.file",
            "src/contablog.properties");

        String currentdir = System.getProperty("user.dir");


        try {
             LogManager.getLogManager()
                .readConfiguration();
          }
          catch (IOException ex) {
             logger.log(Level.WARNING,
                "Problems to load the logging "+
                "configuration file", ex);
          }

        logger.info(currentdir);
    }
}