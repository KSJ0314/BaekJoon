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
		int no, cost;

		public Vertex(int no, int cost) {
			this.no = no;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split("\\s+");
		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		int X = Integer.parseInt(strs[2]);
		int Y = Integer.parseInt(strs[3]);
		
		Node[] nodes = new Node[N];
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split("\\s+");
			int to = Integer.parseInt(strs[0]);
			int from = Integer.parseInt(strs[1]);
			int cost = Integer.parseInt(strs[2]);
			
			nodes[to] = new Node(from, cost, nodes[to]);
			nodes[from] = new Node(to, cost, nodes[from]);
		}
		
		int[] costs = new int[N];
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[Y] = 0;
		
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.offer(new Vertex(Y, 0));
		
		int cnt = 0;
		int totalCost = 0;
		int totalDay = 1;
		while (!pq.isEmpty()) {
			Vertex crt = pq.poll();
			
			if (crt.cost > costs[crt.no]) continue;
			if (crt.cost * 2 > X) {
				totalDay = -1;
				break;
			}
			
			totalCost += crt.cost * 2;
			if (totalCost > X) {
				totalDay++;
				totalCost = crt.cost * 2;
			}
			
			if (++cnt == N) break;
			
			for (Node node = nodes[crt.no]; node != null; node = node.next) {
				if (costs[node.from] <= costs[crt.no] + node.cost) continue;
				costs[node.from] = costs[crt.no] + node.cost;
				pq.offer(new Vertex(node.from, costs[node.from]));
			}
		}
		System.out.println(totalDay);
	}
}