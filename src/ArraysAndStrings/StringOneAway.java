package ArraysAndStrings;

import java.util.Scanner;

public class StringOneAway {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String first = scan.nextLine();
		String second = scan.nextLine();
		scan.close();
		System.out.print("The strings are one or zero edit away: "+oneEditAway2(first, second));
	}
	
	//Solution 1 begins	
	static boolean oneEditAway(String first, String second){
		if(first.length() == second.length()){
			return oneEditReplace(first, second);
		}
		else if(first.length() + 1 == second.length()){
			return oneEditInsert(first, second);
		}
		else if (first.length() - 1 == second.length()){
			return oneEditInsert(second, first);
		}
		return false;
	}
	
	static boolean oneEditReplace(String s1, String s2){
		boolean foundDifference = false;
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i) != s2.charAt(i)){
				if(foundDifference){
					return false;
				}
				foundDifference = true;
			}
		}
		return true;
	}
	
	static boolean oneEditInsert(String s1, String s2){
		int index1 = 0;
		int index2 = 0;
		while(index2 < s2.length() && index1 < s1.length()){
			if(s1.charAt(index1) != s2.charAt(index2)){
				if(index1 != index2){
					return false;
				}
				index2++;
			}
			else{
				index1++;
				index2++;
			}
		}
		return true;
	}
	//Solution 1 ends
	
	//Solution 2 begins
	static boolean oneEditAway2(String first, String second){
		if(Math.abs(first.length() - second.length()) > 1){
			return false;
		}
		
		String s1 = first.length() < second.length() ? first : second;
		String s2 = second.length() < first.length() ? second : first;
		
		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;

		while(index2 < s2.length() && index1 < s1.length()){
			if(s1.charAt(index1) != s2.charAt(index2)){
				if(foundDifference){
					return false;
				}
				foundDifference = true;
				if(s1.length() == s2.length()){
					index1++;
				}				
			}
			else{
				index1++;
			}
			index2++;
		}
		return true;
		
	}
	//Solution 2 ends 

}
