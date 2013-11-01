package cap3.exemplu18_19_20_21_22;

//public class TestCommonCollections_PredicatesSQLSample {}
import java.util.*;
import org.apache.commons.collections.*;
import org.apache.commons.collections.map.*;

//import com.blogspot.apachecommonstipsandtricks.*;  
public class TestCommonCollections_PredicatesSQLSample {
	public static void main(String[] args) {
		List<DTO> list = Arrays.asList(
				new DTO(1, "Bob", Gender.Male, State.WI), new DTO(2, "Larry",
						Gender.Male, State.WI), new DTO(3, "Bill", Gender.Male,
						State.WI), new DTO(4, "Sue", Gender.Female, State.AZ),
				new DTO(3, "Bill", Gender.Male, State.WI), new DTO(4, "Sue",
						Gender.Female, State.AZ), new DTO(5, "Joe",
						Gender.Male, State.AZ), new DTO(6, "Zoe",
						Gender.Female, State.MI));
		Predicate sqlOrQueryPredicate = PredicateUtils
				.anyPredicate(new Predicate[] { new Predicate() {
					public boolean evaluate(Object o) {
						return State.WI.equals(((DTO) o).getState());
					}
				}, new Predicate() {
					public boolean evaluate(Object o) {
						return Gender.Female.equals(((DTO) o).getGender());
					}
				} });
		Predicate sqlAndQueryPredicate = PredicateUtils
				.allPredicate(new Predicate[] { new Predicate() {
					public boolean evaluate(Object o) {
						return State.AZ.equals(((DTO) o).getState());
					}
				}, new Predicate() {
					public boolean evaluate(Object o) {
						return Gender.Male.equals(((DTO) o).getGender());
					}
				} });
		Predicate likeNameStartsWithB = new Predicate() {
			public boolean evaluate(Object o) {
				return ((DTO) o).getName().startsWith("B");
			}
		};

		Collection aList = CollectionUtils.select(list, sqlOrQueryPredicate);
		Collection bList = CollectionUtils.select(list,
				PredicateUtils.notPredicate(sqlOrQueryPredicate));
		Collection cList = CollectionUtils.select(list, sqlAndQueryPredicate);
		Collection dList = CollectionUtils
				.select(list,
						PredicateUtils.allPredicate(new Predicate[] {
								PredicateUtils.uniquePredicate(),
								sqlOrQueryPredicate }));
		Collection eList = CollectionUtils
				.select(list,
						PredicateUtils.allPredicate(new Predicate[] {
								PredicateUtils.uniquePredicate(),
								likeNameStartsWithB }));
		Collection fList = CollectionUtils.select(list,
				PredicateUtils.uniquePredicate());

		Map aGroupByStateMap = TransformedMap.decorate(new MultiValueMap(),
				new Transformer() {
					public Object transform(Object o) {
						return ((DTO) o).getState();
					}
				}, TransformerUtils.nopTransformer());
		for (Object o : fList) {
			aGroupByStateMap.put(o, o);
		}

		System.out.println("\nAll the people :\nselect * from list");
		CollectionUtils.forAllDo(list, PrintIt.getInstance());
		System.out
				.println("\nAll the people in Wisconsin OR Female :\nselect * from list where ( state = WI or gender = female );");
		CollectionUtils.forAllDo(aList, PrintIt.getInstance());
		System.out
				.println("\nAll the people NOT ( Wisconsin OR Female ) :\nselect * from list where ! ( state = WI or gender = female );");
		CollectionUtils.forAllDo(bList, PrintIt.getInstance());
		System.out
				.println("\nAll the people in Arizona AND Male :\nselect * from list where ( state = AZ and gender = male );");
		CollectionUtils.forAllDo(cList, PrintIt.getInstance());
		System.out
				.println("\nAll the distinct people in Arizona AND Male :\nselect distinct * from list where ( state = WI or gender = female );");
		CollectionUtils.forAllDo(dList, PrintIt.getInstance());
		System.out
				.println("\nAll the distinc people with the name that starts with B :\nselect distinct * from list where name like \"B%\";");
		CollectionUtils.forAllDo(eList, PrintIt.getInstance());
		System.out
				.println("\nAll the distinct people grouped by state :\nselect distinct * from list group by state;");
		Set states = aGroupByStateMap.keySet();
		for (Object state : states) {
			System.out.println(((State) state).getFullyQualifiedName());
			CollectionUtils.forAllDo((Collection) aGroupByStateMap.get(state),
					PrintIt.getInstance());
		}
	}
}

/*------------------------------------------------------------------------*/
class DTO {
	private int id;
	private String name;
	private Gender gender;
	private State state;

	public DTO(int id, String name, Gender gender, State state) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "com.blogspot.apachecommonstipsandtricks.DTO{id=" + id
				+ ", name='" + name + '\'' + ", gender=" + gender + ", state="
				+ state + '}';
	}
}

/*------------------------------------------------------------------------*/
enum Gender {
	Male, Female
}

enum State {
	AL("ALABAMA"), AK("ALASKA"), AS("AMERICAN SAMOA"), AZ("ARIZONA "), AR(
			"ARKANSAS"), CA("CALIFORNIA "), CO("COLORADO "), CT("CONNECTICUT"), DE(
			"DELAWARE"), DC("DISTRICT OF COLUMBIA"), FM(
			"FEDERATED STATES OF MICRONESIA"), FL("FLORIDA"), GA("GEORGIA"), GU(
			"GUAM "), HI("HAWAII"), ID("IDAHO"), IL("ILLINOIS"), IN("INDIANA"), IA(
			"IOWA"), KS("KANSAS"), KY("KENTUCKY"), LA("LOUISIANA"), ME("MAINE"), MH(
			"MARSHALL ISLANDS"), MD("MARYLAND"), MA("MASSACHUSETTS"), MI(
			"MICHIGAN"), MN("MINNESOTA"), MS("MISSISSIPPI"), MO("MISSOURI"), MT(
			"MONTANA"), NE("NEBRASKA"), NV("NEVADA"), NH("NEW HAMPSHIRE"), NJ(
			"NEW JERSEY"), NM("NEW MEXICO"), NY("NEW YORK"), NC(
			"NORTH CAROLINA"), ND("NORTH DAKOTA"), MP(
			"NORTHERN MARIANA ISLANDS"), OH("OHIO"), OK("OKLAHOMA"), OR(
			"OREGON"), PW("PALAU"), PA("PENNSYLVANIA"), PR("PUERTO RICO"), RI(
			"RHODE ISLAND"), SC("SOUTH CAROLINA"), SD("SOUTH DAKOTA"), TN(
			"TENNESSEE"), TX("TEXAS"), UT("UTAH"), VT("VERMONT"), VI(
			"VIRGIN ISLANDS"), VA("VIRGINIA "), WA("WASHINGTON"), WV(
			"WEST VIRGINIA"), WI("WISCONSIN"), WY("WYOMING");
	private String fullyQualifiedName;

	State(String fullyQualifiedName) {
		this.fullyQualifiedName = fullyQualifiedName;
	}

	public String getFullyQualifiedName() {
		return fullyQualifiedName;
	}
}
/*------------------------------------------------------------------------*/