import java.io.*;

public class Main {
	static int N;
	static int[][] graph;
	static boolean[] notDefault;
	
	public static void main(String[] args) throws IOException {
		init();
		dp(N);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (notDefault[i]) continue;
			sb.append(i+" ").append(graph[N][i]).append("\n");
		}
		System.out.println(sb);
	}

	static void dp(int from) {
		for (int to = 1; to <= N; to++) {
			if (graph[from][to] == 0) continue;
			if (notDefault[to]) dp(to);
		}
		
		for (int to = 1; to <= N; to++) {
			int k = graph[to][from];
			if (k == 0) continue;
			for (int i = 1; i <= N; i++) {
				graph[to][i] += graph[from][i]*k;
			}
			graph[to][from] = 0;
		}
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		graph = new int[N+1][N+1];
		notDefault = new boolean[N+1];
		
		String[] strs;
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int from = Integer.parseInt(strs[0]);
			int to = Integer.parseInt(strs[1]);
			int k = Integer.parseInt(strs[2]);
			
			notDefault[from] = true;
			graph[from][to] = k;
		}
	}
}