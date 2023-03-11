import java.util.Stack;
import java.lang.Character;

public class SmallestNumber {
	public static void main(String[] args) {
		String nr = "4514327";
		int k = 4;

		int i = 0;
		
		Stack<Character> stack = new Stack<>();
		
		while(i < nr.length()) {
			
			while(k > 0 && !stack.isEmpty() && stack.peek() > nr.charAt(i)) {
				
				stack.pop();
				k--;
			
			}

			stack.push(nr.charAt(i));
			i++;
		}
	
		while(k > 0) {
			
			stack.pop();
			k--;
		}
		
		System.out.println("The number is: " + stack);
	}
}


		
		
