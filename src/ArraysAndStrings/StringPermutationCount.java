package ArraysAndStrings;

import java.util.Scanner;

public class StringPermutationCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter any two strings: ");
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();
 		scan.close();
		System.out.println("The strings are permutation of each other: " +permutation(str1, str2));
	}
	
	static boolean permutation(String str1, String str2){
		if(str1.length() != str2.length()){
			return false;
		}
		
		int[] letters = new int[128];
		
		char[] str_array = str1.toCharArray();
		
		for(char c : str_array){
			letters[c]++;
			
		}
		
		for(int i=0;i<str2.length();i++){
			int c = (int)str2.charAt(i);
			System.out.println(c);
			letters[c]--;
			if(letters[c]<0){
				return false;
			}
		}
						
		return true;
	}

}
