package cap3.exemplu18_19_20_21_22;

import java.util.Date;
import java.util.List;

//----------------------------------------------------------------
//Ierarhia de moştenire 
//operaţie polimorformă addInregistrareContabila
//----------------------------------------------------------------
public interface IOperatieContabila {

	void addInregistrareContabila(InregistrareContabila inregistrare);

	Date getDataContabilizare();

	List<InregistrareContabila> getInregistrari();

	Double getSold();

	void removeInregistrareContabila(InregistrareContabila inregistrare);
}
