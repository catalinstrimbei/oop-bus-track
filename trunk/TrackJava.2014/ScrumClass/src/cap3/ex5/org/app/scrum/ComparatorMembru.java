package cap3.ex5.org.app.scrum;

import java.util.Comparator;

public class ComparatorMembru implements Comparator<Membru>{

	@Override
	public int compare(Membru m1, Membru m2) {
		if (m1.equals(m2))
			return 0;
		//return m1.getNumePrenume().compareTo(m2.getNumePrenume());
		return m1.getIdMembru().compareTo(m2.getIdMembru());
	}

}
