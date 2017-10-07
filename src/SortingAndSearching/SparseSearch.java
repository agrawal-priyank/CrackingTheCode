package SortingAndSearching;

public class SparseSearch {

    public static void main(String[] args){
        String[] strings = {"abc", "", "", "","", "", "pqr","","xyz"};
        SparseSearch s = new SparseSearch();
        System.out.println(s.search(strings, "xyz"));
    }

    public int search(String[] strings, String str){
        if(strings == null || str == null || str == ""){
            return -1;
        }
        return search(strings, str, 0, strings.length - 1);
    }

    private int search(String[] strings, String str, int first, int last){
        if(first > last){
            return -1;
        }
        int mid = (first + last) / 2;
        if(strings[mid].isEmpty()){
            int left = mid - 1;
            int right = mid + 1;
            while(true){
                if(left < first && right > last){
                    return -1;
                } else if(left >= first && !strings[left].isEmpty()){
                    mid = left;
                    break;
                } else if(right <= last && !strings[right].isEmpty()){
                    mid = right;
                    break;
                }
                left++;
                right--;
            }
        }
        if(strings[mid].equals(str)){
            return mid;
        } else if(strings[mid].compareTo(str) < 0){
            return search(strings, str, mid + 1, last);
        } else{
            return search(strings, str, first, mid - 1);
        }
    }

}