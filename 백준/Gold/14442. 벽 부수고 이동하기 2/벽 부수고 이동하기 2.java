import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static final int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N, M, K;
	static int[][] arr;
	static boolean[][][] visited;
	static Deque<int[]> deque = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);
		int cnt = 0;
		while (!deque.isEmpty()) {
			cnt++;
			if (bfs()) {
				System.out.println(cnt);
				return;
			}
		}
		System.out.println(-1);
	}
	
	static boolean bfs() {
		int size = deque.size();
		
		while (size-- > 0) {
			int[] coors = deque.pollFirst();
			int y = coors[0], x = coors[1], k = coors[2];
			if (y==N-1 && x==M-1) return true;
			
			for (int[] del : dels) {
				int ny = y+del[0], nx = x+del[1], nk = k;
				
				if (!isIn(ny, nx)) continue;
				
				if (arr[ny][nx] == 1) {
					if (nk == 0) continue;
					nk--;
				}
				
				if (visited[ny][nx][nk]) continue;
				visited[ny][nx][nk] = true;
				
				deque.offerLast(new int[] {ny,nx,nk});
			}
		}
		
		return false;
	}

	static boolean isIn(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}

	static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		K = Integer.parseInt(strs[2]);
		deque.offerLast(new int[] {0,0,K});
		
		arr = new int[N][M];
		visited = new boolean[N][M][K+1];
		visited[0][0][K] = true;
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
	}
	
}