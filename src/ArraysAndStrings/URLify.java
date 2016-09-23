package ArraysAndStrings;

import java.util.Scanner;

public class URLify {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String string = scan.nextLine();
		scan.close();
		int length = string.length();
	
		char[] str = string.toCharArray();
		
		System.out.println("The new string is: "+replaceSpaces(str, length));
	}
	
	static String replaceSpaces(char[] str, int length){
		int spaceCount = 0, newLength, i;
		for(i=0; i<length; i++){
			if(str[i] == ' '){
				spaceCount++;
			}
		}
		
		newLength = length + spaceCount*2;
		char[] newStr = new char[newLength];
		for(i=length-1;i>=0;i--){
			if(str[i] == ' '){
				newStr[newLength - 1] ='0';
				newStr[newLength - 2] ='2';
				newStr[newLength - 3] ='%';
				newLength = newLength - 3;
			}
			else{
				newStr[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		return String.valueOf(newStr);
	}

}
