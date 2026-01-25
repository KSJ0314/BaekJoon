import java.io.*;

public class Main {
	static int M, N;
	static int[][] arr, cnts;
	static final int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};	// 상하좌우
	
	public static void main(String[] args) throws IOException {
		init();
		dfs(0, 0);
		System.out.println(Math.max(cnts[0][0], 0));
	}

	private static int dfs(int r, int c) {
		if (r == M-1 && c == N-1) return cnts[M-1][N-1] = 1;

		int cnt = 0;
		for (int[] del : dels) {
			int nr = r + del[0];
			int nc = c + del[1];
			if (!isIn(nr, nc)) continue;
			if (arr[r][c] <= arr[nr][nc]) continue;
			if (cnts[nr][nc] == -1) continue;
			if (cnts[nr][nc] != 0) {
				cnt += cnts[nr][nc];
			} else {
				cnt += dfs(nr, nc);
			}
		}
		if (cnt == 0) {
			cnts[r][c] = -1;
			return 0;
		}
		return cnts[r][c] = cnt;
	}
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < M && c >= 0 && c < N;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		
		M = Integer.parseInt(strs[0]);
		N = Integer.parseInt(strs[1]);
		arr = new int[M][N];
		cnts = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
	}
}