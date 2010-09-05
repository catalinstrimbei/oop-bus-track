package app.model.contabilitate.operatiuni;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2010-09-05T20:51:44.855+0300")
@StaticMetamodel(Plata.class)
public class Plata_ extends OperatiuneFinanciara_ {
	public static volatile SingularAttribute<Plata, Integer> nrOrdinPlata;
	public static volatile SingularAttribute<Plata, Date> dataPlata;
	public static volatile SingularAttribute<Plata, String> nrContBancarPlata;
}
