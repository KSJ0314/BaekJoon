import java.io.*;

public class Main {
	static class Node{
		int to;
		Node next;
		public Node(int to, Main.Node next) {
			this.to = to;
			this.next = next;
		}
	}

	static int N, target;
	static int[] times, result;
	static Node[] outList, inList;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			init(br);
			dp(target);
			sb.append(result[target]).append("\n");
		}
		
		System.out.println(sb);
	}

	static void dp(int i) {
		for (Node node = inList[i]; node != null; node = node.next) {
			if (visited[i][node.to]) continue;
			dp(node.to);
		}
		
		result[i] += times[i];
	
		for (Node node = outList[i]; node != null; node = node.next) {
			visited[node.to][i] = true;
			result[node.to] = Math.max(result[node.to], result[i]);
		}
	}

	static void init(BufferedReader br) throws IOException {
		
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		int K = Integer.parseInt(strs[1]);
		times = new int[N+1];
		inList = new Node[N+1];
		outList = new Node[N+1];
		result = new int[N+1];
		visited = new boolean[N+1][N+1];
		
		strs = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			times[i] = Integer.parseInt(strs[i-1]);
		}
		
		for (int i = 0; i < K; i++) {
			strs = br.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			listAdd(inList, b, a);
			listAdd(outList, a, b);
		}
		
		target = Integer.parseInt(br.readLine());
	}

	static void listAdd(Node[] list, int a, int b) {
		Node node = new Node(b, list[a]);
		list[a] = node;
	}
}