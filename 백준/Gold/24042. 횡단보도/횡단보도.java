import java.io.*;
import java.util.*;

public class Main {
	static class Edge {
		int to, time;
		Edge next;

		public Edge(int to, int time, Edge next) {
			this.to = to;
			this.time = time;
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

	static int N, M;
	static Edge[] edges;
	static long[] times;
	static PriorityQueue<Vertex> pq;

	public static void main(String[] args) throws IOException {
		init();

		while (!pq.isEmpty()) {
			Vertex crt = pq.poll();
			if (crt.weight > times[crt.no]) continue;
			if (crt.no == N) {
				System.out.println(crt.weight+1);
				break;
			}

			for (Edge e = edges[crt.no]; e != null; e = e.next) {
				long div = crt.weight / M;
				long t = div*M + e.time;
				
				if (crt.weight > t) {
					if (times[e.to] <= t+M)  continue;
					times[e.to] = t+M;
					pq.offer(new Vertex(e.to, t+M));
				} else {
					if (times[e.to] <= t)  continue;
					times[e.to] = t;
					pq.offer(new Vertex(e.to, t));
				}
			}
		}
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;

		strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);

		edges = new Edge[N + 1];
		times = new long[N + 1];
		Arrays.fill(times, Long.MAX_VALUE);
		times[1] = 0;
		pq = new PriorityQueue<>();

		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int to = Integer.parseInt(strs[0]);
			int from = Integer.parseInt(strs[1]);
			edges[to] = new Edge(from, i, edges[to]);
			edges[from] = new Edge(to, i, edges[from]);
		}
		pq.add(new Vertex(1, 0));
	}
}