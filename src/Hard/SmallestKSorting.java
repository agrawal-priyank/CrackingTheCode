package Hard;

import java.util.Arrays;

public class SmallestKSorting {

    public static void main(String[] args){
        int[] arr = {1, 8, 9, 4, 5, 7, 3, 2, 6};
        SmallestKSorting sK = new SmallestKSorting();
        int[] res = sK.smallestK(arr, 5);
        System.out.println(Arrays.toString(res));
    }

    public int[] smallestK(int[] arr, int k){
        if(k <= 0 || k > arr.length){
            return null;
        }
        Arrays.sort(arr);
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = arr[i];
        }
        return res;
    }

}
