import java.util.Set;
import java.util.LinkedHashSet;

public class CountDistinctInSubArray {
	public static void main(String[] args) {
		int[] integers = {1, 5, 5, 6, 7, 8, 9, 9, 10, 6, 6, 7, 6};
		int subArrayLength = 13;
		
		countDistinctInSubArray(integers, subArrayLength);

	}

	private static void countDistinctInSubArray(int[] integers, int subArrayLength) {
		
		if(integers.length < subArrayLength) {
			System.out.println("Invalid input: Please try again.");
			System.exit(0);
		}

		int subArrayLeftIndex = 0;

		int subArrayRightIndex = subArrayLeftIndex + (subArrayLength - 1);
		
		Set<Integer> elements = new LinkedHashSet<>(subArrayLength);	

		for(;subArrayLeftIndex <= (integers.length - subArrayLength);) {	
			int initialSubArrayLeftIndexValue = subArrayLeftIndex;
	
			while(subArrayLeftIndex <= subArrayRightIndex) {
				elements.add(integers[subArrayLeftIndex]);
				subArrayLeftIndex++;
			}

			System.out.println("Distinct elements in subArray: " +elements.size());
			System.out.println(elements);
			elements.clear();

			subArrayLeftIndex = initialSubArrayLeftIndexValue + 1;

			subArrayRightIndex = subArrayLeftIndex + (subArrayLength - 1);
		}
	}
}
