package RecursionAndDynamicProgramming;

import java.util.HashSet;

public class Parentheses {

    public static void main(String[] args){
        int n = 3;
        Parentheses p = new Parentheses();
        HashSet<String> set = p.generateParens(n);
        for(String s : set){
            System.out.println(s);
        }
    }

    public HashSet<String> generateParens(int remaining){
        HashSet<String> set = new HashSet<String>();
        if(remaining == 0){
            set.add("");
        } else{
            HashSet<String> prevSet = generateParens(remaining - 1);
            for(String str : prevSet){
                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(i) == '('){
                        String s = insertParensInside(str, i);
                        set.add(s);
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }

    private String insertParensInside(String str, int leftIndex){
        String before = str.substring(0, leftIndex + 1);
        String after = str.substring(leftIndex + 1);
        return before + "()" + after;
    }

}