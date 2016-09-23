package ArraysAndStrings;

import java.util.Scanner;

public class StringCompression {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		System.out.println(stringCompressed(str));
		System.out.println(stringCompressedWithBuilder(str));
		System.out.println(stringCompressedWithCheck(str));
	}
	
	//Solution 1 begins
	static String stringCompressed(String str){
		String compressedString = "";
		int count = 0;
		for(int i=0;i<str.length();i++){
			count++;
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
				compressedString += "" + str.charAt(i) + count;
				count = 0;
			}
		}
		return compressedString.length() < str.length() ? compressedString : str ;
	}
	//Solution 1 ends

	//Solution 2 begins
	static String stringCompressedWithBuilder(String str){
		StringBuilder compressed = new StringBuilder();
		int count =0;
		for(int i=0;i<str.length();i++){
			count++;
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
				compressed.append(str.charAt(i));
				compressed.append(count);
				count = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}
	//Solution 2 ends
	
	//Solution 3 begins
	static String stringCompressedWithCheck(String str){
		int finalLength = countCompression(str);
		if(finalLength >= str.length()){
			return str;
		}
		
		StringBuilder compressedString = new StringBuilder(finalLength);
		int count = 0;
		for(int i=0;i<str.length();i++){
			count++;
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
				compressedString.append(str.charAt(i));
				compressedString.append(count);
				count = 0;
			}
		}
		return compressedString.toString();		
	}
	
	static int countCompression(String str){
		int compressedLength = 0;
		int count = 0;
		for(int i=0;i<str.length();i++){
			count++;
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){				
				compressedLength += 1 + String.valueOf(count).length();
				count = 0;
			}
		}
		return compressedLength;				
	}
	//Solution 3 ends
}
