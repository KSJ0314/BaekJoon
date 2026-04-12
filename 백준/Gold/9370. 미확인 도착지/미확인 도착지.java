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
			return Integer.compare(this.dist, o.dist);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		int T = Integer.parseInt(strs[0]);
		
		for (int test_case = 1; test_case <= T; test_case++) {
			strs = br.readLine().split(" ");
			int n = Integer.parseInt(strs[0]);
			int m = Integer.parseInt(strs[1]);
			int t = Integer.parseInt(strs[2]);
			
			Node[] nodes = new Node[n+1];
			int[] minDists = new int[n+1];
			
			strs = br.readLine().split(" ");
			int s = Integer.parseInt(strs[0]);
			int g = Integer.parseInt(strs[1]);
			int h = Integer.parseInt(strs[2]);
			
			Arrays.fill(minDists, Integer.MAX_VALUE);
			minDists[s] = 0;
			
			for (int i = 0; i < m; i++) {
				strs = br.readLine().split(" ");
				int a = Integer.parseInt(strs[0]);
				int b = Integer.parseInt(strs[1]);
				int d = Integer.parseInt(strs[2]);
				
				if ((a != g || b != h) && (a != h || b != g)) {
					d = d*2;
				} else {
					d = d*2 -1;
				}
				
				nodes[a] = new Node(b, d, nodes[a]);
				nodes[b] = new Node(a, d, nodes[b]);
			}
			
			HashSet<Integer> xs = new HashSet<>();
			
			for (int i = 0; i < t; i++) {
				strs = br.readLine().split(" ");
				int x = Integer.parseInt(strs[0]);
				xs.add(x);
			}
			
			TreeSet<Integer> res = new TreeSet<>();
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.add(new Vertex(s, 0));
			while (!pq.isEmpty()) {
				Vertex crt = pq.poll();
				
				if (minDists[crt.no] < crt.dist) continue;
				
				
				for (Node node = nodes[crt.no]; node != null; node = node.next) {
					if (minDists[node.from] > crt.dist + node.dist) {
						int dist = crt.dist + node.dist;
						minDists[node.from] = dist;
						pq.offer(new Vertex(node.from, dist));
					}
				}
			}
			for (int x : xs) {
				if (minDists[x] != Integer.MAX_VALUE && minDists[x] % 2 == 1) {
					res.add(x);
				}
			}
			for (int r : res) {
				System.out.print(r+" ");
			}
			System.out.println();
		}
	}
}