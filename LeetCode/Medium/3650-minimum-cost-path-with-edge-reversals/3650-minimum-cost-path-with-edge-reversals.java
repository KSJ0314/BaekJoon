import java.util.*;

class Solution {
	class Edge{
		int to, weight;
		boolean isReverse;
		Edge next;
		
		public Edge(int to, int weight, boolean isReverse, Edge next) {
			this.to = to;
			this.weight = weight;
			this.isReverse = isReverse;
			this.next = next;
		}
	}
	
	class Vertex implements Comparable<Vertex>{
		int to, from, weight;
		boolean isReverse;

		public Vertex(int to, int from, int weight, boolean isReverse) {
			this.to = to;
			this.from = from;
			this.weight = weight;
			this.isReverse = isReverse;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public int minCost(int n, int[][] inputEdges) {
		Edge[] edges = new Edge[n];
		
		for (int[] edge : inputEdges) {
			edges[edge[0]] = new Edge(edge[1], edge[2], false, edges[edge[0]]);
			edges[edge[1]] = new Edge(edge[0], edge[2]*2, true, edges[edge[1]]);
		}

		int[] minDist = new int[n];
		for (int i = 1; i < n; i++) {
			minDist[i] = Integer.MAX_VALUE;
		}
		
		boolean[] visited = new boolean[n];
		boolean[] usedSwitch = new boolean[n];
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.add(new Vertex(0, 0, 0, false));
		
		while (!pq.isEmpty()) {
			Vertex vertex = pq.poll();
			if (visited[vertex.to]) continue;
			visited[vertex.to] = true;
			if (vertex.to == n-1) break;
			if (vertex.isReverse) usedSwitch[vertex.from] = true;
			
			for (Edge edge = edges[vertex.to]; edge != null; edge = edge.next) {
				if (visited[edge.to]) continue;
				if (edge.isReverse && usedSwitch[vertex.to]) continue;
				if (minDist[edge.to] <= vertex.weight + edge.weight) continue;
				int dist = vertex.weight + edge.weight;
				minDist[edge.to] = dist;
				pq.add(new Vertex(edge.to, vertex.to, dist, edge.isReverse));
			}
		}
		
        return visited[n-1] ? minDist[n-1] : -1;
    }
}