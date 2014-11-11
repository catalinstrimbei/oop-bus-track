package cap3.ex3.org.app.scrum;

public class EntitateCuStare {
	private IStare stare1;
	private EStare stare2;
	
	public static final Integer NOUA = 1;
	public static final Integer IN_PROGRES = 2;
	public static final Integer COMPLETA = 3;
	public static final Integer INCHISA = 4;
	private Integer stare3;
	
	public IStare getStare1() {
		return stare1;
	}
	public void setStare1(IStare stare1) {
		this.stare1 = stare1;
	}
	public EStare getStare2() {
		return stare2;
	}
	public void setStare2(EStare stare2) {
		this.stare2 = stare2;
	}
	public Integer getStare3() {
		return stare3;
	}
	public void setStare3(Integer stare3) {
		this.stare3 = stare3;
	}
	
	
}
