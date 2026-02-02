import java.io.*;
import java.util.*;

public class Main {
	static class Edge{
		int to, from, weight;
		Edge next;
		
		public Edge(int to, int from, int weight, Main.Edge next) {
			this.to = to;
			this.from = from;
			this.weight = weight;
			this.next = next;
		}
	}
	static class Vertex implements Comparable<Vertex>{
		int to, weight;

		public Vertex(int no, int weight) {
			this.to = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int T = Integer.parseInt(strs[0]);
		
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			strs = br.readLine().split(" ");
			N = Integer.parseInt(strs[0]);
			int d = Integer.parseInt(strs[1]);
			int c = Integer.parseInt(strs[2]);
			
			Edge[] edges = new Edge[N+1];
			int[] dists = new int[N+1];
			boolean[] visited = new boolean[N+1];
			
			for (int i = 0; i < d; i++) {
				strs = br.readLine().split(" ");
				int to = Integer.parseInt(strs[0]);
				int from = Integer.parseInt(strs[1]);
				int weight = Integer.parseInt(strs[2]);
				edges[from] = new Edge(to, from, weight, edges[from]);
			}
			for (int i = 1; i <= N; i++) {
				dists[i] = Integer.MAX_VALUE;
			}
			dists[c] = 0;
			
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(c, 0));
			
			int cnt = 0;
			int lastIdx = -1;
			while (!pq.isEmpty()) {
				Vertex crt = pq.poll();
				if (visited[crt.to]) continue;
				visited[crt.to] = true;
				lastIdx = crt.to;
				
				for (Edge edge = edges[crt.to]; edge != null; edge = edge.next) {
					if (visited[edge.to]) continue;
					if (dists[edge.to] <= dists[crt.to] + edge.weight) continue;
					dists[edge.to] = dists[crt.to] + edge.weight;
					pq.offer(new Vertex(edge.to, dists[edge.to]));
				}
				cnt++;
			}
			sb.append(cnt+" "+dists[lastIdx]).append("\n");
		}
		System.out.println(sb);
	}
}