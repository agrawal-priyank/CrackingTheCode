package Hard;

public class MaxSubMatrixBest {

    public static void main(String[] args){
        int[][] matrix = {{1, 2, 5, -5},
                          {2, 4, 5, -8},
                          {-8, -4, 1, 2}};
        MaxSubMatrixBest m = new MaxSubMatrixBest();
        SubMatrix subMatrix = m.getMaxMatrix(matrix);
        subMatrix.print();
    }

    public SubMatrix getMaxMatrix(int[][] matrix){
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        SubMatrix best = null;
        for(int rowStart = 0; rowStart < rowCount; rowStart++){
            int[] partialSum = new int[colCount];
            for(int rowEnd = rowStart; rowEnd < rowCount; rowEnd++){
                for(int i = 0; i < colCount; i++){
                    partialSum[i] += matrix[rowEnd][i];
                }
                Range bestRange = maxSubArray(partialSum, colCount);
                if(best == null || best.getSum() < bestRange.sum){
                    best = new SubMatrix(rowStart, bestRange.start, rowEnd, bestRange.end, bestRange.sum);
                }
            }
        }
        return best;
    }

    private Range maxSubArray(int[] array, int n){
        Range best = null;
        int start = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += array[i];
            if(best == null || best.sum < sum){
                best = new Range(start, i, sum);
            }
            if(sum < 0){
                start = i + 1;
                sum = 0;
            }
        }
        return best;
    }

    private class Range{
        public int start, end, sum;
        public Range(int start, int end, int sum){
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }

}