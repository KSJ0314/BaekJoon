import java.io.*;
import java.util.*;

public class Main {
	static class Fireball {
		int m,s,d;
		public Fireball(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static int N, M, K;
	static Deque<Fireball>[][] fireballs;
	static int[][] dels = {
		{-1, 0},
		{-1, 1},
		{0, 1},
		{1, 1},
		{1, 0},
		{1, -1},
		{0, -1},
		{-1, -1},
	};
	
	public static void main(String[] args) throws IOException {
		init();
		
		for (int i = 0; i < K; i++) {
			move();
			split();
		}
		System.out.println(calSumM());
	}
	
	private static void move() {
		int[][] sizes = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sizes[i][j] = fireballs[i][j].size();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < sizes[i][j]; k++) {
					Fireball fb = fireballs[i][j].pollFirst();
					int nr = i+dels[fb.d][0]*fb.s;
					int nc = j+dels[fb.d][1]*fb.s;
					if (nr >= N) nr %= N;
					else if (nr < 0) nr = nr%N == 0 ? 0 : N + nr%N;
					if (nc >= N) nc %= N;
					else if (nc < 0) nc = nc%N == 0 ? 0 : N + nc%N;
					
					fireballs[nr][nc].addLast(fb);
				}
			}
		}
	}
	
	private static void split() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int size = fireballs[i][j].size();
				if (size < 2) continue;
				boolean odd = false, even = false;
				int nm = 0;
				int ns = 0;
				for (int k = 0; k < size; k++) {
					Fireball fb = fireballs[i][j].pollFirst();
					if (fb.d % 2 == 0) even = true;
					else odd = true;
					nm += fb.m;
					ns += fb.s;
				}
				nm /= 5;
				ns /= size;
				if (nm == 0) continue;
				if (odd && even) {
					fireballs[i][j].addLast(new Fireball(nm, ns, 1));
					fireballs[i][j].addLast(new Fireball(nm, ns, 3));
					fireballs[i][j].addLast(new Fireball(nm, ns, 5));
					fireballs[i][j].addLast(new Fireball(nm, ns, 7));
				} else {
					fireballs[i][j].addLast(new Fireball(nm, ns, 0));
					fireballs[i][j].addLast(new Fireball(nm, ns, 2));
					fireballs[i][j].addLast(new Fireball(nm, ns, 4));
					fireballs[i][j].addLast(new Fireball(nm, ns, 6));
				}
			}
		}
	}

	private static int calSumM() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (Fireball fb : fireballs[i][j]) {
					sum += fb.m;
				}
			}
		}
		return sum;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		K = Integer.parseInt(strs[2]);
		
		fireballs = new ArrayDeque[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				fireballs[i][j] = new ArrayDeque<>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int r = Integer.parseInt(strs[0]) - 1;
			int c = Integer.parseInt(strs[1]) - 1;
			int m = Integer.parseInt(strs[2]);
			int s = Integer.parseInt(strs[3]);
			int d = Integer.parseInt(strs[4]);
			
			fireballs[r][c].addLast(new Fireball(m, s, d));
		}
		
	}
}