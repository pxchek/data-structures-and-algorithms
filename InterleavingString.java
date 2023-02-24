import java.util.HashMap;
import java.util.Map;

public class InterleavingString {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println("Interleaved String:");
        System.out.println(isInterleaved(s1, s2, s3));
    }

    private static boolean isInterleaved(String s1, String s2, String s3) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s3.toCharArray()) {
		if(!map.containsKey(c)) {
            		map.computeIfAbsent(c, k -> 1);
	    	} else {
            		map.computeIfPresent(c, (k, v) -> v + 1);
		}
        }

	System.out.println("After s3 :"  + map);
	for(Character c : s1.toCharArray()) {
		map.computeIfPresent(c, (k, v) -> v - 1);
	}


	System.out.println("After s1 :" + map); 
	for(Character c: s2.toCharArray()) {
		map.computeIfPresent(c, (k, v) -> v - 1);
        }

	System.out.println("After s2 :" + map);
	for(Integer i : map.values()) {
		if(i > 0 || i< 0) {
			return false;
		}
	}
	return true;
    }
}
