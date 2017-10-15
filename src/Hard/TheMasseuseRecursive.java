package Hard;

public class TheMasseuseRecursive {

    public static void main(String[] args){
        int[] massages = {30, 15, 60, 75, 45, 15, 15, 45};
        TheMasseuseRecursive tM = new TheMasseuseRecursive();
        System.out.println(tM.maxMinutesSlow(massages, 0));
        int[] memo = new int[massages.length];
        System.out.println(tM.maxMinutesFast(massages, 0, memo));
    }

    public int maxMinutesSlow(int[] massages, int index){
        if(index >= massages.length){
            return 0;
        }
        int bestWith = massages[index] + maxMinutesSlow(massages, index + 2);
        int bestWithout = maxMinutesSlow(massages, index + 1);
        return Math.max(bestWith, bestWithout);
    }

    public int maxMinutesFast(int[] massages, int index, int[] memo){
        if(index >= massages.length){
            return 0;
        }
        if(memo[index] == 0){
            int bestWith = massages[index] + maxMinutesFast(massages, index + 2, memo);
            int bestWithout = maxMinutesFast(massages, index + 1, memo);
            memo[index] = Math.max(bestWith, bestWithout);
        }
        return memo[index];
    }

}