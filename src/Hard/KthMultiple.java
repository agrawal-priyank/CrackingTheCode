package Hard;

import java.util.ArrayList;
import java.util.Collections;

public class KthMultiple {

    public static void main(String[] args){
        int k = 5;
        KthMultiple kM = new KthMultiple();
        System.out.println(kM.getKthNumber(k));
    }

    public int getKthNumber(int k){
        ArrayList<Integer> factors = allPossibleFactors(k);
        Collections.sort(factors);
        return factors.get(k);
    }

    private ArrayList<Integer> allPossibleFactors(int k){
        ArrayList<Integer> values = new ArrayList<Integer>();
        for(int a = 0; a <= k; a++){
            int powA = (int)Math.pow(3, a);
            for(int b = 0; b <= k; b++){
                int powB = (int)Math.pow(5, b);
                for(int c = 0; c <= k; c++){
                    int powC = (int)Math.pow(7, c);
                    int value = powA * powB * powC;
                    if(value < 0 || powA == Integer.MAX_VALUE || powB == Integer.MAX_VALUE
                            || powC == Integer.MAX_VALUE){
                        values.add(Integer.MAX_VALUE);
                    } else{
                        values.add(value);
                    }
                }
            }
        }
        return values;
    }

}