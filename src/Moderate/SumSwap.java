package Moderate;

import java.util.Arrays;

public class SumSwap {

    public static void main(String[] args){
        int[] arr1 = {4, 1, 2, 1, 1, 2};
        int[] arr2 = {3, 6, 3, 3};
        SumSwap s = new SumSwap();
        int[] values = s.findSwapValues(arr1, arr2);
        System.out.println(Arrays.toString(values));
    }

    public int[] findSwapValues(int[] arr1, int[] arr2){
        Integer target = getTarget(arr1, arr2);
        if(target == null){
            return null;
        }
        for(int one : arr1){
            for(int two : arr2){
                if(one - two == target){
                    return new int[]{one, two};
                }
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

}