import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		init();
		dp();
		System.out.println(dp[N]);
	}
	static void dp() {
		for (int i = 2; i <= N; i++) {
			int min = dp[i-1];
			if (i % 2 == 0) min = Math.min(min, dp[i/2]);
			if (i % 3 == 0) min = Math.min(min, dp[i/3]);
			dp[i] = min+1;
		}
	}
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
	}
}