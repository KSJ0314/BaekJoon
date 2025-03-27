import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static class Node{
		int x,y;
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double tax;
		
		public Edge(int from, int to, double tax) {
			this.from = from;
			this.to = to;
			this.tax = tax;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.tax, o.tax);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", tax=" + tax + "]";
		}
	}
	
	static int N;
	static double E;
	static int[] p;
	static Node[] nodes;
	static Edge[] edges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#"+t+" ");
			
			init(br);
			
			int cnt = N-1;
			double sum = 0;
			for (Edge edge : edges) {
				if (!union(edge.from, edge.to)) continue;
				sum += edge.tax;
				if (--cnt == 0) break;
			}
			sb.append(Math.round(sum));
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		p[bRoot] = aRoot;
		return true;
	}

	static int find(int a) {
		if (a == p[a]) return a;
		return p[a] = find(p[a]);
	}

	static void init(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		String[] strs;
		p = new int[N];
		nodes = new Node[N];
		int size = (N*(N-1))/2;
		edges = new Edge[size];
		
		for (int i = 0; i < N; i++) {	// union-find를 위한 p 배열 초기화
			p[i] = i;
			nodes[i] = new Node();
		}
			
		strs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {	// 각 섬들의 x좌표 초기화
			nodes[i].x = Integer.parseInt(strs[i]);
		}
		strs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {	// 각 섬들의 y좌표 초기화
			nodes[i].y = Integer.parseInt(strs[i]);
		}
		E = Double.parseDouble(br.readLine());
		
		O: for (int i = 0, k = 0; i < N; i++) {	// 각 섬들을 잇는 간선 초기화
			for (int j = i; j < N; j++, k++) {
				if (j == i) {
					k--;
					continue;
				}
				
				double tax = calTax(i, j);
				edges[k] = new Edge(i, j, tax);
			}
		}
		Arrays.sort(edges);	// 간선을 가중치로 정렬
	}

	static double calTax(int a, int b) {
		int aX = nodes[a].x;
		int aY = nodes[a].y;
		int bX = nodes[b].x;
		int bY = nodes[b].y;
		
		return E * (Math.pow(Math.abs(aX-bX), 2) + Math.pow(Math.abs(aY-bY), 2));
	}
}