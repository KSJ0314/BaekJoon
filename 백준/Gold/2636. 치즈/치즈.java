import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N,M, remain;
	static int[][] arr;
	static boolean[][] isOutside;
	
	public static void main(String[] args) throws IOException {
		init();
		
		int temp, cnt=0;
		while (true) {
			temp = remain;
			melt();
			if (remain == 0) break;
			
			isOutside = new boolean[N][M];
			outsideUpdate(0,0);
			cnt++;
		}
		
		System.out.println(cnt);
		System.out.println(temp);
	}
	
	static void melt() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int[] del : dels) {
					int ni = i+del[0];
					int nj = j+del[1];
					if (isIn(ni, nj)&&isOutside[ni][nj]&&arr[i][j]==1) {
						arr[i][j] = 0;
						remain--;
						continue;
					}
				}
			}
		}
	}

	static void outsideUpdate(int y, int x) {
		if (!isIn(y, x)) return;
		if (isOutside[y][x] || arr[y][x] != 0) return;
		
		isOutside[y][x] = true;
		
		for (int[] del : dels) {
			outsideUpdate(y + del[0], x + del[1]);
		}
	}

	static boolean isIn(int y, int x) {
		return y>=0 && y<N && x>=0 && x<M;
	}
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		arr = new int[N][M];
		isOutside = new boolean[N][M];
		remain = 0;
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(strs[j]);
				arr[i][j] = num;
				if (num != 0) remain++;
			}
		}
	}
}