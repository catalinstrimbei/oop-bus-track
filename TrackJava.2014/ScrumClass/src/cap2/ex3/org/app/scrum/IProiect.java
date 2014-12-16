package cap2.ex3.org.app.scrum;

import java.util.Date;
import java.util.List;

public interface IProiect {
	Integer getReleaseCount();

	public abstract void setReleases(List<Release> releases);

	public abstract List<Release> getReleases();

	public abstract void setDataStart(Date dataStart);

	public abstract Date getDataStart();

	public abstract void setNumeProiect(String numeProiect);

	public abstract String getNumeProiect();

	public abstract void setNrProiect(Integer nrProiect);

	public abstract Integer getNrProiect();
}