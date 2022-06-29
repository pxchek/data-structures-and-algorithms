import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

//Time complexity - O(n)
//Space complexity - O(n) - The size of the Map increases with increase in size of both the nuts and bolts
public class NutsAndBolts {
	public static void main(String[] args) {		
		char[] nuts = { '$', '%', '&', 'x', '@' };
		char[] bolts = { '%', '@', 'x', '$', '&' };
		
		// Iterate over nuts and store (nuts as key and position as value)
		// Time complexity - O(n)
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < nuts.length; i++) {
			map.put(nuts[i], i);
		}

			
		// For each bolt search the nut
		//Time complexity - O(n)
		for(int i =0; i < bolts.length; i++) {
			char bolt = bolts[i];
			if(map.containsKey(bolt)) { // Match found
				nuts[i] = bolt;
			} else {			// Match not found
				System.out.println("Bolt "+ bolt + " has not nut.");
			}
		}

		System.out.println("Nuts: " + Arrays.toString(nuts));
		System.out.println("Bolts: " + Arrays.toString(bolts));
	}
}

