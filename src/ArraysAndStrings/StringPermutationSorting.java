 package ArraysAndStrings;

import java.util.Arrays;
import java.util.Scanner;

public class StringPermutationSorting {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter any two strings: ");
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();
 		scan.close();
		System.out.println("The strings are permutation of each other: " +permutation(str1, str2));
	}
	
	static String sort(String str){
		char[] str_content = str.toCharArray();
		Arrays.sort(str_content);
		return new String(str_content);
	}
	
	static boolean permutation(String str1, String str2){
		if(str1.length() != str2.length()){
			return false;
		}
		return sort(str1).equals(sort(str2));
	}

}
