package BitManipulation;

import java.util.ArrayList;

public class FlipBitToWin {

    public static void main(String[] args) {
        String s = "11011101111";
        int num = Integer.parseInt(s, 2);
        FlipBitToWin flip = new FlipBitToWin();
        int res1 = flip.longestSequence(num);
        int res2 = flip.longestSequenceOptimal(num);
        System.out.println(res1);
        System.out.println(res2);
    }

    public int longestSequence(int n) {
        if(n == -1){
            return Integer.BYTES * 8;
        }
        ArrayList<Integer> sequences = getAlternatingSequences(n);
        return findLongestSequence(sequences);
    }

    public int longestSequenceOptimal(int n){
        if(~n == 0){
            return Integer.BYTES * 8;
        }
        int currLength = 0;
        int prevLength = 0;
        int maxLength = 0;
        while(n != 0){
            if((n & 1) == 1){
                currLength++;
            }else{
                prevLength = ((n & 2) == 0) ? 0 : currLength;
                currLength = 0;
            }
            maxLength = Math.max(maxLength, prevLength + currLength + 1);
            n >>>= 1;
        }
        return maxLength;
    }

    private ArrayList<Integer> getAlternatingSequences(int n) {
        ArrayList<Integer> sequences = new ArrayList<Integer>();
        int searchingFor = 0;
        int counter = 0;
        for(int i = 0; i < Integer.BYTES * 8; i++){
            if((n & 1) != searchingFor){
                sequences.add(counter);
                searchingFor = n & 1;
                counter = 0;
            }
            counter++;
            n >>>= 1;
        }
        sequences.add(counter);
        return sequences;
    }

    private int findLongestSequence(ArrayList<Integer> sequences) {
        int maxSeq = 1;
        for(int i = 0; i < sequences.size(); i+=2){
            int zerosSeq = sequences.get(i);
            int onesSeqRight = i - 1 >= 0 ? sequences.get(i - 1) : 0;
            int onesSeqLeft = i + 1 < sequences.size() ? sequences.get(i + 1) : 0;
            int thisSeq = 0;
            if(zerosSeq == 1){
                thisSeq = onesSeqLeft + 1 + onesSeqRight;
            } else if(zerosSeq > 1){
                thisSeq = 1 + Math.max(onesSeqLeft, onesSeqRight);
            } else if(zerosSeq == 0){
                thisSeq = Math.max(onesSeqLeft, onesSeqRight);
            }
            if(thisSeq > maxSeq){
                maxSeq = thisSeq;
            }
        }
        return maxSeq;
    }

}