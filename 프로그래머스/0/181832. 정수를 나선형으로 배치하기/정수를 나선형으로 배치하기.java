class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
		int num = 1;
		
		for (int i = 0; i < Math.ceil((double)n/2); i++) {
            answer[i][i] = num;
			int x = i;
			int y = i;
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < n-1 - (i*2); k++) {
					answer[y][x] = num;
					x += (j == 0) ? 1 : (j == 2) ? -1 : 0;
					y += (j == 1) ? 1 : (j == 3) ? -1 : 0;
					num++;
				}
			}
		}
        return answer;
    }
}