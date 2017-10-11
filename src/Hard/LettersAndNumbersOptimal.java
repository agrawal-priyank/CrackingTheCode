package Hard;

import java.util.HashMap;

public class LettersAndNumbersOptimal {

    public static void main(String[] args){
        char a = 'a';
        char b = '1';
        char[] arr = {a, b, a, b, a, b, b, b, b, b, a, a, a, a, a, b, a, b, a, b, b, a, a, a, a, a, a, a};
        LettersAndNumbersOptimal l = new LettersAndNumbersOptimal();
        char[] subarr = l.findLongestSubarray(arr);
        System.out.println(subarr);
    }

    public char[] findLongestSubarray(char[] arr){
        int[] deltas = computeDeltaArray(arr);
        int[] max = findLongestMatch(deltas);
        return extractSubarray(arr, max[0] + 1, max[1]);

    }

    private int[] computeDeltaArray(char[] arr){
        int[] deltas = new int[arr.length];
        int delta = 0;
        for(int i = 0; i < arr.length; i++){
            if(Character.isLetter(arr[i])){
                delta++;
            } else if(Character.isDigit(arr[i])){
                delta--;
            }
            deltas[i] = delta;
        }
        return deltas;
    }

    private int[] findLongestMatch(int[] deltas){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int[] max = new int[2];
        for(int i = 0; i < deltas.length; i++){
            if(!map.containsKey(deltas[i])){
                map.put(deltas[i], i);
            } else{
                int match = map.get(deltas[i]);
                int distance = i - match;
                int longest = max[1] - max[0];
                if(distance > longest){
                    max[0] = match;
                    max[1] = i;
                }
            }
        }
        return max;
    }

    private char[] extractSubarray(char[] arr, int start, int end){
        char[] subarr = new char[end - start + 1];
        for(int i = start; i <= end; i++){
            subarr[i - start] = arr[i];
        }
        return subarr;
    }

}