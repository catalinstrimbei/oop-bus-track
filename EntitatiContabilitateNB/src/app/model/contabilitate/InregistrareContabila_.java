package app.model.contabilitate;

import app.model.contabilitate.conturi.Cont;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2010-09-05T20:51:44.602+0300")
@StaticMetamodel(InregistrareContabila.class)
public class InregistrareContabila_ {
	public static volatile SingularAttribute<InregistrareContabila, Integer> id;
	public static volatile SingularAttribute<InregistrareContabila, Integer> nrOrdine;
	public static volatile SingularAttribute<InregistrareContabila, Double> suma;
	public static volatile SingularAttribute<InregistrareContabila, Cont> cont;
	public static volatile SingularAttribute<InregistrareContabila, OperatiuneContabila> operatiune;
}
