import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.HashSet;

public class LongestConsecutive {
	public static void main(String[] args) {
		int[] sequence = {4, 2, 9, 5, 12, 6, 8};
		Set<Integer> sequenceSet = IntStream.of(sequence)
						.boxed()
						.collect(Collectors.toCollection(() -> new HashSet<>()));
		
		int longestSequence = 1;
		for(int elem : sequence) {		
			if(!sequenceSet.contains(elem - 1)) {
				int sequenceLength = 1;
				while(sequenceSet.contains(elem + sequenceLength)) {
					sequenceLength++;
				}
			longestSequence = Math.max(longestSequence, sequenceLength);
			}
		}
		System.out.println("Longest Sequence: " + longestSequence);
	}
}
		
