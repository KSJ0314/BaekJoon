import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		boolean[] dp = new boolean[n+1];
		
		dp[1] = true;
		for (int i = 2; i <= n; i++) {
			if (!dp[i-1]
					|| (i >= 3 && !dp[i-3])
					|| (i >= 4 && !dp[i-4])) {
				dp[i] = true;
				continue;
			}
		}
		
		System.out.println(dp[n] ? "SK" : "CY");
	}
	
}