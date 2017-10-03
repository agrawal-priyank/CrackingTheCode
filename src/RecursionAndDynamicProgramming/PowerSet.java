package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class PowerSet {

    public static void main(String[] args){
        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        PowerSet pS = new PowerSet();
        ArrayList<ArrayList<Integer>> allSubsets = pS.getSubsets(set, 0);
        System.out.println(allSubsets.size());
        for(ArrayList<Integer> subset : allSubsets){
            System.out.println(subset);
        }
    }

    public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> allSubsets;
        if(set.size() == index){
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<Integer>());
        } else{
            allSubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset : allSubsets){
                ArrayList<Integer> newSubset = new ArrayList<Integer>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }

}