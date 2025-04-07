import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] apps;	// [n]개의 app에 대한 [m, c]
	static int[] dp, sum;

	public static void main(String[] args) throws IOException {
		init();
		dp();
		System.out.println(sum[1] - dp[M]);
	}

	static void dp() {
		for (int[] app : apps) {
			for (int i = M; i >= app[0]; i--) {
				dp[i] = Math.max(dp[i], dp[i-app[0]]+app[1]);
			}
		}
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		apps = new int[N][2];
		sum = new int[2];
		
		for (int j = 0; j < 2; j++) {
			strs = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				apps[i][j] = Integer.parseInt(strs[i]);
				sum[j] += apps[i][j];
			}
		}
		
		M = sum[0]-M;
		dp = new int[M+1];
	}
}