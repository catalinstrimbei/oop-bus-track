package cap2.exemplu6;

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