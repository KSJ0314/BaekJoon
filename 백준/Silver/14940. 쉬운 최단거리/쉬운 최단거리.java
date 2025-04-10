import java.io.*;
import java.util.*;

public class Main {
	static int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N, M;
	static int[][] map, countArr;
	static Deque<Integer> deque;

	public static void main(String[] args) throws IOException {
		init();
		bfs();
		print();
	}

	static void bfs() {
		for (int count = 1; !deque.isEmpty(); count++) {
			for (int size = deque.size(); size > 0; size--) {
				int coor = deque.pollFirst();
				int y = coor/1000;
				int x = coor%1000;
				
				for (int[] del : dels) {
					int ny = y + del[0];
					int nx = x + del[1];
					if (!isIn(ny, nx)) continue;
					if (countArr[ny][nx] != -1) continue;
					if (map[ny][nx] == 0) continue;
					countArr[ny][nx] = count;
					deque.offerLast(ny*1000 + nx);
				}
			}
		}
	}

	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(countArr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static boolean isIn(int y, int x) {
		return y>=0 && y<N && x>=0 && x<M;
	}
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		deque = new ArrayDeque<>();
		
		strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		map = new int[N][M];
		countArr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(countArr[i], -1);
			strs = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(strs[j]);
				map[i][j] = num;
				if (num == 2) {
					deque.offerLast(i*1000+j);
					countArr[i][j] = 0;
				} else if (num == 0){
					countArr[i][j] = 0;
				}
			}
		}
	}
}