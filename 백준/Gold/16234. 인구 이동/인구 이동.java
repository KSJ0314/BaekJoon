import java.io.*;
import java.util.*;

public class Main {
	static int N, L, R, level, moveCnt, moveSum;
	static int[][] arr;
	static int[][] dels = {{0,-1},{0,1},{-1,0},{1,0}};
	static int[][] isVisited;
	
	public static void main(String[] args) throws IOException {
		init();
		
		int cnt = -1;
		for (boolean isEnd = false; !isEnd; cnt++) {
			isVisited = new int[N][N];
			level = 1;
			isEnd = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (isVisited[i][j] != 0) continue;
					moveCnt = 0;
					moveSum = 0;
					bfs(i, j);
					if (moveCnt > 0) {
						move(level);
						isEnd = false;
						level++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void move(int level) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (isVisited[i][j] == level) arr[i][j] = moveSum / moveCnt;
			}
		}
	}

	public static void bfs(int i, int j) {
		for (int[] del : dels) {
			int ni = i+del[0], nj = j+del[1];
			if (!isIn(ni, nj)) continue;
			if (isVisited[ni][nj] != 0) continue;

			int diff = Math.abs(arr[i][j] - arr[ni][nj]);
			if (L <= diff && diff <= R) {
				if (moveCnt == 0) {
					isVisited[i][j] = level;
					moveSum = arr[i][j];
					moveCnt = 1;
				}
				isVisited[ni][nj] = level;
				moveSum += arr[ni][nj];
				moveCnt++;
				bfs(ni, nj);
			}
		}
	}

	public static boolean isIn(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < N;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		
		N = Integer.parseInt(strs[0]);
		L = Integer.parseInt(strs[1]);
		R = Integer.parseInt(strs[2]);
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
	}
}