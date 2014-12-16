package cap3.ex3.org.app.scrum;

public interface IServiciuScrumBurning {
	Integer getScrumBurnDown(BurnDownItem item) throws Exception ; // delta zile intarziere/avans 
	Integer getScrumBurnUp(BurnUpItem item) throws Exception ; // delta efort suplimentar/redus
}