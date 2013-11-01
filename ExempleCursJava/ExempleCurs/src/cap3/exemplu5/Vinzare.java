package cap3.exemplu5;

import java.util.Date;

//----------------------------------------------------------------
public class Vinzare extends OperatiuneComerciala{
	private Integer nrFacturaEmisa;
	private Date dataFacturaEmisa;

	public Vinzare() {
	}
	public Vinzare(Integer idOperatiune, Date dataContabilizare, 
							String partener) {
        super(idOperatiune, dataContabilizare, partener);
	}
	public Vinzare(Integer idOperatiune, 
				Date dataContabilizare, String partener,
				Integer nrFacturaEmisa, Date dataFacturaEmisa) {
        super(idOperatiune, dataContabilizare, partener);
        this.nrFacturaEmisa = nrFacturaEmisa;
        this.dataFacturaEmisa = dataFacturaEmisa;
	}
	public Date getDataFacturaEmisa() {
        return dataFacturaEmisa;
	}
	public void setDataFacturaEmisa(Date dataFacturaEmisa) {
        this.dataFacturaEmisa = dataFacturaEmisa;
	}
	public Integer getNrFacturaEmisa() {
        return nrFacturaEmisa;
	}
	public void setNrFacturaEmisa(Integer nrFacturaEmisa) {
        this.nrFacturaEmisa = nrFacturaEmisa;
	}
	
	// suprascriere
	@Override
	public void addInregistrareContabila(
				InregistrareContabila inregistrare){

        if (inregistrare instanceof InregistrareDebit &&
                ! inregistrare.getCont().getCod().startsWith("4"))
            throw new RuntimeException("Inregistrare incompatibila cu operatiune vinzare !");

        super.addInregistrareContabila(inregistrare);
	}
	
}

