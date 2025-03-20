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
	static int[] inDegree;
	static Node[] outNode;
	static Deque<Integer> deque;
	static boolean[] isOffers;

	public static void main(String[] args) throws IOException {
		init();
		
		int cnt = N;
		StringBuilder sb = new StringBuilder();
		while (!deque.isEmpty()) {
			cnt--;
			int from = deque.pollFirst();
			isOffers[from] = true;
			sb.append(from).append("\n");
			
			for (Node node = outNode[from]; node != null; node = node.next) {
				if (isOffers[node.to]) {
					System.out.println(0);
					return;
				}
				if (--inDegree[node.to] == 0) deque.offerLast(node.to);
			}
		}
		if (cnt > 0) {
			System.out.println(0);
		} else {
			System.out.println(sb);
		}
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		inDegree = new int[N+1];
		outNode = new Node[N+1];
		isOffers = new boolean[N+1];
		deque = new ArrayDeque<>();
		
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int k = Integer.parseInt(strs[0]);
			int from = Integer.parseInt(strs[1]);
			for (int j = 2; j <= k; j++) {
				int to = Integer.parseInt(strs[j]);
				nodeAdd(from, to);
				inDegree[to]++;
				from = to;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) deque.offerLast(i);
		}
	}
	
	static void nodeAdd(int from, int to) {
		Node node = new Node(to, outNode[from]);
		outNode[from] = node;
	}
}