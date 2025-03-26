
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[] visited;
	static int ans = Integer.MAX_VALUE;
	static int[] path;

	static void func(int depth, int from, int cost, int originalFrom) {
		
		if (depth == N) {
			if(arr[from][originalFrom] != 0) {
				cost += arr[from][originalFrom];
				ans = Math.min(ans, cost);
				return;
			}
		}

		for (int to = 0; to < N; to++) {
			if (!visited[to] && arr[from][to]!= 0) {
				visited[to] = true;
				func(depth + 1, to, cost + arr[from][to], originalFrom);
				visited[to] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			visited[i] = true;
			func(1, i, 0, i);
			visited[i] = false;
		}

		System.out.println(ans);

	}
}
