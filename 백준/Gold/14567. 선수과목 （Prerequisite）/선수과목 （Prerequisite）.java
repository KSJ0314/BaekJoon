import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] result;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		init();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(dp(i)).append(" ");
		}
		System.out.println(sb);
	}

	static int dp(int i) {
		if (result[i] != 0) return result[i];
		int max = 0;
		for (int j = 1; j <= N; j++) {
			if (arr[i][j] == 0) continue;
			max = Math.max(max, dp(j));
		}
		
		return result[i] = max+1;
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		
		arr = new int[N+1][N+1];
		result = new int[N+1];
		
		boolean[] v = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			v[b] = true;
			arr[b][a] = 1;
		}
	}
}