import java.io.*;

public class Solution {
	
	static int N, max;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#"+t+" ");
			
			N = Integer.parseInt(br.readLine());
			max = 0;
			dp = new int[N+1];
			
			String[] strs = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(strs[i]);
				dp[num] = dp[num-1]+1;
				max = Math.max(max, dp[num]);
			}
			
			sb.append(N-max).append("\n");
		}
		System.out.println(sb);
	}
}