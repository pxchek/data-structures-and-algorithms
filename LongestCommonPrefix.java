public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] texts = {
				"abc",
				"abcd",
				"abcde",
				"ab",
				"abcd",
				"abcdef"
		};
		System.out.println(longestCommonPrefix(texts));
	}

	private static String longestCommonPrefix(final String[] texts) {
		int maxPrefixLength = texts[0].length();
		for(int i = 0; i < maxPrefixLength; i++) {	
			char ch = texts[0].charAt(i);
			for(int j = 1; j < texts.length; j++) {
				String s = texts[j];
				if( i >= s.length() || s.charAt(i) != ch) {	
					System.out.println("Length of longest common prefix: " +i);
					return texts[0].substring(0,i);
 				}
			}
		}
		return texts[0];
	}
}


