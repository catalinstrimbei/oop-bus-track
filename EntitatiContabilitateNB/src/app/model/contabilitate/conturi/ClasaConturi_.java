package app.model.contabilitate.conturi;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2010-09-05T20:51:44.406+0300")
@StaticMetamodel(ClasaConturi.class)
public class ClasaConturi_ {
	public static volatile SingularAttribute<ClasaConturi, String> cod;
	public static volatile SingularAttribute<ClasaConturi, String> denumire;
	public static volatile SingularAttribute<ClasaConturi, ClasaConturi> clasaParinte;
	public static volatile ListAttribute<ClasaConturi, Cont> conturi;
}
