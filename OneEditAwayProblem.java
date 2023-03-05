import java.lang.Math;

public class OneEditAwayProblem {
	public static void main(String[] args) {
		String p = "tnkk";
		String q = "tank";

		System.out.println(isOneEditAway(q, p));
	}

	private static boolean isOneEditAway(String q, String p) {
		if(Math.abs(q.length() - p.length()) > 1) {
			return false;
		}
	
		String shorter = q.length() < p.length() ? q : p;
		String longer = q.length() < p.length() ? p : q;

		int is = 0;
		int il = 0;
		boolean marker = false;

		while(is < shorter.length() && il < longer.length()) {
			if(shorter.charAt(is) != longer.charAt(il)) {			
				if(marker) {
					return false;
				}
				marker = true;
				if(shorter.length() == longer.length()) {
					is++;
				}
			} else {
				is++;
			}
			il++;
		}

		return true;
	}
}
		
