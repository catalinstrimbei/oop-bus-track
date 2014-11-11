package cap3.ex3.org.app.scrum;

import java.util.Date;
import java.util.Map;

public class ServiciuScrumBurning implements IServiciuScrumBurning {

	@Override
	public Integer getScrumBurnDown(BurnDownItem item) throws Exception {
		Map<Date, Integer> burnDownItemRecords = item.getBurnDownRecords();
		Integer agregareTimpRamas = 0;
		Date primaZiLucrata = null;
		Date ultimaZiLucrata = null;
		for(Date d: burnDownItemRecords.keySet()){
			agregareTimpRamas += burnDownItemRecords.get(d);
			if (primaZiLucrata == null || d.getTime() < primaZiLucrata.getTime())
				primaZiLucrata = d;
			if (ultimaZiLucrata == null || d.getTime() > ultimaZiLucrata.getTime())
				ultimaZiLucrata = d;
			
		}
		// timpul ramas este in ore
		Long ultimaZiEstimataTime = primaZiLucrata.getTime() + item.getTimpRamas() * (1000 * 60 * 60);
		Date ultimaZiEstimata = new Date(ultimaZiEstimataTime);
		
		if (primaZiLucrata == null || ultimaZiLucrata == null)
			throw new Exception("Imposibilitate de calcul!");
		
		// 1. Estimare numar zile lucrate 
		Long nrZileLucrate = (ultimaZiLucrata.getTime() - primaZiLucrata.getTime())/(1000 * 60 * 60 * 24);
		
		// 2. Estimare medie zilnica evolutie timp ramas - in ore
		Long medieZilnicaEvolutie = agregareTimpRamas / nrZileLucrate;
		
		// 3. Calcul numar zile finalizare: raport: timp ramas/medie zilnica evolutie
		Long nrZileBurnDown = item.getTimpRamas()/medieZilnicaEvolutie;
		
		// 4. Calcul delta: numar zile finalizare - numar zile estimat 
		Long delta =  item.getTimpEstimat()/24 - nrZileBurnDown;
		
		// se va intarzia cu delta zile (+)
		// se va devansa cu delta zile (-)		
		return delta.intValue();
	}

	@Override
	public Integer getScrumBurnUp(BurnUpItem item) {
		// TODO Auto-generated method stub
		return null;
	}

}
