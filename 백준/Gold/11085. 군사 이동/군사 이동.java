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
		int no, dist;

		public Vertex(int no, int dist) {
			this.no = no;
			this.dist = dist;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.dist, o.dist) * -1;
		}
	}
	static int p, w, c, v;
	static Node[] nodes;
	static int[] minDists;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		init();

		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.add(new Vertex(c, Integer.MAX_VALUE));
		while (!pq.isEmpty()) {
			Vertex crt = pq.poll();
			
			if (visited[crt.no]) continue;
			visited[crt.no] = true;
			
			for (Node node = nodes[crt.no]; node != null; node = node.next) {
				if (!visited[node.from] && minDists[node.from] < Math.min(crt.dist, node.dist)) {
					int dist = Math.min(crt.dist, node.dist);
					minDists[node.from] = dist;
					pq.offer(new Vertex(node.from, dist));
				}
			}
		}
		System.out.println(minDists[v]);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		p = Integer.parseInt(strs[0]);
		w = Integer.parseInt(strs[1]);
		
		strs = br.readLine().split(" ");
		c = Integer.parseInt(strs[0]);
		v = Integer.parseInt(strs[1]);
		
		nodes = new Node[p];
		minDists = new int[p];
		visited = new boolean[p];
		
		for (int i = 0; i < w; i++) {
			strs = br.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			int d = Integer.parseInt(strs[2]);
			
			nodes[a] = new Node(b, d, nodes[a]);
			nodes[b] = new Node(a, d, nodes[b]);
		}
	}
}