import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		double x, y;

		public Node(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Vertex implements Comparable<Vertex> {
		int no;
		double dist;

		public Vertex(int no, double dist) {
			this.no = no;
			this.dist = dist;
		}

		@Override
		public int compareTo(Vertex o) {
			return Double.compare(this.dist, o.dist);
		}
	}

	static int N;
	static Node[] nodes;
	static double[] dists;
	static PriorityQueue<Vertex> pq;

	public static void main(String[] args) throws IOException {
		init();
		
		while (!pq.isEmpty()) {
			Vertex crt = pq.poll();
			if (crt.no == 1) break;
			if (crt.dist > dists[crt.no]) continue;
			
			for (int i = 1; i < N+2; i++) {
				if (i == crt.no) continue;
				
				double dist = crt.dist + Math.abs(calDist(nodes[i], nodes[crt.no]) - 50) + 10;
				if (dists[i] <= dist) continue;
				dists[i] = dist;
				pq.offer(new Vertex(i, dist));
			}
		}
		System.out.println(dists[1]/5);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;

		double x,y;
		
		strs = br.readLine().split(" ");
		x = Double.parseDouble(strs[0]);
		y = Double.parseDouble(strs[1]);
		Node sNode = new Node(x, y);
		
		strs = br.readLine().split(" ");
		x = Double.parseDouble(strs[0]);
		y = Double.parseDouble(strs[1]);
		Node eNode = new Node(x, y);

		strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);	
		nodes = new Node[N+2];		
		nodes[0] = sNode;
		nodes[1] = eNode;

		for (int i = 2; i < N+2; i++) {
			strs = br.readLine().split(" ");
			x = Double.parseDouble(strs[0]);
			y = Double.parseDouble(strs[1]);

			Node node = new Node(x, y);
			nodes[i] = node;
		}
		
		pq = new PriorityQueue<>();		
		dists = new double[N+2];
		for (int i = 1; i < N+2; i++) {
			dists[i] = calDist(nodes[0], nodes[i]);
			pq.add(new Vertex(i, dists[i]));
		}
		
	}

	private static double calDist(Node node, Node node2) {
		return Math.sqrt(Math.pow((node.x - node2.x), 2) + Math.pow((node.y - node2.y), 2));
	}
}