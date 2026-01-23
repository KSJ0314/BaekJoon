class Solution {
    public int solution(int[][] triangle) {
    	int[][] sums = new int[triangle.length][];
		sums[0] = new int[1];
    	sums[0][0] = triangle[0][0];
    	for (int i = 0; i < triangle.length-1; i++) {
    		sums[i+1] = new int[triangle[i+1].length];
    		for (int j = 0; j < i+1; j++) {
				sums[i+1][j] = Math.max(sums[i+1][j], sums[i][j] + triangle[i+1][j]);
				sums[i+1][j+1] = Math.max(sums[i+1][j+1], sums[i][j] + triangle[i+1][j+1]);
			}
    	}
    	int max = 0;
    	for (int i = 0; i < triangle.length; i++) {
			max = Math.max(max, sums[triangle.length-1][i]);
		}
        return max;
    }
}