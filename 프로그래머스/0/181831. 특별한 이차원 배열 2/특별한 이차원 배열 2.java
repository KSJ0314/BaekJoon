class Solution {
    public int solution(int[][] arr) {
        int n = arr.length;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i][j] != arr[j][i]) {
                    return 0;
                }
			}
		}
        return 1;
    }
}