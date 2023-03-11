import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Arrays;

public class UniqueCharacters {
	public static void main(String[] args) {
		List<String> values = new ArrayList<String>();
		values.add("Hello");
		values.add("world");

	
	List<String> distinct = values
					.stream()
					// Returns Stream<String>
					.map(s -> s.split(""))
					// Returns Stream<Stream[]>
					.flatMap(a -> Arrays.stream(a))
					// Converts Stream<Stream[]> to Stream<Stream<String>> and flattens to Stream<String> and returns
					.distinct()
					// Returns Stream<String>
					.collect(Collectors.toList());


	distinct
		.forEach(System.out::println);
	}
}


