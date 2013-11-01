package cap2.exemplu7;

public interface ICont {

	String getCod();

	String getDenumire();

	void setDenumire(String denumire);

	Double getSold();

	void setSold(Double sold);

	Cont getContParinte();

	void setContParinte(Cont cont);

	String getCodContParinte();

}