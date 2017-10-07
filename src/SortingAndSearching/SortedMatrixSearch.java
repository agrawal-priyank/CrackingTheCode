package SortingAndSearching;

public class SortedMatrixSearch {

    public static void main(String[] args){
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SortedMatrixSearch s = new SortedMatrixSearch();
        System.out.println(s.findElement(mat, 8));
        System.out.println(s.findElement(mat, 10));
    }

    public boolean findElement(int[][] mat, int element){
        int row = 0;
        int col = mat[0].length - 1;
        while(row < mat.length && col >= 0){
            if(mat[row][col] == element){
                return true;
            } else if(mat[row][col] > element){
                col--;
            } else{
                row++;
            }
        }
        return false;
    }

}