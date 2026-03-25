import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int from, cost;
		Node next;

		public Node(int from, int cost, Node next) {
			this.from = from;
			this.cost = cost;
			this.next = next;
		}
	}

	static class Vertex implements Comparable<Vertex> {
		int to, from, cost;

		public Vertex(int to, int from, int cost) {
			this.to = to;
			this.from = from;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	static int[] paths;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split("\\s+");
		int T = Integer.parseInt(strs[0]);
		
		sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			strs = br.readLine().split("\\s+");
			int N = Integer.parseInt(strs[0]);
			int M = Integer.parseInt(strs[1]);
			
			Node[] nodes = new Node[M];
			for (int i = 0; i < N; i++) {
				strs = br.readLine().split("\\s+");
				int to = Integer.parseInt(strs[0]);
				int from = Integer.parseInt(strs[1]);
				int cost = Integer.parseInt(strs[2]);
				
				nodes[to] = new Node(from, cost, nodes[to]);
				nodes[from] = new Node(to, cost, nodes[from]);
			}
			
			int[] costs = new int[M];
			Arrays.fill(costs, Integer.MAX_VALUE);
			costs[0] = 0;
			
			paths = new int[M];
			paths[M-1] = -1;
			
			PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
			pq.offer(new Vertex(0, 0, 0));
			
			while (!pq.isEmpty()) {
				Vertex crt = pq.poll();
				
				if (crt.cost > costs[crt.from]) continue;
				
				paths[crt.from] = crt.to;
				
				if (crt.from == M-1) break;
				
				for (Node node = nodes[crt.from]; node != null; node = node.next) {
					if (costs[node.from] <= costs[crt.from] + node.cost) continue;
					costs[node.from] = costs[crt.from] + node.cost;
					pq.offer(new Vertex(crt.from, node.from, costs[node.from]));
				}
			}
			
			sb.append("Case #"+test_case+": ");
			if (paths[M-1] != -1) {
				printPath(M-1);
				sb.append(M-1);
			} else {
				sb.append("-1");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}


	private static void printPath(int no) {
		if (no == 0) return;
		printPath(paths[no]);
		sb.append(paths[no]+" ");
	}
}