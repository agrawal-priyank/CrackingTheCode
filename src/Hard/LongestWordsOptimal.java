package Hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LongestWordsOptimal {

    public static void main(String[] args){
        String[] arr = {"a", "b", "c", "d", "ab", "cd", "abcdd"};
        LongestWordsOptimal lWO = new LongestWordsOptimal();
        System.out.println(lWO.getLongestWord(arr));
    }

    public String getLongestWord(String[] arr){
        if(arr == null || arr.length < 3){
            return null;
        }
        Arrays.sort(arr, new LengthComparator());
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        for(String s : arr){
            map.put(s, true);
        }
        for(String s : arr){
            if(canBuildWord(s, true, map)){
                return s;
            }
        }
        return null;
    }

    private boolean canBuildWord(String s, boolean isOriginalWord, HashMap<String, Boolean> map){
        if(map.containsKey(s) && !isOriginalWord){
            return map.get(s);
        }
        for(int i = 1; i < s.length(); i++){
            String left = s.substring(0, i);
            String right = s.substring(i);
            if(map.containsKey(left) && map.get(left) == true &&
                    canBuildWord(right, false, map)){
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

    private class LengthComparator implements Comparator<String>{
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