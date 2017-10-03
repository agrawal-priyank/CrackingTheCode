package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class PowerSetCombinatorics {

    public static void main(String[] args){
        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        PowerSetCombinatorics pSC = new PowerSetCombinatorics();
        ArrayList<ArrayList<Integer>> allSubsets = pSC.getSubsets(set);
        System.out.println(allSubsets.size());
        for(ArrayList<Integer> subset : allSubsets){
            System.out.println(subset);
        }
    }

    public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set){
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
        int max = 1 << set.size();
        for(int k = 0; k < max; k++){
            ArrayList<Integer> subset = getSubset(set, k);
            allSubsets.add(subset);
        }
        return allSubsets;
    }

    private ArrayList<Integer> getSubset(ArrayList<Integer> set, int k){
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for(int x = k; x > 0; x >>= 1){
            if((x & 1) == 1){
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }

}