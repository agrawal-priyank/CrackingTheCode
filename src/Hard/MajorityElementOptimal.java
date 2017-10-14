package Hard;

public class MajorityElementOptimal {

    public static void main(String[] args){
        int[] arr = {3, 1, 7, 1, 1, 7, 7, 3, 7, 7, 7};
        MajorityElementOptimal mEO = new MajorityElementOptimal();
        System.out.println(mEO.findMajorityElement(arr));
    }

    public int findMajorityElement(int[] arr){
        int candidate = getCandidate(arr);
        return validate(arr, candidate) ? candidate : -1;
    }

    private int getCandidate(int[] arr){
        int majority = 0;
        int count = 0;
        for(int i : arr){
            if(count == 0){
                majority = i;
            }
            if(i == majority){
                count++;
            } else{
                count--;
            }
        }
        return majority;
    }

    private boolean validate(int[] arr, int element){
        int count = 0;
        for(int i : arr){
            if(i == element){
                count++;
            }
        }
        return count > arr.length / 2;
    }

}