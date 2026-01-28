class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
    	int n = topRight.length;
    	long maxSize = 0;
    	for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				long diffX = Math.min(topRight[i][0],topRight[j][0])-Math.max(bottomLeft[i][0], bottomLeft[j][0]);
				long diffY = Math.min(topRight[i][1],topRight[j][1])-Math.max(bottomLeft[i][1], bottomLeft[j][1]);
				maxSize = Math.max(maxSize, Math.min(diffX,diffY));
			}
		}
		return maxSize*maxSize;
    }
}