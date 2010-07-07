/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.teste;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import app.model.contabilitate.InregistrareCredit;
import app.model.contabilitate.InregistrareDebit;
import app.model.contabilitate.OperatiuneContabila;
import app.model.contabilitate.RegistruClaseConturi;
import app.model.contabilitate.RegistruConturi;
import app.model.contabilitate.RegistruOperatiuni;
import app.model.contabilitate.conturi.ClasaConturi;
import app.model.contabilitate.conturi.Cont;

/**
 *
 * @author catalin.strimbei
 */
public class TestJContabilitate {
    static final Logger logger = Logger.getLogger(TestJContabilitate.class.getName());
    
    public static void main(String[] args){
        configLogger();
        initRegistri();
        creareConturi(100);
        creareOperatiuni(1000, 3);

    }

    private static RegistruConturi registruConturi;
    private static RegistruOperatiuni registruOperatiuni;
    private static RegistruClaseConturi registruClaseConturi;
    private static void initRegistri() {
        // creare entity manager
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("EntitatiContabilitate");
        EntityManager em = emf.createEntityManager();

        // initializare registri
        registruConturi = new RegistruConturi(em);
        registruOperatiuni = new RegistruOperatiuni(em);
        registruClaseConturi = new RegistruClaseConturi(em);
    }

    private static void creareConturi(Integer cntConturi) {
        logger.info("-- BEGIN Initializare conturi -----------------");
        Integer nrClase;
        Integer nrSubClase;
        Integer nrConturi;
        Integer cntConturiGen = 0;
        if (cntConturi <= 3){
        	nrClase = 1;
        	nrSubClase = 1;
        }else if (cntConturi < 12){
        	nrClase = 2;
        	if (Math.abs(cntConturi/(nrClase * 2)) > 0)
        		nrSubClase = 2;
        	else
        		nrSubClase = 1;        	
        }else {
        	nrClase = 6;
        	if (Math.abs(cntConturi/(nrClase * 3)) > 0)
        		nrSubClase = 3;
        	else if (Math.abs(cntConturi/(nrClase * 2)) > 0)
        		nrSubClase = 2;
        	else 
        		nrSubClase = 1;
        }
        nrConturi = Math.abs(cntConturi/(nrClase*nrSubClase));
        
        //System.out.println("-- BEGIN Initializare conturi -----------------");
        List<ClasaConturi> clase = new ArrayList<ClasaConturi>();
        List<ClasaConturi> subClase = new ArrayList<ClasaConturi>();

        // generare [nrClase] clase conturi
        ClasaConturi clasaTest;
        for (int i = 1; i <= nrClase; i++) {
            clasaTest = new ClasaConturi(String.valueOf(i), "Clasa " + i);
            logger.info(clasaTest.getDenumire());
            //System.out.println(clasaTest.getDenumire());
            clase.add(clasaTest);
            //registruClaseConturi.addClasaConturi(clasaTest);
        }

        // generare [nrClase * nrSubclase] sub-clase conturi
        ClasaConturi subClasaTest;
        for(ClasaConturi clasa: clase){
            for (int i = 1; i <= nrSubClase; i++){
                subClasaTest = new ClasaConturi(clasa.getCod() + i, "Sub clasa " + clasa.getCod() + i);
                subClasaTest.setClasaParinte(clasa);
                logger.info(subClasaTest.getDenumire());
                //System.out.println(subClasaTest.getDenumire());
                subClase.add(subClasaTest);
                //registruClaseConturi.addClasaConturi(subClasaTest);
            }
        }

        // generare [cntConturi] conturi
        Cont contTest;
        for(ClasaConturi subClasa: subClase){
            for (int i = 1; i <= nrConturi; i++){
                contTest = new Cont(subClasa.getCod() + i, "Cont " + subClasa.getCod() + i);
                //contTest.setSubClasaCont(subClasa);
                subClasa.addCont(contTest);
                logger.info(contTest.getDenumire());
                //System.out.println(contTest.getDenumire());
                registruConturi.addCont(contTest);
                cntConturiGen++;
                if (cntConturiGen >= cntConturi)
                	break;
            }
        }
        if (cntConturiGen < cntConturi){
        	for (int i = (cntConturiGen + 1); i <= cntConturi; i++){
                contTest = new Cont(subClase.get(0).getCod() + (subClase.get(0).getConturi().size() + 1), 
                		"Cont " + subClase.get(0).getCod() + (subClase.get(0).getConturi().size() + 1));
                subClase.get(0).addCont(contTest);
                logger.info(contTest.getDenumire());
                registruConturi.addCont(contTest);
                cntConturiGen++;        		
        	}
        }        
        logger.info("Generated: " + cntConturiGen + " from " + cntConturi);
        
        logger.info("-- END Initializare conturi -----------------");
        //System.out.println("-- END Initializare conturi -----------------");
    }

    private static void creareOperatiuni(Integer cntOperatiuni, Integer cntInregistrari) {
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
        Integer cntClase = registruConturi.getCountClase().intValue();
        logger.info("Count clase: " + cntClase);
        Integer cntSubClase;
        Integer cntConturi;
        Integer codClasa;
        Integer codSubClasa;
        
        for (int i = 1; i <= cntOperatiuni; i++){
            operatiune = new OperatiuneContabila(i, new Date());
            logger.info("Operatiunea: " + i);
            //System.out.println("Operatiunea: " + i);
            // generare inreg debit
            rndDb = rDb.nextInt(cntInregistrari) + 1;
            for (int r = 1; r <= rndDb; r++){
            	codClasa = rContClasa.nextInt(cntClase);
            	if (codClasa == 0) codClasa = 1;
            	logger.info("codClasa = " + codClasa);
            	
            	cntSubClase = registruConturi.getCountSubClase(codClasa).intValue();
            	
            	codSubClasa = rContSubClasa.nextInt(cntSubClase);
            	if (codSubClasa == 0) codSubClasa = 1;
            	logger.info("codSubClasa = " + codClasa + codSubClasa);
            	
            	cntConturi = registruConturi.getCountConturi(
            			Integer.valueOf(codClasa.toString() + codSubClasa.toString())
            			).intValue();
            	logger.info("cntConturi = " + cntConturi);
                codCont = String.valueOf(codClasa)
                        + String.valueOf(codSubClasa)
                        + String.valueOf(rCont.nextInt(cntConturi) + 1);
                logger.info("-- Cont Debit: " + codCont);
                
                //System.out.println("-- Cont Debit: " + codCont);
                iDebit = new InregistrareDebit(registruConturi.getCont(codCont), new Double(rSuma.nextInt(1000)));
                operatiune.addInregistrareContabila(iDebit);
            }
            
            // generare inreg credit
            rndCr = rCr.nextInt(cntInregistrari) + 1;
            for (int r = 1; r <= rndCr; r++){
            	codClasa = rContClasa.nextInt(cntClase);
            	if (codClasa == 0) codClasa = 1;
            	cntSubClase = registruConturi.getCountSubClase(codClasa).intValue();
            	codSubClasa = rContSubClasa.nextInt(cntSubClase);
            	if (codSubClasa == 0) codSubClasa = 1;
            	cntConturi = registruConturi.getCountConturi(
            			Integer.valueOf(codClasa.toString() + codSubClasa.toString())
            			).intValue();
            	
                codCont = String.valueOf(codClasa)
                        + String.valueOf(codSubClasa)
                        + String.valueOf(rCont.nextInt(cntConturi) + 1);
                
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