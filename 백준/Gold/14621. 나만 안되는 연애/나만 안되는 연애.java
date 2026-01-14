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
	static boolean[] isMans;
	static ArrayList<Node> list;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		init();
		if (list.size() == 0) {
			System.out.println(-1);
			return;
		}
		int sum = 0;
		for (int i = 0, j = 0; i < N-1; i++) {
			Node node = list.get(j);
			for (; !union(node.a, node.b); node = list.get(++j)) {
				if (j >= list.size()-1) {
					System.out.println(-1);
					return;
				}
			}
			sum += node.weight;
		}
		System.out.println(sum);
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
		isMans = new boolean[N+1];
		
		strs = br.readLine().split(" ");
		for (int i = 0; i < strs.length; i++) {
			isMans[i+1] = strs[i].equals("M");
		}
		
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			if (isMans[a] == isMans[b]) continue;
			list.add(new Node(a, b, Integer.parseInt(strs[2])));
		}
		Collections.sort(list);
		
		parents = new int[N+1];
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}
}