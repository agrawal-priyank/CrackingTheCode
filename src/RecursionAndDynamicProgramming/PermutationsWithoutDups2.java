package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class PermutationsWithoutDups2 {

    public static void main(String[] args){
        String str = "abc";
        PermutationsWithoutDups2 pWD = new PermutationsWithoutDups2();
        ArrayList<String> perms = pWD.getPerms(str);
        for(String perm : perms){
            System.out.println(perm);
        }
    }

    public ArrayList<String> getPerms(String str){
        if(str == null){
            return null;
        }
        int len = str.length();
        ArrayList<String> permutations = new ArrayList<String>();
        if(len == 0){
            permutations.add("");
            return permutations;
        }
        for(int i = 0; i < len; i++){
            String before = str.substring(0, i);
            String after = str.substring(i + 1);
            ArrayList<String> partials = getPerms(before + after);
            for(String partial : partials){
                permutations.add(str.charAt(i) + partial);
            }
        }
        return permutations;
    }

}