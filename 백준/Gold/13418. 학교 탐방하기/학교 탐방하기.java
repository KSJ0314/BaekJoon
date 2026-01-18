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
	static ArrayList<Node> list1, list2;	// 오르막길, 내리막길
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		init();
		int res1 = unionfind(list1);
		int res2 = unionfind(list2);
		System.out.println((int)(Math.pow(res1, 2)-Math.pow(res2, 2)));
	}

	private static int unionfind(ArrayList<Node> list) {
		makeUnion();
		int res = first, cnt = 0;
		for (Node node : list) {
			if (!union(node.a, node.b)) continue;
			res += node.c == 0 ? 1 : 0;
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
		
		list1 = new ArrayList<>();
		list2 = new ArrayList<>();
		strs = br.readLine().split(" ");
		first = Integer.parseInt(strs[2]) == 0 ? 1 : 0;
		
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			int c = Integer.parseInt(strs[2]);
			list1.add(new Node(a, b, c));
			list2.add(new Node(a, b, c));
		}
		Collections.sort(list1);
		Collections.sort(list2);
		Collections.reverse(list2);
	}
}