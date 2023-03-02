import java.util.Stack;

public class CurlyBracesMatch {
	public static void main(String[] args) {	
		String curlyBraces = "[[]]{}[{";
		System.out.println("Match: "+ match(curlyBraces));
	}

	private static boolean match(String curlyBraces) {
		
		//1. Create a stack to maintain state of the braces
		Stack<Character> stack = new Stack<Character>();	
		
		//2. Convert the curlBraces into an array accessible by char
		char[] chArray = curlyBraces.toCharArray();
		
		//3. Loop over the array and push - '{', '['
		for(int i = 0; i < chArray.length; i++) {
			if(chArray[i] == '{' || chArray[i] == '[') {
				stack.push(chArray[i]);
			 //4. Pop when '}', ']' from the stack; If the stack is empty break and return false to indicate the no match.
			} else if(chArray[i] == '}' || chArray[i] == ']') {
				if(stack.isEmpty()) {
					return false;
				}

				stack.pop();
			} else {
				System.out.println("Invalid input so exit with program.");
				return false; 
			}
		}
		
		//5. Return true if the stack is empty to indicate all braces match; false otherswise and no match found.
		return stack.isEmpty();			
	}
}


