public class FizzBuzz {
	public static void main(String[] args) {
	
	//1. factors of 3 and 5 - print FizzBuzz
	//2. factors of 3 print Fizz
	//3. factors of 5 print Buzz

	int[] array = {30, 5, 3 ,15, 9, 6 ,10, 20};

	for(int i : array) {
		if( i % 3 == 0 && i % 5 == 0)
			System.out.print("FizzBuzz");
		else if(i % 3 == 0) 
			System.out.print("Fizz");
		else if(i % 5 == 0) 
			System.out.print("Buzz");
		else 
			System.out.print("");
	}

	System.out.println();

	StringBuilder s = new StringBuilder();
	for(int i: array) {
		//1. If divisible by 3 - append Fizz
		if(i % 3 == 0)
			s.append("Fizz");
		//2. If divisible by 5 - append Buzz
		if(i % 5 == 0) 
			s.append("Buzz");
		//3 If not, append empty
	}

	System.out.println(s.toString());
	}
}
