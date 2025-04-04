import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
	static final boolean UP = true, DOWN = false;
	static int N, cnt;
	static boolean[][] arr;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#"+t+" ");
			
			init(br);
			counting();
			sb.append(cnt);
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void counting() {
		for (int i = 1; i <= N; i++) {
			check = new boolean[N+1];
			check[i] = true;
			find(i, UP);
			find(i, DOWN);
			if (IntStream.range(1, N+1).filter(idx -> check[idx]).count() == N) cnt++;
		}
	}

	private static void find(int a, boolean isUp) {
		for (int i = 1; i <= N; i++) {
			if (!arr[isUp?a:i][isUp?i:a]) continue;
			if (check[i]) continue;
			check[i] = true;
			find(i, isUp);
		}
	}

	static void init(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		arr = new boolean[N+1][N+1];
		cnt = 0;
		
		String[] strs;
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			
			arr[a][b] = true;
		}
	}
}