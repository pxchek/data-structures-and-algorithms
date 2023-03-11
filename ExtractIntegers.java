import java.lang.Character;
import java.util.List;
import java.util.ArrayList;

public class ExtractIntegers {
	public static void main(String[] args) {

	String s = "cv dd k k 2321 2 11 k4k2 66 4d";

	//2. Build and example
		//a. 34 1sda 23 aa (34, 23)
		//b. df 1 f 34 1 (34)
		//c. cv dd k k 2321 2 11 k4k2 66 4d (4,2321,2,11,4,2,66,4)
		   //0123456789
			     //0123456789
				       //0123456789		
		
	List<Integer> result = new ArrayList<>();
	StringBuilder temp = new StringBuilder();
		
	for(int i = 0; i < s.length(); i++) {
		char ch = s.charAt(i);
		if(Character.isDigit(ch)) {
			temp.append(ch);
		} else {
			if(temp.length() > 0) {
				result.add(Integer.valueOf(temp.toString()));
				temp.delete(0, temp.length());
				}
			}
		}
	
	result
		.stream()
		.forEach(System.out::println);
	}

}	


	 
