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
		
		ArrayDeque<int[]> deq = new ArrayDeque<>();
		deq.add(new int[] {0,0,K});
		visited[0][0][K] = true;
		int cnt = 0;
		
		while(!deq.isEmpty()) {
			int size = deq.size();
			cnt++;
			while (size-- > 0) {
				int[] crt = deq.poll();
				int y = crt[0];
				int x = crt[1];
				int depth = crt[2];
				
				if (y == N-1 && x == M-1) {
					System.out.println(cnt);
					return;
				}
				
				for (int[] del : dels) {
					int ny = y + del[0];
					int nx = x + del[1];
					if (!isIn(ny, nx)) continue;
					int nDepth = map[ny][nx] == 1 ? depth-1 : depth;
					if (nDepth == -1) continue;
					if (visited[ny][nx][nDepth]) continue;
					visited[ny][nx][nDepth] = true;
					deq.add(new int[] {ny, nx, nDepth});
				}
			}
		}
		System.out.println(-1);
	}

	private static boolean isIn(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}
}