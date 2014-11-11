package cap3.ex3.org.app.scrum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Test implementare interfete
 */

public class Test33_ServiceInterface {

	public static void main(String[] args) throws Exception{
		// BurnDownItems: Sprints and Tasks, nu Cerinta.
		
		// Sprints implements BurnDownItems
		Sprint s = new Sprint();
		
		// Cerinta not implements BurnDownItems
		CerintaFunctionala c1 = new CerintaFunctionala();
		s.adaugaCerinta(c1);
		CerintaFunctionala c2 = new CerintaFunctionala();
		s.adaugaCerinta(c2);
		
		// Tasks implements BurnDownItems
		Task t1 = new Task(); 
		t1.setDataStart(new Date());
		t1.setTimpEstimat(10);
		c1.adaugaTask(t1);
		
		Task t2 = new Task();
		t2.setDataStart(new Date());
		t2.setTimpEstimat(12);
		c1.adaugaTask(t2);
				
		
		Task t3 = new Task();
		t3.setDataStart(new Date());
		t3.setTimpEstimat(10);
		c2.adaugaTask(t3);
		
		Task t4 = new Task();
		t4.setDataStart(new Date());
		t4.setTimpEstimat(6);
		c2.adaugaTask(t4);		
		
		// TODO
		//ServiciuScrumBurning implements IServiciuScrumBurning
		IServiciuScrumBurning serviciuScrumBurning = new ServiciuScrumBurning();
		//		
		serviciuScrumBurning.getScrumBurnDown(t1);
		serviciuScrumBurning.getScrumBurnDown(s);
	}

}
