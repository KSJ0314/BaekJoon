import java.io.*;

// N개의 앱 중 c의 합이 최소가 되도록 선택
//  => N개의 앱 중에 제외할 앱을 선택, c의 합이 최대가 되도록
public class Main {
	static int N, M, C;
	static int[][] apps;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		init();
		dp();
		System.out.println(min());
	}

	static void dp() {
		for (int[] app : apps) {
			for (int i = C; i >= app[1]; i--) {
				dp[i] = Math.max(dp[i], dp[i-app[1]]+app[0]);
			}
		}
	}

	static int min() {
		for (int i = 0; i < C; i++) {
			if (dp[i] >= M) return i;
		}
		return C;
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		apps = new int[N][2];
		C = 0;
		
		for (int j = 0; j < 2; j++) {
			strs = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(strs[i]);
				apps[i][j] = num;
				
				if (j == 1) C += num;
			}
		}
		
		dp = new int[C+1];
	}
}