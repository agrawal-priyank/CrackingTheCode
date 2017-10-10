package Moderate;

import java.util.HashSet;

public class DivingBoard {

    public static void main(String[] args){
        int k = 5, shorter = 5, longer = 9;
        DivingBoard dB = new DivingBoard();
        HashSet<Integer> lengths = dB.allLengthsOptimal(k, shorter, longer);
        int count = 1;
        for(Integer length : lengths){
            System.out.println("Board " + count++ + ": "  + length);
        }
    }

    public HashSet<Integer> allLengthsOptimal(int k, int shorter, int longer){
        HashSet<Integer> lengths = new HashSet<Integer>();
        for(int nShorter = 0; nShorter <= k; nShorter++){
            int nLonger = k - nShorter;
            int length = (nShorter * shorter) + (nLonger * longer);
            lengths.add(length);
        }
        return lengths;
    }

    public HashSet<Integer> allLengths(int k, int shorter, int longer){
        HashSet<Integer> lengths = new HashSet<Integer>();
        getAllLengths(k, 0, shorter, longer, lengths);
        return lengths;
    }

    private void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths){
        if(k == 0){
            lengths.add(total);
            return;
        }
        getAllLengths(k - 1, total + shorter, shorter, longer, lengths);
        getAllLengths(k - 1, total + longer, shorter, longer, lengths);
    }

}