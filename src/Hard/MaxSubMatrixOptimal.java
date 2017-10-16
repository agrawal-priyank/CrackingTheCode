package Hard;

public class MaxSubMatrixOptimal {

    public static void main(String[] args){
        int[][] matrix = {{1, 2, 5, -5},
                          {2, 4, 5, -8},
                          {-8, -4, 1, 2}};
        MaxSubMatrixOptimal m = new MaxSubMatrixOptimal();
        SubMatrix subMatrix = m.getMaxMatrix(matrix);
        subMatrix.print();
    }

    public SubMatrix getMaxMatrix(int[][] matrix){
        int[][] sumThrough = precomputeSums(matrix);
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        SubMatrix best = null;
        for(int row1 = 0; row1 < rowCount; row1++){
            for(int row2 = row1; row2 < rowCount; row2++){
                for(int col1 = 0; col1 < colCount; col1++){
                    for(int col2 = col1; col2 < colCount; col2++){
                        int sum = sum(sumThrough, row1, col1, row2, col2);
                        if(best == null || best.getSum() < sum){
                            best = new SubMatrix(row1, col1, row2, col2, sum);
                        }
                    }
                }
            }
        }
        return best;
    }

    private int[][] precomputeSums(int[][] matrix){
        int[][] sumThrough = new int[matrix.length][matrix[0].length];
        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                int left = c > 0 ? sumThrough[r][c - 1] : 0;
                int top = r > 0 ? sumThrough[r - 1][c] : 0;
                int overlap = c > 0 && r > 0 ? sumThrough[r - 1][c - 1] : 0;
                sumThrough[r][c] = matrix[r][c] + left + top - overlap;
            }
        }
        return sumThrough;
    }

    private int sum(int[][] sumThrough, int r1, int c1, int r2, int c2){
        int overlap = r1 > 0 && c1 > 0 ? sumThrough[r1 - 1][c1 - 1] : 0;
        int left = c1 > 0 ? sumThrough[r2][c1 - 1] : 0;
        int top = r1 > 0 ? sumThrough[r1 - 1][c2] : 0;
        return sumThrough[r2][c2] - left - top + overlap;
    }

}