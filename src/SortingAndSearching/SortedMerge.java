package SortingAndSearching;

import java.util.Arrays;

public class SortedMerge {

    public static void main(String[] args){
        int[] a = {1, 2, 4, 5, 8, 0, 0, 0, 0};
        int lastA = 5;
        int[] b = {3, 6, 7, 9};
        int lastB = 4;
        SortedMerge sM = new SortedMerge();
        sM.merge(a, b, lastA, lastB);
        System.out.println(Arrays.toString(a));
    }

    public void merge(int[] a, int[] b, int lastA, int lastB){
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int mergedIndex = lastA + lastB - 1;
        while(indexB >= 0){
            if(indexA >= 0 && a[indexA] > b[indexB]){
                a[mergedIndex] = a[indexA];
                indexA--;
            } else{
                a[mergedIndex] = b[indexB];
                indexB--;
            }
            mergedIndex--;
        }
    }

}