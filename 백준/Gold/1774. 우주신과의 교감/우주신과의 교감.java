import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int a, b;
		double dist;
		
		public Edge(int a, int b, double dist) {
			this.a = a;
			this.b = b;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.dist, o.dist);
		}
	}
	static int N, M, cnt;
	static int[][] coors;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		init();
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for (int i = 1; i < N; i++) {
			for (int j = i+1; j <= N; j++) {
				if (isUnion(i, j)) continue;
				double dist = Math.sqrt(Math.pow(Math.abs(coors[i][0] - coors[j][0]),2) + Math.pow(Math.abs(coors[i][1] - coors[j][1]),2));
				pq.add(new Edge(i, j, dist));
			}
		}
		
		double totalDist = 0;
		while (!pq.isEmpty() && cnt < N) {
			Edge edge = pq.poll();
			if (unionFind(edge.a, edge.b)) {
				totalDist += edge.dist;
			}
		}
		System.out.printf("%.2f", totalDist);
	}
	

	private static boolean unionFind(int a, int b) {
		int aR = find(a);
		int bR = find(b);
		
		if (aR == bR) return false;

		cnt++;
		parents[bR] = aR;
		return true;
	}
	
	private static boolean isUnion(int a, int b) {
		return find(a) == find(b);
	}

	private static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

	private static void makeUnion() {
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}


	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);

		coors = new int[N+1][2];
		makeUnion();
		
		for (int i = 1; i <= N; i++) {
			strs = br.readLine().split(" ");
			coors[i][0] = Integer.parseInt(strs[0]);
			coors[i][1] = Integer.parseInt(strs[1]);
		}
		
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			unionFind(a, b);
		}
	}
}