import java.io.*;

public class Main {
	static final int[][] dels = {{-1,1},{0,1},{1,1}};
	static int N, M, cnt;
	static char[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);
		for (int i = 0; i < N; i++) {
			dfs(i, 0);
		}
		
		System.out.println(cnt);
	}

	private static boolean dfs(int y, int x) {
		if (!isIn(y, x)) return false;
		if (arr[y][x] == 'x') return false;
		if (visited[y][x]) return false;
		
		visited[y][x] = true;
		
		if (x == M-1) {
			cnt++;
			return true;
		}
		
		for (int[] del : dels) {
			if (dfs(y + del[0], x + del[1])) return true;
		}
		return false;
	}

	static boolean isIn(int y, int x) {
		return y>=0 && y<N && x>=0 && x<M;
	}

	public static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		arr = new char[N][M];
		visited = new boolean[N][M];
		cnt = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
	}
	
}