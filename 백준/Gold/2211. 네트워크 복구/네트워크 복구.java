import java.io.*;
import java.util.*;

public class Main {
	static class Edge{
		int to, from, dist;
		Edge next;
		
		public Edge(int to, int from, int dist, Edge next) {
			this.to = to;
			this.from = from;
			this.dist = dist;
			this.next = next;
		}
	}
	static class Vertex implements Comparable<Vertex>{
		int to, from, weight;

		public Vertex(int to, int from, int weight) {
			this.to = to;
			this.from = from;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		StringBuilder sb = new StringBuilder();
		strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		
		Edge[] edges = new Edge[N+1];
		int[] dists = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int to = Integer.parseInt(strs[0]);
			int from = Integer.parseInt(strs[1]);
			int dist = Integer.parseInt(strs[2]);
			edges[from] = new Edge(to, from, dist, edges[from]);
			edges[to] = new Edge(from, to, dist, edges[to]);
		}
		for (int i = 1; i <= N; i++) {
			dists[i] = Integer.MAX_VALUE;
		}
		dists[1] = 0;
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(1, -1, 0));
		
		sb.append(N-1).append("\n");
		for (int cnt = 0; !pq.isEmpty() && cnt < N;) {
			Vertex crt = pq.poll();
			if (visited[crt.to]) continue;
			cnt++;
			visited[crt.to] = true;
			if (crt.from != -1) sb.append(crt.to+" "+crt.from).append("\n");
			
			for (Edge edge = edges[crt.to]; edge != null; edge = edge.next) {
				if (visited[edge.to]) continue;
				if (dists[edge.to] <= dists[crt.to] + edge.dist) continue;
				dists[edge.to] = dists[crt.to] + edge.dist;
				pq.offer(new Vertex(edge.to, edge.from, dists[edge.to]));
			}
			
		}
		System.out.println(sb);
	}
}