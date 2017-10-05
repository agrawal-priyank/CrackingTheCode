package RecursionAndDynamicProgramming;

public class CoinsNumberOfWays {

    public static void main(String[] args){
        int[] coins = {1, 5, 10, 25};
        int total = 5;
        CoinsNumberOfWays c = new CoinsNumberOfWays();
        System.out.println(c.numberOfWays(coins, total));
        System.out.println(c.numberOfWaysSpaceEfficient(coins, total));
    }

    public int numberOfWays(int[] coins, int total){
        int[][] map = new int[coins.length + 1][total + 1];
        for(int i = 1; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(j == 0){
                    map[i][j] = 1;
                } else if(coins[i - 1] > j){
                    map[i][j] = map[i - 1][j];
                } else{
                    map[i][j] = map[i - 1][j] + map[i][j - coins[i - 1]];
                }
            }
        }
        return map[coins.length][total];
    }

    public int numberOfWaysSpaceEfficient(int[] coins, int total){
        int[] ways = new int[total + 1];
        ways[0] = 1;
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j <= total; j++){
                if(j >= coins[i]){
                    ways[j] = ways[j] + ways[j - coins[i]];
                }
            }
        }
        return ways[total];
    }

}