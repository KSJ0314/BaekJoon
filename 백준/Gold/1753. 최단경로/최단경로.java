import java.io.*;
import java.util.*;

public class Main {
	static class Node{	// 인접 리스트 관리
		int to, weight;
		Node next;
		
		public Node(int to, int weight, Node next) {
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static class Vertex implements Comparable<Vertex>{	// PQ에 넣을 클래스

		int no, minDis;	// 정점 번호, 출발지에서 정점까지의 비용
		
		public Vertex(int no, int minDis) {
			this.no = no;
			this.minDis = minDis;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.minDis, o.minDis);
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int V,E,K;
	static Node[] nodes;
	static int[] minDis;
	static boolean[] visited;
	static PriorityQueue<Vertex> pQ;

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
		while (!pQ.isEmpty()){
			Vertex stopOver = pQ.poll();
			if (visited[stopOver.no]) continue;
			
			// if (stopOver.no == end) break;
			visited[stopOver.no] = true;
			
			for (Node node = nodes[stopOver.no]; node != null; node = node.next) {
				if (visited[node.to]) continue;
				if (minDis[node.to] <= stopOver.minDis+node.weight) continue;
				minDis[node.to] = stopOver.minDis+node.weight;
				pQ.offer(new Vertex(node.to, minDis[node.to]));
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
		
		pQ = new PriorityQueue<>();
		pQ.offer(new Vertex(K, minDis[K]));
	}
}