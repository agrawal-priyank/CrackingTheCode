package Hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class LongestWord {

    public static void main(String[] args){
        String[] arr = {"a", "b", "c", "d", "ab", "cd", "abcd"};
        LongestWord lW = new LongestWord();
        System.out.println(lW.getLongestWord(arr));
    }

    public String getLongestWord(String[] arr){
        if(arr == null || arr.length < 3){
            return null;
        }
        Arrays.sort(arr, new LengthComparator());
        HashSet<String> set = new HashSet<String>();
        for(String s : arr){
            set.add(s);
        }
        for(String s : arr){
            for(int i = 1; i < s.length(); i++){
                String left = s.substring(0, i);
                String right = s.substring(i);
                if(set.contains(left) && set.contains(right)){
                    return s;
                }
            }
        }
        return null;
    }

    private class LengthComparator implements Comparator<String> {
        public int compare(String s1, String s2){
            if(s1.length() > s2.length()){
                return -1;
            } else if(s1.length() < s2.length()){
                return 1;
            } else{
                return 0;
            }
        }
    }

}