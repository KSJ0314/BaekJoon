import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int to;
		Node next;
		public Node(int to, Main.Node next) {
			this.to = to;
			this.next = next;
		}
	}
	static int N;
	static int[] indegree;
	static Node[] nodes;
	static Queue<Integer> deque;

	public static void main(String[] args) throws IOException {
		init();
		StringBuilder sb = new StringBuilder();
		while (!deque.isEmpty()) {
			int from = deque.poll();
			sb.append(from).append(" ");
			
			for (Node node = nodes[from]; node != null; node = node.next) {
				if (--indegree[node.to] == 0) deque.offer(node.to);
			}
		}
			
		System.out.println(sb);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		nodes = new Node[N+1];
		indegree = new int[N+1];
		deque = new PriorityQueue<>();
		
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int from = Integer.parseInt(strs[0]);
			int to = Integer.parseInt(strs[1]);
			nodeAdd(from, to);
			indegree[to]++;
		}
		
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) deque.offer(i);
		}
	}
	
	static void nodeAdd(int from, int to) {
		Node node = new Node(to, nodes[from]);
		nodes[from] = node;
	}
}