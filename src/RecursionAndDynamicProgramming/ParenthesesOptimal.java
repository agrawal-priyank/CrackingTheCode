package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class ParenthesesOptimal {

    public static void main(String[] args){
        int n = 3;
        ParenthesesOptimal p = new ParenthesesOptimal();
        ArrayList<String> list = p.generateParens(n);
        System.out.println(list);
    }

    public ArrayList<String> generateParens(int count){
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<String>();
        generateParens(list, count, count, str, 0);
        return list;
    }

    public void generateParens(ArrayList<String> list, int leftRem, int rightRem,
                                            char[] str, int index){
        if(leftRem < 0 || rightRem < 0){
            return;
        }
        if(leftRem == 0 && rightRem == 0){
            String s = String.copyValueOf(str);
            list.add(s);
        } else{
            if(leftRem > 0){
                str[index] = '(';
                generateParens(list, leftRem - 1, rightRem, str, index + 1);
            }
            if(rightRem > leftRem){
                str[index] = ')';
                generateParens(list, leftRem, rightRem - 1, str, index + 1);
            }
        }
    }

}