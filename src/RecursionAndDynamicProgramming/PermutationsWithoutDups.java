package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class PermutationsWithoutDups {

    public static void main(String[] args){
        String str = "abc";
        PermutationsWithoutDups pWD = new PermutationsWithoutDups();
        ArrayList<String> perms = pWD.getPerms(str);
        for(String perm : perms){
            System.out.println(perm);
        }
    }

    public ArrayList<String> getPerms(String str){
        if(str == null){
            return null;
        }

        ArrayList<String> permutations = new ArrayList<String>();
        if(str.length() == 0){
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String remainder = str.substring(1);
        ArrayList<String> words = getPerms(remainder);
        for(String word : words){
            for(int i = 0; i <= word.length(); i++){
                String s = insertCharAt(word, first, i);
                permutations.add(s);
            }
        }
        return permutations;
    }

    private String insertCharAt(String word, char c, int i){
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

}