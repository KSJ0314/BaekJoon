class Solution {
  public int solution(int m, int n, int[][] puddles) {
  	final int MOD = 1_000_000_007;
  	int[][] dp = new int[m+1][n+1];
  	boolean[][] isPuddles = new boolean[m+1][n+1];
  	for (int[] puddle : puddles) {
  		isPuddles[puddle[0]][puddle[1]] = true;
  	}
  	dp[0][1] = 1;
  	for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (isPuddles[i][j]) continue;
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
			}
		}
  	return dp[m][n];
  }
}