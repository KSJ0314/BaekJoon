import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] indegree;
	static List<Integer>[] list;
	static Deque<Integer> deque;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		init();
		StringBuilder sb = new StringBuilder();
		
		while (!deque.isEmpty()) {
			int a = deque.pollFirst();
			sb.append(a).append(" ");
			
			if (list[a] == null) continue;
			for (int b : list[a]) {
				if (visited[b]) continue;
				if (--indegree[b] != 0) continue;
				visited[b] = true;
				deque.offerLast(b);
			}
		}
		System.out.println(sb);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		
		indegree = new int[N+1];
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		deque = new ArrayDeque<>();
		
		while(M-- >0) {
			strs = br.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			indegree[b]++;
			listAdd(a, b);
		}
		
		for (int i = 1; i <= N; i++) {
			if (indegree[i] != 0) continue;
			deque.offerLast(i);
			visited[i] = true;
		}
	}

	static void listAdd(int a, int b) {
		if (list[a] == null) list[a] = new ArrayList<>();
		list[a].add(b);
	}
}