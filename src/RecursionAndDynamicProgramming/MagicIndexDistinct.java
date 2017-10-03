package RecursionAndDynamicProgramming;

public class MagicIndexDistinct {

    public static void main(String[] args){
        int[] arr = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        MagicIndexDistinct mI = new MagicIndexDistinct();
        System.out.println(mI.magicSlow(arr));
        System.out.println(mI.magicFast(arr));
    }

    public int magicSlow(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == i){
                return i;
            }
        }
        return -1;
    }

    public int magicFast(int[] arr){
        return magicFast(arr, 0, arr.length - 1);
    }

    private int magicFast(int[] arr, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(arr[mid] == mid){
            return mid;
        } else if(arr[mid] < mid){
            return magicFast(arr, mid + 1, end);
        } else{
            return magicFast(arr, start, mid - 1);
        }
    }

}