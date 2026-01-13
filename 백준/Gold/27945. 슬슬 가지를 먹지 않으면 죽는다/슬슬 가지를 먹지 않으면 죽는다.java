import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int a, b, weight;
		
		public Node(int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int N, M;
	static ArrayList<Node> list;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		init();
		int cnt = 1;
		for (int j = 0; cnt < N; cnt++) {
			Node node = list.get(j);
			for (; !union(node.a, node.b); node = list.get(++j)) {}
			if (node.weight > cnt)  break;
		}
		System.out.println(cnt);
	}

	public static boolean union(int a, int b) {
		int aR = find(a);
		int bR = find(b);
		if (aR == bR) return false;
		parents[bR] = aR;
		return true;
	}

	private static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			list.add(new Node(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), Integer.parseInt(strs[2])));
		}
		Collections.sort(list);
		
		parents = new int[N+1];
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}
}