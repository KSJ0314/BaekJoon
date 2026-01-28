class Solution {
	public int[][] squares;
    public double separateSquares(int[][] squares) {
    	this.squares = squares;
    	
    	double y = 0;
    	for (int i = 0; i < squares.length; i++) {
    		y = Math.max(y, squares[i][1] + squares[i][2]);
		}
    	
    	y/=2;
    	double divide = y/2;
    	for (int i = 0; i < 100; i++) {
    		int same = isSame(y);
    		if (same == 2) y += divide;
    		else if (same == 1) y -= divide;
    		else break;
    		divide /= 2;
    	}
    	
    	double result = Math.round(y*100000)/(double)100000;
    	for (int i = 0; i < squares.length; i++) {
    		if (squares[i][1] < result && result < squares[i][1] + squares[i][2]) return result;
		}
    	
    	double maxUnderLine = 0;
    	for (int i = 0; i < squares.length; i++) {
    		if (squares[i][1] + squares[i][2] <= result) {
    			maxUnderLine = Math.max(maxUnderLine, squares[i][1] + squares[i][2]);
    		}
    	}
    	
		return maxUnderLine == 0 ? result : maxUnderLine;
    }
    
    public int isSame(double y) {
    	double square1 = 0, square2 = 0;
    	for (int i = 0; i < squares.length; i++) {
    		double above = 0, below = 0;
    		above = ((double)squares[i][2] + squares[i][1] - y) * squares[i][2];
    		below = ((double)y - squares[i][1]) * squares[i][2];
    		if (squares[i][1]+squares[i][2] < y) {
    			above = 0;
    			below = (double) squares[i][2] * squares[i][2];
    		} else if (squares[i][1] > y) {
    			above = (double) squares[i][2] * squares[i][2];
    			below = 0;
    		}
    		square1 += above;
    		square2 += below;
		}
    	if (Math.abs(square1 - square2) < 1e-5) return 0;
    	else if (square1 > square2) return 2;
    	else if (square1 < square2) return 1;
    	else return 0;
    }
}