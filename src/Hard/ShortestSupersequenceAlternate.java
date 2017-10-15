package Hard;

public class ShortestSupersequenceAlternate {

    public static void main(String[] args){
        int[] bigArr = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 9, 7};
        int[] smallArr = {1, 5, 9};
        ShortestSupersequenceAlternate s = new ShortestSupersequenceAlternate();
        Range best = s.getShortestSupersequence(bigArr, smallArr);
        System.out.println(best.getStart() + " " + best.getEnd());
    }

    public Range getShortestSupersequence(int[] bigArr, int[] smallArr){
        int[] closures = getClosures(bigArr, smallArr);
        return getShortestClosure(closures);
    }

    private int[] getClosures(int[] bigArr, int[] smallArr){
        int[] closures = new int[bigArr.length];
        for(int i = 0; i < smallArr.length; i++){
            sweepForShortestClosure(bigArr, closures, smallArr[i]);
        }
        return closures;
    }

    private void sweepForShortestClosure(int[] bigArr, int[] closures, int value){
        int next = -1;
        for(int i = bigArr.length - 1; i >= 0; i--){
            if(bigArr[i] == value){
                next = i;
            }
            if((next == -1 || closures[i] < next) && closures[i] != -1){
                closures[i] = next;
            }
        }
    }

    private Range getShortestClosure(int[] closures){
        Range shortest = new Range(0, closures[0]);
        for(int i = 1; i < closures.length; i++){
            if(closures[i] == -1){
                break;
            }
            Range newRange = new Range(i, closures[i]);
            if(newRange.isShorterThan(shortest)){
                shortest = newRange;
            }
        }
        return shortest;
    }

}