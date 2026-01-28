class Solution {
	int[][] mat;
	int[][] prefixSum;
	
    public int maxSideLength(int[][] mat, int threshold) {
        this.mat = mat;
        prefixSum = new int[mat.length][mat[0].length];
        makePrefixSum();
        
        for (int size = Math.min(mat.length, mat[0].length); size > 0; size --) {
        	for (int i = 0; i <= mat.length-size; i++) {
        		for (int j = 0; j <= mat[i].length-size; j++) {
        			if (threshold >= getPrefixSumRange(i, j, size)) return size;
        		}
        	}
        }
        
    	return 0;
    }
    
    private int getPrefixSumRange(int y, int x, int l) {
    	int a = prefixSum[y+l-1][x+l-1];
    	int b = x > 0 ? prefixSum[y+l-1][x-1] : 0;
    	int c = y > 0 ? prefixSum[y-1][x+l-1] : 0;
    	int d = y > 0 && x > 0 ? prefixSum[y-1][x-1] : 0;
    	return a - b - c + d;
	}

	public void makePrefixSum() {
    	prefixSum[0][0] = mat[0][0];
    	for (int i = 1; i < mat[0].length; i++) {
			prefixSum[0][i] = mat[0][i] + prefixSum[0][i-1];
		}
    	for (int i = 1; i < mat.length; i++) {
			prefixSum[i][0] = mat[i][0] + prefixSum[i-1][0];
		}
    	for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[i].length; j++) {
				prefixSum[i][j] = mat[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
			}
		}
    }
}