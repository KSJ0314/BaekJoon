import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] map;
	static boolean[][][] visited;
	static int[][] dels = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		init();
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		K = Integer.parseInt(strs[2]);
		
		
		map = new int[N][M];
		visited = new boolean[N][M][K+1];
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		// 0은 이동 가능, 1은 이동 불가능
		ArrayDeque<int[]> deq = new ArrayDeque<>();
		deq.add(new int[] {0,0,K});
		for (int i = K; i >= 0; i--) {
			visited[0][0][i] = true;
		}
		int cnt = 0;
		
		while(!deq.isEmpty()) {
			int size = deq.size();
			cnt++;
			while (size-- > 0) {
				int[] crt = deq.poll();
				int y = crt[0];
				int x = crt[1];
				if (y == N-1 && x == M-1) {
					System.out.println(cnt);
					return;
				}
				int depth = crt[2];
				
				for (int[] del : dels) {
					int ny = y + del[0];
					int nx = x + del[1];
					if (!isIn(ny, nx)) continue;
					if (map[ny][nx] == 1) {
						if (depth == 0) continue;
						if (visited[ny][nx][depth-1]) continue;
						for (int i = depth-1; i >= 0; i--) {
							visited[ny][nx][i] = true;
						}
						deq.add(new int[] {ny, nx, depth-1});
					} else {
						if (visited[ny][nx][depth]) continue;
						for (int i = depth; i >= 0; i--) {
							visited[ny][nx][i] = true;
						}
						deq.add(new int[] {ny, nx, depth});
					}
				}
			}
		}
		System.out.println(-1);
	}

	private static boolean isIn(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}
}