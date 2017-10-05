package RecursionAndDynamicProgramming;

public class CoinsNumberOfWaysRecursive {

    public static void main(String[] args){
        int n = 5;
        CoinsNumberOfWaysRecursive c = new CoinsNumberOfWaysRecursive();
        System.out.println(c.makeChange(n));
    }

    public int makeChange(int n){
        int[] denoms = {25, 10, 5, 1};
        int[][] map = new int[n + 1][denoms.length];
        return makeChange(map, denoms, 0, n);
    }

    private int makeChange(int[][] map, int[] denoms, int index, int amount){
        if(map[amount][index] > 0){
            return map[amount][index];
        }
        if(index >= denoms.length - 1){
            return 1;
        }
        int denomAmount = denoms[index];
        int ways = 0;
        for(int i = 0; i * denomAmount <= amount; i++){
            int amountRemaining = amount - (i * denomAmount);
            ways += makeChange(map, denoms, index + 1, amountRemaining);
        }
        map[amount][index] = ways;
        return ways;
    }

}