package SortingAndSearching;

import java.util.Arrays;
import java.util.List;

public class SortedSearchNoSize {

    public static void main(String[] args){
        List<Integer> listy = Arrays.asList(1, 4, 5, 7, 9, 11, 15, 19, 20, 25, -1, -1, -1, -1, -1, -1, -1);
        SortedSearchNoSize s = new SortedSearchNoSize();
        System.out.println(s.search(listy, 19));
    }

    public int search(List<Integer> listy, int value){
        int index = 1;
        while(listy.get(index) != -1 && listy.get(index) < value){
            index *= 2;
        }
        return binarySearch(listy, value, index / 2, index);
    }

    private int binarySearch(List<Integer> listy, int value, int low, int high){
        int mid;
        while(low <= high){
            mid = (low + high) / 2;
            int x = listy.get(mid);
            if(x > value || x == -1){
                high = mid - 1;
            } else if(x < value){
                low = mid + 1;
            } else{
                return mid;
            }
        }
        return -1;
    }

}