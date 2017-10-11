package Moderate;

import java.util.Arrays;

public class SumSwapOptimalAlternate {

    public static void main(String[] args){
        int[] arr1 = {4, 1, 2, 1, 1, 2};
        int[] arr2 = {3, 6, 3, 3};
        SumSwapOptimalAlternate s = new SumSwapOptimalAlternate();
        int[] values = s.findSwapValues(arr1, arr2);
        System.out.println(Arrays.toString(values));
    }

    public int[] findSwapValues(int[] arr1, int[] arr2){
        Integer target = getTarget(arr1, arr2);
        if(target == null){
            return null;
        }
        // If arrays are not sorted
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int a = 0;
        int b = 0;
        while(a < arr1.length && b < arr2.length){
            int diff = arr1[a] - arr2[b];
            if(diff == target){
                return new int[]{arr1[a], arr2[b]};
            } else if(diff < target){
                a++;
            } else{
                b++;
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