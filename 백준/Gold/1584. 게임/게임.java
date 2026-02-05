import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static class Node implements Comparable<Node>{
		int r, c, hp;

		public Node(int r, int c, int hp) {
			this.r = r;
			this.c = c;
			this.hp = hp;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.hp, o.hp);
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0,0,0));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			for (int[] del : dels) {
				int nr = node.r+del[0];
				int nc = node.c+del[1];
				if (!isIn(nr,nc)) continue;
				
				int nhp = node.hp + map[nr][nc];
				if (map[nr][nc] == 2) continue;
				if (nr == 500 && nc == 500) {
					System.out.println(nhp);
					return;
				}
				
				map[nr][nc] = 2;
				
				pq.offer(new Node(nr, nc, nhp));
			}
		}
		System.out.println(-1);
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r <= 500 && c >= 0 && c <= 500;
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		map = new int[501][501];
		
		strs = br.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			int x1 = Integer.parseInt(strs[0]);
			int y1 = Integer.parseInt(strs[1]);
			int x2 = Integer.parseInt(strs[2]);
			int y2 = Integer.parseInt(strs[3]);
			
			for (int j = Math.min(y1, y2); j <= Math.max(y1, y2); j++) {
				for (int k = Math.min(x1, x2); k <= Math.max(x1, x2); k++) {
					map[j][k] = 1;
				}
			}
		}
		
		strs = br.readLine().split(" ");
		int M = Integer.parseInt(strs[0]);
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int x1 = Integer.parseInt(strs[0]);
			int y1 = Integer.parseInt(strs[1]);
			int x2 = Integer.parseInt(strs[2]);
			int y2 = Integer.parseInt(strs[3]);
			
			for (int j = Math.min(y1, y2); j <= Math.max(y1, y2); j++) {
				for (int k = Math.min(x1, x2); k <= Math.max(x1, x2); k++) {
					map[j][k] = 2;
				}
			}
		}
	}
}