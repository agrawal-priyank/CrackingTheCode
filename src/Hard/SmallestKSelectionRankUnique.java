package Hard;

import java.util.Arrays;
import java.util.Random;

public class SmallestKSelectionRankUnique {

    public static void main(String[] args){
        int[] arr = {1, 8, 9, 4, 5, 7, 3, 2, 6};
        SmallestKSelectionRankUnique s = new SmallestKSelectionRankUnique();
        int[] res = s.smallestK(arr, 8);
        System.out.println(Arrays.toString(res));
    }

    public int[] smallestK(int[] arr, int k){
        if(k <= 0 || k > arr.length){
            return null;
        }
        int threshold = rank(arr, k);
        int[] smallest = new int[k];
        int i = 0;
        for(int a : arr){
            if(a <= threshold){
                smallest[i] = a;
                i++;
            }
        }
        return smallest;
    }

    private int rank(int[] arr, int k){
        return rank(arr, 0, arr.length - 1, k - 1);
    }

    private int rank(int[] arr, int left, int right, int rank){
        int pivot = arr[randomIntInRange(left, right)];
        int leftEnd = partition(arr, left, right, pivot);
        int leftSize = leftEnd - left + 1;
        if(rank == leftSize - 1){
            return max(arr, left, leftEnd);
        } else if(rank < leftSize - 1){
            return rank(arr, left, leftEnd, rank);
        } else{
            return rank(arr, leftEnd + 1, right, rank - leftSize);
        }
    }

    private int partition(int[] arr, int left, int right, int pivot){
        while(left <= right){
            if(arr[left] > pivot){
                swap(arr, left, right);
                right--;
            } else if(arr[right] <= pivot){
                swap(arr, left, right);
                left++;
            } else{
                left++;
                right--;
            }
        }
        return left - 1;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int max(int[] arr, int left, int right){
        int max = Integer.MIN_VALUE;
        for(int i = left; i <= right; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    private int randomIntInRange(int min, int max){
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

}