package org.app.scrum;

public interface IServiciuScrumBurning {
	Integer getScrumBurnDown(BurnDownItem item) throws Exception ; // delta zile intarziere/avans 
	Integer getScrumBurnUp(BurnUpItem item) throws Exception ; // delta efort suplimentar/redus
}