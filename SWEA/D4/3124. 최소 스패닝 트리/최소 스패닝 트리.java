import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static class Edge implements Comparable<Edge>{
		int from, to, w;

		public Edge(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Solution.Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	static int V;
	static int[] p;
	static Edge[] edges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#"+t+" ");
			
			init(br);
			
			long sum = 0, cnt = V-1;
			for (Edge edge : edges) {
				if (!union(edge.from, edge.to)) continue;
				sum += (long)edge.w;
				if (--cnt == 0) break;
			}
			
			sb.append(sum);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean union(int a, int b) {
		int aR = find(a);
		int bR = find(b);
		
		if (aR == bR) return false;
		p[bR] = aR;
		return true;
	}

	static int find(int a) {
		if (a == p[a]) return a;
		return p[a] = find(p[a]);
	}

	static void init(BufferedReader br) throws IOException {
		String[] strs;
		strs = br.readLine().split(" ");
		
		V = Integer.parseInt(strs[0]);
		int E = Integer.parseInt(strs[1]);
		
		p = new int[V+1];
		edges = new Edge[E];
		
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
		
		for (int i = 0; i < E; i++) {
			strs = br.readLine().split(" ");
			int from = Integer.parseInt(strs[0]);
			int to = Integer.parseInt(strs[1]);
			int w = Integer.parseInt(strs[2]);
			
			edges[i] = new Edge(from, to, w);
		}
		
		Arrays.sort(edges);
	}
}