class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length()+1, m = s2.length()+1;
        int[][] dp = new int[n][m];

        for (int i = 1; i < n; i++){
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }
        for (int i = 1; i < m; i++){
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
        }
        for (int i = 1; i < n; i++){
            int ascS1 = s1.charAt(i-1);
            for (int j = 1; j < m; j++){
                int ascS2 = s2.charAt(j-1);
                dp[i][j] = (ascS1 == ascS2) ? dp[i-1][j-1] : Math.min(dp[i-1][j] + ascS1, dp[i][j-1] + ascS2);
            }
        }
        return dp[n-1][m-1];
    }
}