package ArraysAndStrings;

import java.util.Scanner;

public class UniqueString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter any string: ");
		String str = scan.nextLine();
		scan.close();
		System.out.println("The string is unique: " +isUniqueChars2(str));		
	}
	
	static boolean isUniqueChars(String str){
		if(str.length() > 128){
			return false;
		}
		else{
			boolean[] char_set = new boolean[128];
			for(int i=0;i<str.length();i++){
				int val = str.charAt(i);				
				if(char_set[val]){
					return false;
				}
				char_set[val] = true;			
			}			
		}
		return true;
	}
	
	static boolean isUniqueChars2(String str){
		int checker = 0;
		for(int i=0;i<str.length();i++){
			int val = str.charAt(i) - 'a'; //assuming only lower-case a-z used in the string	
			if((checker &  (1 << val)) > 0){
				return false;
			}
			checker |= (1 << val);			
		}
		return true;
	}

}
