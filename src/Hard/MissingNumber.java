package Hard;

import java.util.ArrayList;

public class MissingNumber {

    public int findMissingNumber(ArrayList<BitInteger> input){
        return find(input, 0);
    }

    private int find(ArrayList<BitInteger> input, int column){
        if(column >= BitInteger.INTEGER_SIZE){
            return 0;
        }
        ArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>(input.size() / 2);
        ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>(input.size() / 2);
        for(BitInteger t : input){
            if(t.fetch(column) == 0){
                zeroBits.add(t);
            } else{
                oneBits.add(t);
            }
        }
        if(zeroBits.size() <= oneBits.size()){
            int v = find(zeroBits, column + 1);
            return (v << 1) | 0;
        } else{
            int v = find(oneBits, column + 1);
            return (v << 1) | 1;
        }
    }

}