package Moderate;

import java.util.Arrays;
import java.util.HashSet;

public class SumSwapOptimal {

    public static void main(String[] args){
        int[] arr1 = {4, 1, 2, 1, 1, 2};
        int[] arr2 = {3, 6, 3, 3};
        SumSwapOptimal s = new SumSwapOptimal();
        int[] values = s.findSwapValues(arr1, arr2);
        System.out.println(Arrays.toString(values));
    }

    public int[] findSwapValues(int[] arr1, int[] arr2){
        Integer target = getTarget(arr1, arr2);
        if(target == null){
            return null;
        }
        HashSet<Integer> set = getContents(arr2);
        for(int i : arr1){
            int diff = i - target;
            if(set.contains(diff)){
                return new int[]{i, diff};
            }
        }
        return null;
    }

    private Integer getTarget(int[] arr1, int[] arr2){
        int sum1 = Arrays.stream(arr1).sum();
        int sum2 = Arrays.stream(arr2).sum();
        if((sum1 - sum2) % 2 != 0){
            return null;
        }
        return (sum1 - sum2) / 2;
    }

    private HashSet<Integer> getContents(int[] arr){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : arr){
            set.add(i);
        }
        return set;
    }

}