package SortingAndSearching;

public class FindDuplicates {

    public static void main(String[] args){
        int[] arr = {1, 2, 5, 7, 8, 9, 77, 88, 99, 999, 8, 5555, 8888, 9999, 10000};
        FindDuplicates fD = new FindDuplicates();
        fD.findAndPrintDuplicates(arr);
    }

    public void findAndPrintDuplicates(int[] arr){
        BitSet bs = new BitSet(32000);
        for(int i = 0; i < arr.length; i++){
            int num = arr[i];
            int num0 = num - 1;
            if(bs.get(num0)){
                System.out.println(num);
            } else{
                bs.set(num0);
            }
        }
    }

}