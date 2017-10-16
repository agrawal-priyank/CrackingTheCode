package Hard;

public class MaxSquareMatrixOptimal {

    public static void main(String[] args){
        int[][] matrix = {{1, 0, 1},  {0, 0, 1}, {0, 0, 1}};
        MaxSquareMatrixOptimal m = new MaxSquareMatrixOptimal();
        SubSquare square = m.findSquare(matrix);
        if(square != null){
            square.print();
        } else{
            System.out.println("No squares found!");
        }
    }

    public SubSquare findSquare(int[][] matrix){
        SquareCell[][] processed = processMatrix(matrix);
        for(int i = matrix.length; i >= 1; i--){
            SubSquare square = findSquareWithSize(processed, i);
            if(square != null){
                return square;
            }
        }
        return null;
    }

    private SubSquare findSquareWithSize(SquareCell[][] processed, int size){
        int count = processed.length - size + 1;
        for(int row = 0; row < count; row++){
            for(int col = 0; col < count; col++){
                if(isSquare(processed, row, col, size)){
                    return new SubSquare(row, col, size);
                }
            }
        }
        return null;
    }

    private boolean isSquare(SquareCell[][] processed, int row, int col, int size){
        SquareCell topLeft = processed[row][col];
        SquareCell topRight = processed[row][col + size - 1];
        SquareCell bottomLeft = processed[row + size - 1][col];
        if(topLeft.zerosRight < size || topLeft.zerosBelow < size
                || topRight.zerosBelow < size || bottomLeft.zerosRight < size){
            return false;
        }
        return true;
    }

    private SquareCell[][] processMatrix(int[][] matrix){
        int size = matrix.length;
        SquareCell[][] processed = new SquareCell[size][size];
        for(int r = size - 1; r >= 0; r--){
            for(int c = size - 1; c >= 0; c--){
                int rightZeros = 0;
                int belowZeros = 0;
                if(matrix[r][c] == 0){
                    rightZeros++;
                    belowZeros++;
                    if(c + 1 < size){
                        rightZeros += processed[r][c + 1].zerosRight;
                    }
                    if(r + 1 < size){
                        belowZeros += processed[r + 1][c].zerosBelow;
                    }
                }
                processed[r][c] = new SquareCell(rightZeros, belowZeros);
            }
        }
        return processed;
    }

}