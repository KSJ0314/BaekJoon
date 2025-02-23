import java.io.*;
import java.util.*;

public class Main {
	static int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};	// 상, 하, 좌, 우
	static int N,M;
	static int[][] pArr, nArr;
	static boolean[][] visited;
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);
		
		int count = 0;
		while (!list.isEmpty()) {
			count++;
			nArr = copy();
			bfs();
			pArr = nArr;
			if (isSeparate()) break;
		}
		
		System.out.println(list.isEmpty() ? 0 : count);
	}
	
	private static boolean isSeparate() {
		visited = new boolean[N][M];
		int size = list.size();
		if (size == 0) return false;
		int[] coors = list.get(0);
		int connectCnt = connectCounting(coors[0], coors[1]);
		return size != connectCnt;
	}

	private static int connectCounting(int y, int x) {
		if (!isIn(y, x)) return 0;
		if (pArr[y][x] == 0) return 0;
		if (visited[y][x]) return 0;
		
		visited[y][x] = true;
		int cnt = 1;
		
		for (int[] del : dels) {
			int ny = y + del[0];
			int nx = x + del[1];
			cnt += connectCounting(ny, nx);
		}
		return cnt;
	}

	private static void bfs() {
		for (int i = 0 ; i < list.size(); i++) {
			int[] coor = list.get(i);
			int y = coor[0];
			int x = coor[1];
			
			for (int[] del : dels) {
				int ny = y + del[0];
				int nx = x + del[1];
				if (!isIn(ny, nx)) continue;
				if (pArr[ny][nx] <= 0 && nArr[y][x]>0) {
					nArr[y][x]--;
				}
			}
			if (nArr[y][x] <= 0) list.remove(i--);
		}
	}
	
	public static int[][] copy() {
		int[][] nArr = new int[N][];
		for (int i = 0; i < N; i++) {
			nArr[i] = pArr[i].clone();
		}
		return nArr;
	}

	public static boolean isIn(int y, int x) {
		return y>=0 && y<N && x>=0 && x<M;
	}

	public static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		pArr = new int[N][M];
		nArr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(strs[j]);
				pArr[i][j] = num;
				if (num != 0) {
					list.add(new int[] {i,j});
				}
			}
		}
		
	}
	
}