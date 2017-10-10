package Moderate;

public class ContiguousSequence {

    public static void main(String[] args){
        int arr[] = {2, -8, 3, -2, 4, -10};
        ContiguousSequence cS = new ContiguousSequence();
        System.out.println("Max Sum: " + cS.maxSumSequence(arr));
    }

    public int maxSumSequence(int[] arr){
        int max_sum = 0;
        int sum = 0;
        int start_index = 0;
        int end_index = 0;
        int start = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(max_sum < sum){
                max_sum = sum;
                end_index = i;
                start_index = start;
            } else if(sum < 0){
                sum = 0;
                start = i + 1;
            }
        }
        System.out.println("Start Index: " + start_index + ", " + "End Index: " + end_index);
        return max_sum;
    }

}