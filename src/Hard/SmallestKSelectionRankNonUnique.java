package Hard;

import java.util.Arrays;
import java.util.Random;

public class SmallestKSelectionRankNonUnique {

    public static void main(String[] args){
        int[] arr = {1, 5, 2, 3, 2, 9, -1, 11, 6, 13, 15, 2};
        SmallestKSelectionRankNonUnique s = new SmallestKSelectionRankNonUnique();
        int[] res = s.smallestK(arr, 6);
        System.out.println(Arrays.toString(res));
    }

    public int[] smallestK(int[] arr, int k){
        if(k <= 0 || k > arr.length){
            return null;
        }
        int threshold = rank(arr, k);
        int[] smallest = new int[k];
        int count = 0;
        for(int a : arr){
            if(a < threshold){
                smallest[count] = a;
                count++;
            }
        }
        while(count < k){
            smallest[count] = threshold;
            count++;
        }
        return smallest;
    }

    private int rank(int[] arr, int k){
        return rank(arr, k - 1, 0, arr.length - 1);
    }

    private int rank(int[] arr, int k, int start, int end){
        int pivot = arr[randomIntInRange(start, end)];
        PartitionResult p = partition(arr, start, end, pivot);
        int leftSize = p.leftSize;
        int middleSize = p.middleSize;
        if(k < leftSize){
            return rank(arr, k, start, start + leftSize - 1);
        } else if(k < leftSize + middleSize){
            return pivot;
        } else{
            return rank(arr, k - leftSize - middleSize, start + leftSize + middleSize, end);
        }
    }

    private PartitionResult partition(int[] arr, int start, int end, int pivot){
        int left = start;
        int middle = start;
        int right = end;
        while(middle <= right){
            if(arr[middle] < pivot){
                swap(arr, left, middle);
                left++;
                middle++;
            } else if(arr[middle] > pivot){
                swap(arr, middle, right);
                right--;
            } else if(arr[middle] == pivot){
                middle++;
            }
        }
        return new PartitionResult(left - start, right - left + 1);
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int randomIntInRange(int min, int max){
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

}