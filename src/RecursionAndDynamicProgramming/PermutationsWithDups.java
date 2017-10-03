package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationsWithDups {

    public static void main(String[] args){
        String str = "aab";
        PermutationsWithDups pWD = new PermutationsWithDups();
        ArrayList<String> perms = pWD.getPerms(str);
        for(String perm : perms){
            System.out.println(perm);
        }
    }

    public ArrayList<String> getPerms(String str){
        ArrayList<String> result = new ArrayList<String>();
        HashMap<Character, Integer> map = frequencyTable(str);
        getPerms(map, "", str.length(), result);
        return result;
    }

    public void getPerms(HashMap<Character, Integer> map, String prefix, int remaining,
                         ArrayList<String> result){
        if(remaining == 0){
            result.add(prefix);
            return;
        }
        for(Character c : map.keySet()){
            int count = map.get(c);
            if(count > 0){
                map.put(c, count - 1);
                getPerms(map, prefix + c, remaining - 1, result);
                map.put(c, count);
            }
        }

    }

    private HashMap<Character, Integer> frequencyTable(String str){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else{
                map.put(c, 1);
            }
        }
        return map;
    }

}