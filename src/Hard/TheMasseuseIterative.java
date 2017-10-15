package Hard;

public class TheMasseuseIterative {

    public static void main(String[] args){
        int[] massages = {30, 15, 60, 75, 45, 15, 15, 45};
        TheMasseuseIterative tM = new TheMasseuseIterative();
        System.out.println(tM.maxMinutes(massages));
        System.out.println(tM.maxMinutesOptimal(massages));
    }

    public int maxMinutes(int[] massages){
        int[] memo = new int[massages.length + 2];
        for(int i = massages.length - 1; i >= 0; i--){
            int bestWith = massages[i] + memo[i + 2];
            int bestWithout = memo[i + 1];
            memo[i] = Math.max(bestWith, bestWithout);
        }
        return memo[0];
    }

    public int maxMinutesOptimal(int[] massages){
        int oneAway = 0, twoAway = 0;
        for(int i = massages.length - 1; i >= 0; i--){
            int bestWith = massages[i] + twoAway;
            int bestWithout = oneAway;
            int current = Math.max(bestWith, bestWithout);
            twoAway = oneAway;
            oneAway = current;
        }
        return oneAway;
    }

}