package Hard;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomSet {

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int m = 5;
        RandomSet rS = new RandomSet();
        int[] subset = rS.pickMElements(arr, m);
        System.out.println(Arrays.toString(subset));
    }

    public int[] pickMElements(int[] arr, int m){
        int[] subset = new int[m];
        for(int i = 0; i < m; i++){
            subset[i] = arr[i];
        }
        for(int i = m; i < arr.length; i++){
            int k = ThreadLocalRandom.current().nextInt(0, i + 1);
            if(k < m){
                subset[k] = arr[i];
            }
        }
        return subset;
    }

}