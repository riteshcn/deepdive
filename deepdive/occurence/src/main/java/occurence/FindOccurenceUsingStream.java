package occurence;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FindOccurenceUsingStream {

	public static void main(String[] args) {

		String[] persons = { "Mukesh", "Vishal", "Amar", "Vishal", "Ritesh", "Vishal", "Ritesh", "Ritesh", "Amar", "Amar",
				"Amar" };

		class PersonEntry {
			String key;
			Integer counter;

			public PersonEntry(String key, int counter) {
				this.key = key;
				this.counter = counter;
			}

			public PersonEntry() {
			};

			public String getKey() {
				return key;
			}

			public void setKey(String key) {
				this.key = key;
			}

			public Integer getCounter() {
				return counter;
			}

			public void setCounter(Integer counter) {
				this.counter = counter;
			}
		}
		;
		Arrays.stream(persons)
				.map(e -> new PersonEntry(e, 1))  
				.collect(Collectors.toMap(PersonEntry::getKey, PersonEntry::getCounter, (x, y) -> x + 1, LinkedHashMap::new))
				.entrySet().stream().filter(e -> e.getValue() > 1).sorted(Comparator.comparing(Map.Entry::getValue))
				.max(Comparator.comparing(Map.Entry::getValue)).ifPresent(System.out::println);

	}

}
