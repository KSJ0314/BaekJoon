import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static class Node {
		int start, end, weight;
		Node next;
		
		public Node(int start, int end, int weight, Node next) {
			this.start = start;
			this.end = end;
			this.weight = weight;
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
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[N+1];
		int[] minDist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Vertex> pQ = new PriorityQueue<>();
		int INF = 1000000000; 
		
		String strs[];
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int start = Integer.parseInt(strs[0]);
			int end = Integer.parseInt(strs[1]);
			int weight = Integer.parseInt(strs[2]);
			nodes[start] = new Node(start, end, weight, nodes[start]);
		}
		
		strs = br.readLine().split(" ");
		int first = Integer.parseInt(strs[0]);
		int last = Integer.parseInt(strs[1]);
		
		Arrays.fill(minDist, INF);
		minDist[first] = 0;
		
		pQ.offer(new Vertex(first, minDist[first]));
		
		while (!pQ.isEmpty()) {
			Vertex crt = pQ.poll();
			if (crt.no == last) break;
			if (visited[crt.no]) continue;
			
			visited[crt.no] = true;
			
			for (Node node = nodes[crt.no]; node != null; node = node.next) {
				if (!visited[node.end] && minDist[node.end] > minDist[node.start] + node.weight) {
					int dist = minDist[node.start] + node.weight;
					minDist[node.end] = dist;
					pQ.offer(new Vertex(node.end, dist));
				}
			}
		}
		
		System.out.println(minDist[last]);
	}

}