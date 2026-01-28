class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;

        boolean even = true;
        int min = Integer.MAX_VALUE;
        long total = 0;
        for (int i = 0; i < n; i++){
            boolean evenW = true;
            for (int j = 0; j < n; j++){
                int abs = Math.abs(matrix[i][j]);
                total += abs;
                min = Math.min(min, abs);
                if (matrix[i][j] < 0) evenW = !evenW;
            }
            if (!evenW) even = !even;
        }

        return even ? total : total - (min*2);
    }
}