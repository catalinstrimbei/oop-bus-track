package cap3.ex3.org.app.scrum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Test implementare interfete
 */

public class Test33 {

	public static void main(String[] args) throws Exception{
		IServiciuScrumBurning serviciuScrumBurning = new ServiciuScrumBurning();
		//
		
		CerintaFunctionala cerinta = new CerintaFunctionala(1, "Cerinta 2", "cerinta test mostenire", "basic", "use case generic");
		List<Task> taskuri = new ArrayList<>();

		Task task = new Task(); 
		task.setDataStart(new Date());
		task.setTimpEstimat(10);
		taskuri.add(task);
		
		task = new Task();
		task.setDataStart(new Date());
		task.setTimpEstimat(12);
		taskuri.add(task);
		
		cerinta.setTaskuri(taskuri);		
		
		// TODO
		serviciuScrumBurning.getScrumBurnDown(task);
		serviciuScrumBurning.getScrumBurnDown(cerinta);
	}

}
