package app.model.contabilitate;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2010-09-05T20:51:44.811+0300")
@StaticMetamodel(OperatiuneContabila.class)
public class OperatiuneContabila_ {
	public static volatile SingularAttribute<OperatiuneContabila, Integer> idOperatiune;
	public static volatile SingularAttribute<OperatiuneContabila, Date> dataContabilizare;
	public static volatile MapAttribute<OperatiuneContabila, Integer, InregistrareContabila> inregistrari;
}
