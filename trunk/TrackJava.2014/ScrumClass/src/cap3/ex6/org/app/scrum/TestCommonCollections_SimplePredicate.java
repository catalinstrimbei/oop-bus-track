package cap3.ex6.org.app.scrum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

public class TestCommonCollections_SimplePredicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> mixedup = Arrays.asList("A", "0", "B", "C", "1", "D", "F",
				"3");
		Collection numbersOnlyList = CollectionUtils.predicatedCollection(
				new ArrayList(), new Predicate() {
					public boolean evaluate(Object o) {
						try {
							Integer.valueOf((String) o);
							return true;
						} catch (NumberFormatException e) {
							return false;
						}
					}
				});
		for (String s : mixedup) {
			try {
				numbersOnlyList.add(s);
			} catch (IllegalArgumentException e) {
				System.out.println("I love CollectionUtils!");
			}
		}
		System.out.println("\nResults of the predicatedCollection List:");
		CollectionUtils.forAllDo(numbersOnlyList, PrintIt.getInstance());
	}

}

class PrintIt implements Closure {
	// This class implements a Singleton Pattern
	private static PrintIt ourInstance = new PrintIt();

	/**
	 * Get a singleton instance of PrintIt
	 */
	public static PrintIt getInstance() {
		return ourInstance;
	}

	private PrintIt() // This is a singleton, dont change this!
	{
	}

	public void execute(Object o) {
		System.out.println(o.toString());
	}
}