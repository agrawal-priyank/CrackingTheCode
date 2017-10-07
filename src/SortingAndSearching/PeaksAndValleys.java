package SortingAndSearching;

import java.util.Arrays;

public class PeaksAndValleys {

    public static void main(String[] args){
        int[] arr = {0, 1, 4, 7, 8, 9};
        int[] arr2 = arr.clone();
        PeaksAndValleys p = new PeaksAndValleys();
        p.sortValleyPeak(arr);
        p.sortValleyPeakOptimal(arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }

    public void sortValleyPeak(int[] arr){
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i += 2){
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }
    }

    public void sortValleyPeakOptimal(int[] arr){
        for(int i = 1; i < arr.length; i += 2){
            int index = maxIndex(arr, i - 1, i, i + 1);
            if(index != i){
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }

    private int maxIndex(int[] arr, int a, int b, int c){
        int len = arr.length;
        int aValue = a >= 0 && a < len ? arr[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < len ? arr[b] : Integer.MIN_VALUE;
        int cValue = c >= 0 && c < len ? arr[c] : Integer.MIN_VALUE;
        int max = Math.max(aValue, Math.max(bValue, cValue));
        if(max == aValue){
            return a;
        } else if(max == bValue){
            return b;
        } else{
            return c;
        }
    }

}