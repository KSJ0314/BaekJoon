import java.io.*;
import java.util.*;

public class Main {
	static int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};	// 상, 하, 좌, 우
	static int[] coors;
	static int M,N;
	static boolean[][] visited;
	static List<Integer> areaList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		init(br);
		
		int count = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) continue;
				count++;
				areaList.add(dfs(i, j));
			}
		}
		Collections.sort(areaList);
		
		System.out.println(count);
		for (int area : areaList) {
			System.out.print(area+" ");
		}
	}
	
	private static int dfs(int y, int x) {
		if (!isIn(y, x)) return 0;
		if (visited[y][x]) return 0;
		visited[y][x] = true;
		
		int count = 1;
		for (int[] del : dels) {
			int ny = y + del[0];
			int nx = x + del[1];
			count += dfs(ny, nx);
		}
		return count;
	}
	
	public static boolean isIn(int y, int x) {
		return y>=0 && y<M && x>=0 && x<N;
	}

	public static void init(BufferedReader br) throws IOException {
		coors = new int[2];
		areaList = new ArrayList<>();
		
		String[] strs = br.readLine().split(" ");
		M = Integer.parseInt(strs[0]);
		N = Integer.parseInt(strs[1]);
		int K = Integer.parseInt(strs[2]);
		visited = new boolean[M][N];
		
		for (int i = 0; i < K; i++) {
			strs = br.readLine().split(" ");
			int sx = Integer.parseInt(strs[0]);
			int sy = Integer.parseInt(strs[1]);
			int ex = Integer.parseInt(strs[2]);
			int ey = Integer.parseInt(strs[3]);
			
			for (int j = sy; j < ey; j++) {
				for (int k = sx; k < ex; k++) {
					visited[j][k] = true;
				}
			}
		}
		
	}

}