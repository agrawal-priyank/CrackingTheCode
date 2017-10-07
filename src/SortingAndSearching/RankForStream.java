package SortingAndSearching;

public class RankForStream {

    public static void main(String[] args){
        int[] arr = {5, 1, 4, 4, 5, 9, 7, 13, 3};
        RankNode node = new RankNode(arr[0]);
        for(int i = 1; i < arr.length; i++){
            node.insert(arr[i]);
        }
        System.out.println(node.getRank(7));
    }

}