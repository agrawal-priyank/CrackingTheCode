package RecursionAndDynamicProgramming;

import java.util.Arrays;

public class TripleStep {

    public static void main(String[] args){
        int n = 5;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        TripleStep tS = new TripleStep();
        System.out.println(tS.countWays(n));
        System.out.println(tS.countWaysTopDown(n, memo));
    }

    public int countWays(int n){
        if(n < 0){
            return 0;
        } else if(n == 0){
            return 1;
        } else{
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    public int countWaysTopDown(int n, int[] memo){
        if(n < 0){
            return 0;
        } else if(n == 0){
            return 1;
        } else if(memo[n] > -1){
            return memo[n];
        } else{
            memo[n] = countWaysTopDown(n - 1, memo)
                    + countWaysTopDown(n - 2, memo)
                    + countWaysTopDown(n - 3, memo);
            return memo[n];
        }
    }

}