import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean[] visited;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
			
		init(br);
		
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			if (per(1, i)) {
				System.out.println(1);
				return;
			}
			visited[i] = false;
		}
		
		System.out.println(0);
	}

	static boolean per(int depth, int num) {
		if (depth == 5) return true;
		
		for (int next : list[num]) {
			if (visited[next]) continue;
			visited[next] = true;
			if (per(depth+1, next)) return true;
			visited[next] = false;
		}
		return false;
	}

	static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		list = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int a =Integer.parseInt(strs[0]);
			int b =Integer.parseInt(strs[1]);
			list[a].add(b);
			list[b].add(a);
		}
	}
}