package app.model.contabilitate.conturi;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2010-09-05T20:51:44.565+0300")
@StaticMetamodel(Cont.class)
public class Cont_ {
	public static volatile SingularAttribute<Cont, String> cod;
	public static volatile SingularAttribute<Cont, String> denumire;
	public static volatile SingularAttribute<Cont, ClasaConturi> subClasaCont;
	public static volatile SingularAttribute<Cont, Cont> contParinte;
	public static volatile SingularAttribute<Cont, Boolean> sintetic;
}
