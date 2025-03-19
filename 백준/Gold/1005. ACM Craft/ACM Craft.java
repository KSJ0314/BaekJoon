import java.io.*;
import java.util.*;

public class Main {

	static int N, target;
	static int[] times, result;
	static HashSet<Integer>[] outList, inList;
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
		if (inList[i] != null) {
			for (int n : inList[i]) {
				if (visited[i][n]) continue;
				dp(n);
			}
		}
		
		result[i] += times[i];
		
		if (outList[i] != null) {
			for (int n : outList[i]) {
				visited[n][i] = true;
				result[n] = Math.max(result[n], result[i]);
			}
		}
	}

	static void init(BufferedReader br) throws IOException {
		
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		int K = Integer.parseInt(strs[1]);
		times = new int[N+1];
		inList = new HashSet[N+1];
		outList = new HashSet[N+1];
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

	static void listAdd(HashSet<Integer>[] list, int a, int b) {
		if (list[a] == null) list[a] = new HashSet<>();
		list[a].add(b);
	}
}