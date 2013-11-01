package cap3.exemplu4;

import java.util.Date;

//----------------------------------------------------------------
//Subclase care vor moşteni
//----------------------------------------------------------------
public abstract class OperatiuneComerciala 
							extends OperatiuneContabila{
	private String partener;
	public String getPartener() {
      return partener;
	}
	public void setPartener(String partener) {
      this.partener = partener;
	}
	public OperatiuneComerciala() {}
	
	public OperatiuneComerciala(Integer idOperatiune, 
				Date dataContabilizare) {
      super(idOperatiune, dataContabilizare);
	}
	public OperatiuneComerciala(Integer idOperatiune, 
				Date dataContabilizare, String partener) {
      super(idOperatiune, dataContabilizare);
      this.partener = partener;
	}
}

