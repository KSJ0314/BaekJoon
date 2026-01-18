import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int x, y, z, w;
		
		public Node(int x, int y, int z, int w) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			if (this.z != o.z) return Integer.compare(this.z, o.z);
			else return Integer.compare(this.w, o.w);
		}
	}
	static int N, M;
	static ArrayList<Node> list;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		init();
		StringBuilder res1 = new StringBuilder();
		long res2 = 0;
		for (int i = 0, end = N-1; i < end; i++) {
			if (i >= list.size()) {
				System.out.println(-1);
				return;
			}
			Node node = list.get(i);
			if (!union(node.x, node.y)) {
				end++;
				continue;
			}
			res1.append(node.z);
			res2 += node.w;
		}
		System.out.print(res1 + " " + res2);
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
			int x = Integer.parseInt(strs[0]);
			int y = Integer.parseInt(strs[1]);
			int z = Integer.parseInt(strs[2]);
			int w = Integer.parseInt(strs[3]);
			list.add(new Node(x, y, z, w));
		}
		Collections.sort(list);
		
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
}