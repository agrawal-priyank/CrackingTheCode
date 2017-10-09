package Moderate;

public class Check {
    public int row, col;
    private int rowIncrement, colIncrement;

    public Check(int row, int col, int rowInc, int colInc){
        this.row = row;
        this.col = col;
        rowIncrement = rowInc;
        colIncrement = colInc;
    }

    public void increment(){
        row += rowIncrement;
        col += colIncrement;
    }

    public boolean inBounds(int size){
        return row >= 0 && col >= 0 && row < size && col < size;
    }

}