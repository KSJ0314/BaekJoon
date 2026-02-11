import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	static int[] dp;
	// dp[i][0] = i x | i-1 x | i-2 x
	// dp[i][1] = i x | i-1 x | i-2 o
	// dp[i][2] = i x | i-1 o | i-2 x
	// dp[i][3] = i x | i-1 o | i-2 o
	// dp[i][4] = i o | i-1 x | i-2 x
	// dp[i][5] = i o | i-1 x | i-2 o
	// dp[i][6] = i o | i-1 o | i-2 x
	
	public static void main(String[] args) throws IOException {
		init();
		
		for (int i = 0; i < n; i++) {
			int xx = Math.max(dp[0], dp[1]);
			int xo = Math.max(dp[2], dp[3]);
			int ox = Math.max(dp[4], dp[5]);
			int oo = dp[6];
			
			dp[0] = xx;
			dp[1] = xo;
			dp[2] = ox;
			dp[3] = oo;
			dp[4] = xx + arr[i];
			dp[5] = xo + arr[i];
			dp[6] = ox + arr[i];
		}
		System.out.println(calMax(dp));
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
		
		arr = new int[n];
		dp = new int[7];
		for (int i = 0; i < n; i++) {
			strs = br.readLine().split(" ");
			arr[i] = Integer.parseInt(strs[0]);
		}
	}
}