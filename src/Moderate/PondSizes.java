package Moderate;

import java.util.ArrayList;
import java.util.Arrays;

public class PondSizes {

    public static void main(String[] args){
        int[][] land = {{0, 2, 0, 1}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        PondSizes pS = new PondSizes();
        ArrayList<Integer> sizes = pS.computePondSizes(land);
        System.out.println(Arrays.toString(sizes.toArray()));
    }

    public ArrayList<Integer> computePondSizes(int[][] land){
        ArrayList<Integer> sizes = new ArrayList<Integer>();
        for(int r = 0; r < land.length; r++){
            for(int c = 0; c < land[r].length; c++){
                int size = computeSize(land, r, c);
                if(size > 0){
                    sizes.add(size);
                }
            }
        }
        return sizes;
    }

    private int computeSize(int[][] land, int row, int col){
        if(row < 0 || row >= land.length || col < 0 || col >= land[row].length
                || land[row][col] != 0){
            return 0;
        }
        int size = 1;
        land[row][col] = -1;
        for(int dr = -1; dr <= 1; dr++){
            for(int dc = -1; dc <= 1; dc++){
                size += computeSize(land, row + dr, col + dc);
            }
        }
        return size;
    }

}