package SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;

public class GroupAnagrams {

    public static void main(String[] args){
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Arrays.sort(arr, new AnagramComparator());
        System.out.println(Arrays.toString(arr));
    }

    public static class AnagramComparator implements Comparator<String>{
        public String sortChars(String s){
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }

        public int compare(String s1, String s2){
            return sortChars(s1).compareTo(sortChars(s2));
        }
    }
    
}