class Solution {
	int[][] grid;
	int[][] prefixSumsR;
	int[][] prefixSumsC;
    public int largestMagicSquare(int[][] grid) {
    	this.grid = grid;
    	init();
    	int i = Math.min(grid.length, grid[0].length);
    	boolean isEnd = false;
    	for (; i >= 2; i--) {
			for (int j = 0; j <= grid[0].length - i; j++) {
				for (int k = 0; k <= grid.length - i; k++) {
					if(isMagicSquare(j, k, i)) return i;
				}
			}
		}
    	return i;
    }
    public boolean isMagicSquare(int x, int y, int l) {
    	int s = (x == 0) ? 0 : prefixSumsR[y][x-1];
    	int sum = prefixSumsR[y][x+l-1] - s;
    	for (int i = y+1; i < y+l-1; i++) {
    		s = (x == 0) ? 0 : prefixSumsR[i][x-1];
    		int nextSum = prefixSumsR[i][x+l-1] - s;
    		if (sum != nextSum) return false;
		}
    	for (int i = x; i < x+l; i++) {
    		s = (y == 0) ? 0 : prefixSumsC[y-1][i];
    		int nextSum = prefixSumsC[y+l-1][i] - s;
    		if (sum != nextSum) return false;
    	}
    	int nextSum = 0;
    	for (int i = y; i < y+l; i++) {
			for (int j = x; j < x+l; j++) {
				if (i-y == j-x) nextSum += grid[i][j];
			}
		}
    	if (sum != nextSum) return false;
    	nextSum = 0;
    	for (int i = y; i < y + l; i++) {
    	    int j = x + l - 1 - (i - y);
    	    nextSum += grid[i][j];
    	}
    	if (sum != nextSum) return false;
    	return true;
    }
    
    public void init() {
    	prefixSumsR = new int[grid.length][grid[0].length];
    	prefixSumsC = new int[grid.length][grid[0].length];
    	for (int i = 0; i < grid.length; i++) {
    		prefixSumsR[i][0] = grid[i][0];
			for (int j = 1; j < grid[0].length; j++) {
				prefixSumsR[i][j] = grid[i][j] + prefixSumsR[i][j-1];
			}
		}
    	for (int i = 0; i < grid[0].length; i++) {
    		prefixSumsC[0][i] = grid[0][i];
    		for (int j = 1; j < grid.length; j++) {
    			prefixSumsC[j][i] = grid[j][i] + prefixSumsC[j-1][i];
    		}
    	}
    }
}