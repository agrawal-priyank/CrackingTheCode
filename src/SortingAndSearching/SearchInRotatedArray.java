package SortingAndSearching;

public class SearchInRotatedArray {

    public static void main(String[] args){
        int[] arr = {4, 4, 4, 4, 4, 4, 1, 2, 3};
        SearchInRotatedArray s = new SearchInRotatedArray();
        System.out.println(s.search(arr, 0, arr.length - 1, 1));
    }

    public int search(int[] arr, int left, int right, int x){
        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if(arr[mid] == x){
            return mid;
        }
        if(arr[left] < arr[mid]){
            if(x >= arr[left] && x < arr[mid]){
                return search(arr, left, mid - 1, x);
            } else{
                return search(arr, mid + 1, right, x);
            }
        } else if(arr[mid] < arr[left]){
            if(x > arr[mid] && x <= arr[right]){
                return search(arr, mid + 1, right, x);
            } else{
                return search(arr, left, mid - 1, x);
            }
        } else if(arr[left] == arr[mid]){
            if(arr[mid] != arr[right]){
                return search(arr, mid + 1, right, x);
            } else{
                int result = search(arr, left, mid - 1, x);
                if(result == -1){
                    return search(arr, mid + 1, right, x);
                } else{
                    return result;
                }
            }
        }
        return -1;
    }

}