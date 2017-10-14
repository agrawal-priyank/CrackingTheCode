package Hard;

public class MajorityElement {

    public static void main(String[] args){
        int[] arr = {3, 1, 7, 1, 1, 7, 7, 3, 7, 7, 7};
        MajorityElement mE = new MajorityElement();
        System.out.println(mE.findMajorityElement(arr));
    }

    public int findMajorityElement(int[] arr){
        for(int i : arr){
            if(validate(arr, i)){
                return i;
            }
        }
        return -1;
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