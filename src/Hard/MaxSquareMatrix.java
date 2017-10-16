package Hard;

public class MaxSquareMatrix {

    public static void main(String[] args){
        int[][] matrix = {{1, 0, 1},  {0, 0, 1}, {0, 0, 1}};
        MaxSquareMatrix m = new MaxSquareMatrix();
        SubSquare square = m.findSquare(matrix);
        if(square != null){
            square.print();
        } else{
            System.out.println("No squares found!");
        }
    }

    public SubSquare findSquare(int[][] matrix){
        for(int i = matrix.length; i >= 1; i--){
            SubSquare square = findSquareWithSize(matrix, i);
            if(square != null){
                return square;
            }
        }
        return null;
    }

    private SubSquare findSquareWithSize(int[][] matrix, int squareSize){
        int count = matrix.length - squareSize + 1;
        for(int row = 0; row < count; row++){
            for(int col = 0; col < count; col++){
                if(isSquare(matrix, row, col, squareSize)){
                    return new SubSquare(row, col, squareSize);
                }
            }
        }
        return null;
    }

    private boolean isSquare(int[][] matrix, int row, int col, int size){
        for(int i = 1; i < size - 1; i++){
            if(matrix[row + i][col] == 1){
                return false;
            }
            if(matrix[row + i][col + size - 1] == 1){
                return false;
            }
        }
        for(int j = 0; j < size; j++){
            if(matrix[row][col + j] == 1){
                return false;
            }
            if(matrix[row + size - 1][col + j] == 1){
                return false;
            }
        }
        return true;
    }

}