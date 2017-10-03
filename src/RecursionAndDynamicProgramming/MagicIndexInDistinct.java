package RecursionAndDynamicProgramming;

public class MagicIndexInDistinct {

    public static void main(String[] args){
        int[] arr = {-1, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        MagicIndexInDistinct mI = new MagicIndexInDistinct();
        System.out.println(mI.magicFast(arr));
    }

    public int magicFast(int[] arr){
        return magicFast(arr, 0, arr.length - 1);
    }

    private int magicFast(int[] arr, int start, int end){
        if(start > end){
            return - 1;
        }

        int midIndex = (start + end) / 2;
        int midValue = arr[midIndex];
        if(midValue == midIndex){
            return midIndex;
        }

        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicFast(arr, start, leftIndex);
        if(left >= 0){
            return left;
        }

        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = magicFast(arr, rightIndex, end);
        return right;
    }

}