package Hard;

public class SubSquare {

    public int row, column, size;

    public SubSquare(int row, int column, int size){
        this.row = row;
        this.column = column;
        this.size = size;
    }

    public void print(){
        System.out.println(row + ", " + column + ", " + size);
    }

}