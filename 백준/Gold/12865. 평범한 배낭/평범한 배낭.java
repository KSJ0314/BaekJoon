import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[][] things, dp; 

	public static void main(String[] args) throws IOException {
		init();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = dp[i-1][j];
				if (j >= things[i][0]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-things[i][0]]+things[i][1]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		
		things = new int[N+1][2];
		dp = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			strs = br.readLine().split(" ");
			things[i][0] = Integer.parseInt(strs[0]);
			things[i][1] = Integer.parseInt(strs[1]);
		}
	}
	
}