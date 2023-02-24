public class RemoveAllOccurences {
	public static void main(String... args) {
		String s = "axxxxyyyyb";
                String part = "xy";

		while(s.indexOf(part) != -1) {
			s = s.replaceFirst(part, "");
		}

		System.out.println(s);
	}
}
