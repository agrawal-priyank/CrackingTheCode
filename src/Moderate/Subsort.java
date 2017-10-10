package Moderate;

public class Subsort {

    public static void main(String[] args){
        int[] arr = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        Subsort s = new Subsort();
        s.findUnsortedSequence(arr);
    }

    public void findUnsortedSequence(int[] arr){
        int end_left = findEndOfLeftSubsequence(arr);
        if(end_left == arr.length - 1){
            return;
        }
        int start_right = findStartOfRightSubsequence(arr);
        int max_index = end_left;
        int min_index = start_right;
        for(int i = end_left + 1; i < start_right; i++){
            if(arr[i] < arr[min_index]){
                min_index = i;
            }
            if(arr[i] > arr[max_index]){
                max_index = i;
            }
        }
        int left_index = shrinkLeft(arr, min_index, end_left);
        int right_index = shrinkRight(arr, max_index, start_right);
        System.out.println(left_index + " to " + right_index);
    }

    private int findEndOfLeftSubsequence(int[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i - 1] > arr[i]){
                return i - 1;
            }
        }
        return arr.length - 1;
    }

    private int findStartOfRightSubsequence(int[] arr){
        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] > arr[i + 1]){
                return i + 1;
            }
        }
        return 0;
    }

    private int shrinkLeft(int[] arr, int min_index, int start){
        for(int i = start; i >= 0; i--){
            if(arr[i] <= arr[min_index]){
                return i + 1;
            }
        }
        return 0;
    }

    private int shrinkRight(int[] arr, int max_index, int start){
        for(int i = start; i < arr.length; i++){
            if(arr[max_index] <= arr[i]){
                return i - 1;
            }
        }
        return arr.length - 1;
    }

}