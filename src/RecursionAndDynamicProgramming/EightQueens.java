package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class EightQueens {

    private final static int GRID_SIZE = 8;

    public static void main(String[] args){
        ArrayList<Integer[]> result = new ArrayList<Integer[]>();
        Integer[] columns = new Integer[GRID_SIZE];
        EightQueens eQ = new EightQueens();
        eQ.placeQueens(0, columns, result);
        for(Integer[] i : result){
            System.out.println(Arrays.toString(i));
        }
    }

    public void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> result){
        if(row == GRID_SIZE){
            result.add(columns.clone());
        } else{
            for(int col = 0; col < GRID_SIZE; col++){
                if(checkValidity(columns, row, col)){
                    columns[row] = col;
                    placeQueens(row + 1, columns, result);
                }
            }
        }
    }

    private boolean checkValidity(Integer[] columns, int row1, int col1){
        for(int row2 = 0; row2 < row1; row2++){
            int col2 = columns[row2];
            if(col1 == col2){
                return false;
            }
            int colDistance = Math.abs(col1 - col2);
            int rowDistance = row1 - row2;
            if(colDistance == rowDistance){
                return false;
            }
        }
        return true;
    }

}