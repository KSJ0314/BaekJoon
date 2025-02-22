import java.io.*;
import java.util.*;

public class Main {
	static int[][] dels = {{0,-1,0},{0,1,0},{0,0,-1},{0,0,1},{-1,0,0},{1,0,0}};	// 상, 하, 좌, 우, 위 ,아래
	static Deque<int[]> que;
	static int[] coors;
	static int M,N,H,zero;
	static int[][][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		init(br);
		
		int count = 0;
		while (zero>0 && !que.isEmpty()) {
			bfs();
			count++;
		}
		
		System.out.println(zero == 0 ? count : -1);
	}
	
	private static void bfs() {
		int size = que.size();
		
		while (size-- > 0) {
			int[] coors = que.pollFirst();
			int z = coors[0];
			int y = coors[1];
			int x = coors[2];
			
			for (int[] del : dels) {
				int nz = z + del[0];
				int ny = y + del[1];
				int nx = x + del[2];
				if (!isIn(nz, ny, nx)) continue;
				
				if (arr[nz][ny][nx] == 0) {
					zero--;
					arr[nz][ny][nx] = 1;
					que.offerLast(new int[] {nz,ny,nx});
				}
			}
		}
		
	}
	
	public static boolean isIn(int z, int y, int x) {
		return z>=0 && z<H & y>=0 && y<N && x>=0 && x<M;
	}

	public static void init(BufferedReader br) throws IOException {
		coors = new int[3];
		que = new ArrayDeque<>();
		zero = 0;
		
		String[] strs = br.readLine().split(" ");
		M = Integer.parseInt(strs[0]);
		N = Integer.parseInt(strs[1]);
		H = Integer.parseInt(strs[2]);
		arr = new int[H][N][M];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				strs = br.readLine().split(" ");
				for (int k = 0; k < M; k++) {
					int num = Integer.parseInt(strs[k]);
					arr[i][j][k] = num;
					if (num == 1) {
						que.offerLast(new int[] {i,j,k});
					}
					if (num == 0) {
						zero++;
					}
				}
			}
		}
	}

}