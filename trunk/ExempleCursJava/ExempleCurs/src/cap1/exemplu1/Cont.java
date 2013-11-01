package cap1.exemplu1;

public class Cont {
    String cod;
    String denumire;

     // membru static
    static String numeOrganizatie;

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		String v;
		this.cod = cod;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public static String getNumeOrganizatie() {
		return numeOrganizatie;
	}

	public static void setNumeOrganizatie(String numeOrganizatie) {
		Cont.numeOrganizatie = numeOrganizatie;
	}

	public Cont(String c, String den) {
		this.cod = c;
		this.denumire = den;
	}

	public Cont() {
		
	}
	
}
