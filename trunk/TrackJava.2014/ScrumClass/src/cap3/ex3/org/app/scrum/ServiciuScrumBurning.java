package cap3.ex3.org.app.scrum;

import java.util.Date;
import java.util.Map;

public class ServiciuScrumBurning implements IServiciuScrumBurning {

	@Override
	public Integer getScrumBurnDown(BurnDownItem item) throws Exception {
		System.out.println("Compute scrum burndown for: " + item);
		return null;
	}

	@Override
	public Integer getScrumBurnUp(BurnUpItem item) {
		// TODO Auto-generated method stub
		return null;
	}

}
