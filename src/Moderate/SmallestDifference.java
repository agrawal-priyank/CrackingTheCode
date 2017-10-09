package Moderate;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args){
        int[] arr1 = {1, 3, 15, 11, 2};
        int[] arr2 = {23, 127, 235, 19, 8};
        SmallestDifference sD = new SmallestDifference();
        System.out.println(sD.findSmallestDifference(arr1, arr2));
    }

    public int findSmallestDifference(int[] arr1, int[] arr2){
        if(arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0){
            return -1;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int difference = Integer.MAX_VALUE;
        int a = 0, b = 0;
        while(a < arr1.length && b < arr2.length){
            if(Math.abs(arr1[a] - arr2[b]) < difference){
                difference = Math.abs(arr1[a] - arr2[b]);
            }
            if(arr1[a] < arr2[b]){
                a++;
            } else{
                b++;
            }
        }
        return difference;
    }

}