import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int M, N, countZero;
	static int[][] arr;
	static class Tomato{
		int r, c;

		public Tomato(int r, int c) {
			this.r = r;
			this.c = c;
		}
	};
	static Deque<Tomato> deq;
	
	public static void main(String[] args) throws IOException {
		init();
		int result = bfs();
		System.out.println(result);
	}
	
	private static int bfs() {
		int[][] dels = {
			{0,-1},		// 상
			{0,1},		// 하
			{-1, 0},	// 좌
			{1, 0}		// 우
		};
		
		int result = 1;
		while(!deq.isEmpty()) {
			Tomato tomato = deq.pollFirst();
			
			for (int[] del : dels) {
				int nr = tomato.r + del[0];
				int nc = tomato.c + del[1];
				
				if (!isIn(nr, nc)) continue;
				if (arr[nr][nc] != 0) continue;
				
				arr[nr][nc] += arr[tomato.r][tomato.c] + 1;
				result = arr[nr][nc];
				countZero--;
				deq.addLast(new Tomato(nr, nc));
			}
		}
		
		return (countZero == 0) ? result-1 : -1;
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		M = Integer.parseInt(strs[0]);
		N = Integer.parseInt(strs[1]);
		arr = new int[N][M];
		deq = new ArrayDeque<>();
		countZero = 0;
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(strs[j]);
				arr[i][j] = num;
				if (num == 1) deq.addLast(new Tomato(i, j));
				else if (num == 0) countZero++;
			}
		}
	}
}