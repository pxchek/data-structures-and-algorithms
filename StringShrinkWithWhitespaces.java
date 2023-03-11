import java.lang.Character;

public class StringShrinkWithWhitespaces {
	public static void main(String[] args) {
		
		String str = "wwwwww fffff";

		StringBuilder result = new StringBuilder();

		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			count++;

			if(!Character.isWhitespace(str.charAt(i))) {
				if((i + 1) >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
					result.append(str.charAt(i)).append(count);
					count = 0;
				}
			} else {
				result.append(str.charAt(i));
				count = 0;
			}
		}
		
		System.out.println(result);
	}
}
