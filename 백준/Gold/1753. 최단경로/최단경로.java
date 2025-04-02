import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int to, weight;
		Node next;
		
		public Node(int to, int weight, Node next) {
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}
	static final int INF = Integer.MAX_VALUE;
	static int V,E,K;
	static Node[] nodes;
	static int[] minDis;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		init();
		dij();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(minDis[i] == INF ? "INF" : minDis[i]).append("\n");
		}
		System.out.println(sb);
	}

	static void dij() {
		for (int i = 1; i <= V; i++) {
			int stopOver = -1;
			int min = INF;
			for (int j = 1; j <= V; j++) {
				if (visited[j]) continue;
				if (min <= minDis[j]) continue;
				stopOver = j;
				min = minDis[j];
			}
			
			
			if (stopOver == -1) break;
			
			visited[stopOver] = true;
			for (Node node = nodes[stopOver]; node != null; node = node.next) {
				if (visited[node.to]) continue;
				minDis[node.to] = Math.min(minDis[node.to], min+node.weight);
			}
		}
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		
		V = Integer.parseInt(strs[0]);
		E = Integer.parseInt(strs[1]);
		K = Integer.parseInt(br.readLine());
		
		nodes = new Node[V+1];
		minDis = new int[V+1];
		visited = new boolean[V+1];
		
		for (int i = 0; i < E; i++) {
			strs = br.readLine().split(" ");
			int u = Integer.parseInt(strs[0]);
			int v = Integer.parseInt(strs[1]);
			int k = Integer.parseInt(strs[2]);
			
			nodes[u] = new Node(v, k, nodes[u]);
		}
		
		Arrays.fill(minDis, INF);
		minDis[K] = 0;
	}
}