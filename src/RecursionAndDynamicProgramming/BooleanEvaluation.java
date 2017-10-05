package RecursionAndDynamicProgramming;

import java.util.HashMap;

public class BooleanEvaluation {

    public static void main(String[] args){
        String s = "0&0&0&1^1|0";
        boolean result = true;
        BooleanEvaluation bE = new BooleanEvaluation();
        HashMap<String, Integer> memo = new HashMap<String, Integer>();
        System.out.println(bE.countEval(s, result, memo));
    }

    public int countEval(String s, boolean result, HashMap<String, Integer> memo){
        if(s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return stringToBool(s) == result ? 1 : 0;
        }
        if(memo.containsKey(s + result)){
            return memo.get(s + result);
        }
        int ways = 0;
        for(int i = 1; i < s.length(); i += 2){
            char c = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1);

            int leftTrue = countEval(left, true, memo);
            int leftFalse = countEval(left, false, memo);
            int rightTrue = countEval(right, true, memo);
            int rightFalse = countEval(right, false, memo);

            int totalWays = (leftTrue + leftFalse) * (rightTrue + rightFalse);

            int totalTrue = 0;
            if(c == '^'){
                totalTrue = (leftTrue * rightFalse) + (leftFalse * rightTrue);
            } else if(c == '&'){
                totalTrue = leftTrue * rightTrue;
            } else if(c == '|'){
                totalTrue = (leftTrue * rightTrue) + (leftTrue * rightFalse) + (leftFalse * rightTrue);
            }

            int subWays = result ? totalTrue : totalWays - totalTrue;
            ways += subWays;
        }

        memo.put(s + result, ways);
        return ways;
    }

    private boolean stringToBool(String s){
        return s.equals("1") ? true : false;
    }

}