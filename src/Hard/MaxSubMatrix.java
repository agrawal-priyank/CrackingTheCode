package Hard;

public class MaxSubMatrix {

    public static void main(String[] args){
        int[][] matrix = {{1, 2, 5, -5},
                          {2, 4, 5, -8},
                          {-8, -4, 1, 2}};
        MaxSubMatrix m = new MaxSubMatrix();
        SubMatrix subMatrix = m.getMaxMatrix(matrix);
        subMatrix.print();
    }

    public SubMatrix getMaxMatrix(int[][] matrix){
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        SubMatrix best = null;
        for(int row1 = 0; row1 < rowCount; row1++){
            for(int row2 = row1; row2 < rowCount; row2++){
                for(int col1 = 0; col1 < colCount; col1++){
                    for(int col2 = col1; col2 < colCount; col2++){
                        int sum = sum(matrix, row1, col1, row2, col2);
                        if(best == null || best.getSum() < sum){
                            best = new SubMatrix(row1, col1, row2, col2, sum);
                        }
                    }
                }
            }
        }
        return best;
    }

    private int sum(int[][] matrix, int row1, int col1, int row2, int col2){
        int sum = 0;
        for(int r = row1; r <= row2; r++){
            for(int c = col1; c <= col2; c++){
                sum += matrix[r][c];
            }
        }
        return sum;
    }

}