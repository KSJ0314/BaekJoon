import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int a, b, c;
		
		public Node(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.c, o.c);
		}
	}
	static int N, M, first;
	static ArrayList<Node> list;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		init();
		int res = unionfind(list);
		System.out.println(res);
	}

	private static int unionfind(ArrayList<Node> list) {
		makeUnion();
		int res = 0, cnt = 0;
		for (Node node : list) {
			if (!union(node.a, node.b)) continue;
			res += node.c;
			if (++cnt == N-1) break;
		}
		return res;
	}

	public static void makeUnion() {
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	public static boolean union(int a, int b) {
		int aR = find(a);
		int bR = find(b);
		if (aR == bR) return false;
		parents[bR] = aR;
		return true;
	}

	public static int find(int a) {
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
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			int c = Integer.parseInt(strs[2]);
			list.add(new Node(a, b, c));
		}
		Collections.sort(list);
	}
}