package RecursionAndDynamicProgramming;

public class Fibonacci {

    public static void  main(String[] args){
        int n = 10;
        int[] memo = new int[n + 1];
        Fibonacci f = new Fibonacci();
        System.out.println(f.recursive(n));
        System.out.println(f.topDown(n, memo));
        System.out.println(f.bottomUp(n));
        System.out.println(f.bottomUpOptimized(n));
    }

    public int recursive(int i){
        if(i == 0 || i == 1){
            return i;
        }
        return recursive(i - 1) + recursive(i - 2);
    }

    public int topDown(int i, int[] memo){
        if(i == 0 || i == 1){
            return i;
        }
        if(memo[i] == 0){
            memo[i] = topDown(i - 1, memo) + topDown(i - 2, memo);
        }
        return memo[i];
    }

    public int bottomUp(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for(int i = 2; i <= n; i++){
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public int bottomUpOptimized(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int a = 0, b = 1, c = 0;
        for(int i = 2; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}