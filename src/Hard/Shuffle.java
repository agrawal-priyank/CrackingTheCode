package Hard;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Shuffle {

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Shuffle s = new Shuffle();
        s.shuffleArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void shuffleArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int k = ThreadLocalRandom.current().nextInt(0, i + 1);
            int temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;
        }
    }

}