import java.io.*;
import java.util.*;

public class Main {
	static class Cell implements Comparable<Cell>{
		int y, x, cnt, dir;

		public Cell(int y, int x, int cnt, int dir) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public int compareTo(Cell o) {
			return Integer.compare(this.cnt, o.cnt);
		}
	}

	static int n, sy, sx, ey, ex;
	static int[][] map;
	static int[][] dels = {{1,0}, {0,1}, {-1,0}, {0,-1}};	// 하, 우, 상, 좌

	public static void main(String[] args) throws IOException {
		init();

		// dist[y][x][dir] = 최소 거울 수
		int[][][] dist = new int[n][n][4];
		for (int[][] a : dist) for (int[] b : a) Arrays.fill(b, Integer.MAX_VALUE);

		PriorityQueue<Cell> pq = new PriorityQueue<Cell>();
		for (int i = 0; i < 4; i++) {
			pq.add(new Cell(sy, sx, 0, i));
			dist[sy][sx][i] = 0;
		}

		while (!pq.isEmpty()) {
			Cell crt = pq.poll();

			if (crt.y == ey && crt.x == ex) {
				System.out.println(crt.cnt);
				return;
			}

			if (crt.cnt > dist[crt.y][crt.x][crt.dir]) continue;

			// 저장된 방향으로 쭉 직진
			int ny = crt.y + dels[crt.dir][0];
			int nx = crt.x + dels[crt.dir][1];
			for (; isIn(ny, nx); ny += dels[crt.dir][0], nx += dels[crt.dir][1]) {
				if (map[ny][nx] == 0) break; // 벽이면 스탑

				// 목적지를 만나면 직진 그대로 도착
				if (ny == ey && nx == ex) {
					if (crt.cnt < dist[ny][nx][crt.dir]) {
						dist[ny][nx][crt.dir] = crt.cnt;
						pq.add(new Cell(ny, nx, crt.cnt, crt.dir));
					}
					break;
				}

				if (map[ny][nx] == 1) {
					// 빈 칸 → 그냥 직진 계속
					continue;
				}

				if (map[ny][nx] == 2) {
					// 거울 설치 가능 칸
					// 거울 안 놓으면 직진 계속 (continue)
					// 거울 놓으면 내 방향 기준 +-1 방향으로 pq에 추가
					int left = (crt.dir + 3) % 4;
					int right = (crt.dir + 1) % 4;
					for (int nd : new int[]{left, right}) {
						if (crt.cnt + 1 < dist[ny][nx][nd]) {
							dist[ny][nx][nd] = crt.cnt + 1;
							pq.add(new Cell(ny, nx, crt.cnt + 1, nd));
						}
					}
					// 거울 안 놓고 직진 계속
				}
			}
		}
	}

	private static boolean isIn(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < n;
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;

		strs = br.readLine().split(" ");
		n = Integer.parseInt(strs[0]);
		map = new int[n][n];

		boolean isE = false;
		for (int i = 0, j = 0; i < n; i++, j = 0) {
			String str = br.readLine();
			for (char ch : str.toCharArray()) {
				switch (ch) {
					case '*': {
						map[i][j] = 0;
						break;
					}
					case '.': {
						map[i][j] = 1;
						break;
					}
					case '!': {
						map[i][j] = 2;
						break;
					}
					case '#': {
						map[i][j] = 1;
						if (isE) {
							ey = i;
							ex = j;
						} else {
							sy = i;
							sx = j;
							isE = true;
						}
						break;
					}
				}
				j++;
			}
		}
	}

	static void print(){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == sy && j == sx) {
					System.out.print("S ");
				} else if (i == ey && j == ex) {
					System.out.print("E ");
				} else {
					System.out.print(map[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
}