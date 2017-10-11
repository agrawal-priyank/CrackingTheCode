package Moderate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PairsWithSum {

    public static void main(String[] args){
        int[] arr = {1,2, 3, 7, 8, 9, -5, 4};
        int sum = 6;
        PairsWithSum pWS = new PairsWithSum();
        ArrayList<Pair> pairs = pWS.pairsWithSumSpaceEfficient(arr, sum);
        for(Pair pair : pairs){
            System.out.println(pair.x + " " + pair.y);
        }
    }

    public ArrayList<Pair> pairsWithSumNaive(int[] arr, int sum){
        ArrayList<Pair> list = new ArrayList<Pair>();
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == sum){
                    list.add(new Pair(arr[i], arr[j]));
                }
            }
        }
        return list;
    }

    public ArrayList<Pair> pairsWithSumTimeEfficient(int[] arr, int sum){
        ArrayList<Pair> list = new ArrayList<Pair>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int x : arr){
            int complement = sum - x;
            if(set.contains(complement) && !set.contains(x)){
                list.add(new Pair(x, complement));
            }
            set.add(x);
        }
        return list;
    }

    public ArrayList<Pair> pairsWithSumSpaceEfficient(int[] arr, int sum){
        ArrayList<Pair> list = new ArrayList<Pair>();
        Arrays.sort(arr);
        int first = 0;
        int last = arr.length - 1;
        while(first < last){
            int s = arr[first] + arr[last];
            if(s == sum){
                list.add(new Pair(arr[first], arr[last]));
                first++;
                last--;
            } else if(s < sum){
                first++;
            } else{
                last--;
            }
        }
        return list;
    }

}