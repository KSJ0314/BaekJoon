import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][3];
		
		int score = Integer.parseInt(br.readLine());
		dp[1][0] = dp[1][1] = score;
		for (int i = 2; i <= N; i++) {
			score = Integer.parseInt(br.readLine());
			
			dp[i][0] = dp[i-1][1] + score;
			dp[i][1] = dp[i-1][2] + score;
			dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]);
		}
		
		System.out.println(Math.max(dp[N][0], dp[N][1]));
	}
}