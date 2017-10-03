package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class PermutationsWithoutDups3 {

    public static void main(String[] args){
        String str = "abc";
        PermutationsWithoutDups3 pWD = new PermutationsWithoutDups3();
        ArrayList<String> perms = pWD.getPerms(str);
        for(String perm : perms){
            System.out.println(perm);
        }
    }

    public ArrayList<String> getPerms(String str){
        ArrayList<String> result = new ArrayList<String>();
        getPerms("", str, result);
        return result;
    }

    private void getPerms(String prefix, String remainder, ArrayList<String> result){
        if(remainder.length() == 0){
            result.add(prefix);
        }
        for(int i = 0; i < remainder.length(); i++){
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1);
            char c = remainder.charAt(i);
            getPerms(prefix + c, before + after, result);
        }
    }

}