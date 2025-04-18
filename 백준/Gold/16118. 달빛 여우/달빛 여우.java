import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node>{
		int to;
		double weight;
		Node next;
		boolean isDouble;

		public Node(int to, double weight, Node next) {
			this(to, weight, next, true);
		}
		public Node(int to, double weight, Node next, boolean isDouble) {
			this.to = to;
			this.weight = weight;
			this.next = next;
			this.isDouble = isDouble;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	static final long INF = Integer.MAX_VALUE;
	static int N;
	static double[] dist_fox;
	static double[][] dist_wolf;
	static boolean[] visited_fox;
	static boolean[][] visited_wolf;
	static PriorityQueue<Node> pq_fox, pq_wolf;
	static Node[] nodes_fox, nodes_wolf;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();

		init();
		dij_fox();
		dij_wolf();
		
		int cnt = 0;
		for (int i = 0; i <= N; i++) {
			if (dist_fox[i] < Math.min(dist_wolf[0][i],dist_wolf[1][i])) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	static void dij_fox() {
		while (!pq_fox.isEmpty()) {
			Node node = pq_fox.poll();
			if (visited_fox[node.to]) continue;
			visited_fox[node.to] = true;
			
			for (Node n = nodes_fox[node.to]; n != null; n = n.next) {
				if (dist_fox[n.to] > dist_fox[node.to] + n.weight) {
					dist_fox[n.to] = dist_fox[node.to] + n.weight;
					pq_fox.offer(new Node(n.to, dist_fox[n.to], nodes_fox[n.to]));
				}
			}
		}
	}
	
	static void dij_wolf() {
		while (!pq_wolf.isEmpty()) {
			Node node = pq_wolf.poll();
			
			int idx = node.isDouble ? 0 : 1;
			if (visited_wolf[idx][node.to]) continue;
			visited_wolf[idx][node.to] = true;
			
			for (Node n = nodes_wolf[node.to]; n != null; n = n.next) {
				if (dist_wolf[idx^1][n.to] > dist_wolf[idx][node.to] + (node.isDouble? n.weight/2 : n.weight*2)) {
					dist_wolf[idx^1][n.to] = dist_wolf[idx][node.to] + (node.isDouble? n.weight/2 : n.weight*2);
					pq_wolf.offer(new Node(n.to, dist_wolf[idx^1][n.to], nodes_wolf[n.to], !node.isDouble));
				}
			}
		}
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		strs =  br.readLine().split(" ");
		
		N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		
		nodes_fox = new Node[N+1];
		dist_fox = new double[N+1];
		visited_fox = new boolean[N+1];
		nodes_wolf = new Node[N+1];
		dist_wolf = new double[2][N+1];
		visited_wolf = new boolean[2][N+1];
		Arrays.fill(dist_fox, INF);
		Arrays.fill(dist_wolf[0], INF);
		Arrays.fill(dist_wolf[1], INF);
		dist_fox[1] = 0;
		dist_wolf[0][1] = 0;
		
		pq_fox = new PriorityQueue<>();
		pq_wolf = new PriorityQueue<>();
		
		for (int i = 0; i < M; i++) {
			strs =  br.readLine().split(" ");
			int from = Integer.parseInt(strs[0]);
			int to = Integer.parseInt(strs[1]);
			int weight = Integer.parseInt(strs[2]);
			
			nodes_fox[from] = new Node(to, weight, nodes_fox[from]);
			nodes_fox[to] = new Node(from, weight, nodes_fox[to]);
			nodes_wolf[from] = new Node(to, weight, nodes_wolf[from]);
			nodes_wolf[to] = new Node(from, weight, nodes_wolf[to]);
		}
		
		pq_fox.offer(new Node(1, 0, nodes_fox[1]));
		pq_wolf.offer(new Node(1, 0, nodes_wolf[1]));
	}

}