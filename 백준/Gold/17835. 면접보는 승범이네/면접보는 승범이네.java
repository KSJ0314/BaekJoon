import java.io.*;
import java.util.*;

public class Main {
	static class Edge {
		int to, dist;
		Edge next;

		public Edge(int to, int dist, Edge next) {
			this.to = to;
			this.dist = dist;
			this.next = next;
		}
	}

	static class Vertex implements Comparable<Vertex> {
		int no;
		long weight;

		public Vertex(int no, long weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.weight, o.weight);
		}
	}

	static int N, M, K;
	static Edge[] edges;
	static long[] dist;
	static PriorityQueue<Vertex> pq;

	public static void main(String[] args) throws IOException {
		init();

		while (!pq.isEmpty()) {
			Vertex crt = pq.poll();
			if (crt.weight > dist[crt.no]) continue;

			for (Edge e = edges[crt.no]; e != null; e = e.next) {
				long nd = crt.weight + e.dist;
				if (nd < dist[e.to]) {
					dist[e.to] = nd;
					pq.offer(new Vertex(e.to, nd));
				}
			}
		}

		int ansCity = 1;
		long ansVal = dist[1];
		for (int i = 2; i <= N; i++) {
			if (dist[i] > ansVal) {
				ansVal = dist[i];
				ansCity = i;
			}
		}

		System.out.println(ansCity);
		System.out.println(ansVal);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;

		strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		K = Integer.parseInt(strs[2]);

		edges = new Edge[N + 1];
		dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		pq = new PriorityQueue<>();

		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int u = Integer.parseInt(strs[0]);
			int v = Integer.parseInt(strs[1]);
			int c = Integer.parseInt(strs[2]);
			edges[v] = new Edge(u, c, edges[v]);
		}

		strs = br.readLine().split(" ");
		for (int i = 0; i < K; i++) {
			int no = Integer.parseInt(strs[i]);
			dist[no] = 0;
			pq.offer(new Vertex(no, 0));
		}
	}
}