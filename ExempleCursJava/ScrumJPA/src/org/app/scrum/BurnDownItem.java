package org.app.scrum;

import java.util.Date;
import java.util.Map;

public interface BurnDownItem extends ScrumBurnItem{
	Map<Date, Integer> getBurnDownRecords();
	Integer getTimpEstimat();
	Integer getTimpRamas();
}
