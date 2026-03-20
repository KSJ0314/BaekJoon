import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int from, dist;
		Node next;
		
		public Node(int from, int dist, Node next) {
			this.from = from;
			this.dist = dist;
			this.next = next;
		}
	}
	static class Vertex implements Comparable<Vertex>{
		int no, weight;

		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int n,m;
	static Node[] nodes;
	static int[] dists;
	
	public static void main(String[] args) throws IOException {
		init();
		dijk();
		System.out.println(dists[n]);
	}

	private static void dijk() {
		boolean[] visted = new boolean[n+1];
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(1, 0));
		
		while (!pq.isEmpty()) {
			Vertex crt = pq.poll();
			
			if (crt.no == n) break;
			if (visted[crt.no]) continue;
			visted[crt.no] = true;
			
			for (Node node = nodes[crt.no]; node != null; node = node.next) {
				if (dists[node.from] <= dists[crt.no] + node.dist) continue;
				dists[node.from] = dists[crt.no] + node.dist;
				pq.add(new Vertex(node.from, dists[node.from]));
			}
		}
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		n = Integer.parseInt(strs[0]);
		m = Integer.parseInt(strs[1]);
		
		nodes = new Node[n+1];
		
		for (int i = 0; i < m; i++) {
			strs = br.readLine().split(" ");
			int to = Integer.parseInt(strs[0]);
			int from = Integer.parseInt(strs[1]);
			int dist = Integer.parseInt(strs[2]);
			
			nodes[to] = new Node(from, dist, nodes[to]);
			nodes[from] = new Node(to, dist, nodes[from]);
		}
		
		dists = new int[n+1];
		for (int i = 1; i <= n; i++) {
			dists[i] = Integer.MAX_VALUE;
		}
		dists[1] = 0;
	}
}