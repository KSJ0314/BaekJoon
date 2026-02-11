import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	static int[][] dp;
	// dp[0] = i x | i-1 x
	// dp[1] = i o | i-1 x
	// dp[2] = i o | i-1 o
	
	public static void main(String[] args) throws IOException {
		init();
		
		for (int i = 1; i <= n; i++) {
			dp[i][0] = calMax(dp[i-1]);
			dp[i][1] = dp[i-1][0] + arr[i];
			dp[i][2] = dp[i-1][1] + arr[i];
		}
		System.out.println(calMax(dp[n]));
	}
	
	private static int calMax(int[] nums) {
		int max = 0;
		for (int num : nums) {
			max = Math.max(max, num);
		}
		return max;
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		n = Integer.parseInt(strs[0]);
		
		arr = new int[n+1];
		dp = new int[n+1][3];
		for (int i = 1; i <= n; i++) {
			strs = br.readLine().split(" ");
			arr[i] = Integer.parseInt(strs[0]);
		}
	}
}