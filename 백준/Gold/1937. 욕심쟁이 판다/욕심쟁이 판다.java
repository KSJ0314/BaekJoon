import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr, dp;
	static final int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};	// 상하좌우
	
	public static void main(String[] args) throws IOException {
		init();
		
		int maxDist = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				maxDist = Math.max(maxDist, dfs(i, j));
			}
		}
		System.out.println(maxDist);
	}

	private static int dfs(int r, int c) {
		if (dp[r][c] != -1) return dp[r][c];
		
		int maxDist = 1;
		for (int[] del : dels) {
			int nr = r + del[0];
			int nc = c + del[1];
			if (!isIn(nr, nc)) continue;
			if (arr[r][c] >= arr[nr][nc]) continue;
			maxDist = Math.max(maxDist, dfs(nr, nc)+1);
		}
		
		return dp[r][c] = maxDist;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		
		N = Integer.parseInt(strs[0]);
		arr = new int[N][N];
		dp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
				dp[i][j] = -1;
			}
		}
	}
}