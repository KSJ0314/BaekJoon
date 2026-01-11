import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int r, c, dist;

		public Node(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			if (this.dist != o.dist) {
				return Integer.compare(this.dist, o.dist);
			} else if (this.r != o.r) {
				return Integer.compare(this.r, o.r);
			} else {
				return Integer.compare(this.c, o.c);
			}
		}
	}
	static int N, level, exp, goalExp, r, c, time;
	static int[][] arr;
	static int[][] dels = {{-1,0},{0,-1},{0,1},{1,0}};
	static PriorityQueue<Node> pQ;
	
	public static void main(String[] args) throws IOException {
		init();
		bfs();
		System.out.println(time);
	}

	public static void bfs() {
		boolean[][] isVisited = new boolean[N][N];
		isVisited[r][c] = true;
		
		while (!pQ.isEmpty()) {
			Node node = pQ.poll();
			int r = node.r;
			int c = node.c;
			int dist = node.dist;
			if (arr[r][c] != 0 && arr[r][c] < level) {
				pQ.clear();
				time += dist;
				exp++;
				if (exp == goalExp) {
					level++;
					goalExp = level;
					exp = 0;
				}
				isVisited = new boolean[N][N];
				dist = 0;
				arr[r][c] = 0;
				pQ.add(new Node(r, c, dist));
			}
			
			for (int[] del : dels) {
				int nr = r+del[0], nc = c+del[1];
				if (!isIn(nr, nc)) continue;
				if (isVisited[nr][nc]) continue;
				if (arr[nr][nc] > level) continue;
				isVisited[nr][nc] = true;
				pQ.add(new Node(nr, nc, dist+1));
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
		arr = new int[N][N];
		pQ = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
				if (arr[i][j] == 9) {
					r = i;
					c = j;
					arr[i][j] = 0;
					pQ.add(new Node(i, j, 0));
				}
			}
		}
		
		level = 2;
		exp = 0;
		goalExp = level;
		time = 0;
	}
}