package Hard;

public class ShortestSupersequence {

    public static void main(String[] args){
        int[] bigArr = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 9, 7};
        int[] smallArr = {1, 5, 9};
        ShortestSupersequence s = new ShortestSupersequence();
        Range best = s.getShortestSupersequence(bigArr, smallArr);
        System.out.println(best.getStart() + " " + best.getEnd());
    }

    public Range getShortestSupersequence(int[] bigArr, int[] smallArr){
        int bestStart = -1, bestEnd = -1;
        for(int i = 0; i < bigArr.length; i++){
            int closure = findClosure(bigArr, smallArr, i);
            if(closure == -1){
                break;
            }
            if(bestStart == -1 || (closure - i < bestEnd - bestStart)){
                bestStart = i;
                bestEnd = closure;
            }
        }
        return new Range(bestStart, bestEnd);
    }

    private int findClosure(int[] bigArr, int[] smallArr, int index){
        int max = -1;
        for(int i = 0; i < smallArr.length; i++){
            int next = findNextInstance(bigArr, smallArr[i], index);
            if(next == -1){
                return -1;
            }
            max = Math.max(max, next);
        }
        return max;
    }

    private int findNextInstance(int[] bigArr, int element, int index){
        for(int i = index; i < bigArr.length; i++){
            if(bigArr[i] == element){
                return i;
            }
        }
        return -1;
    }

}