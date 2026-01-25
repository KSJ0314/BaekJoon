import java.io.*;
import java.util.*;

public class Main {
	static int N, max;
	static int[][] arr;
	static int[][] visited;
	
	public static void main(String[] args) throws IOException {
		init();
		dfs(0, 0, 1, 1);
		System.out.println(max);
	}

	private static void dfs(int idx, int cost, int dist, int flag) {
		max = Math.max(max, dist);
		for (int i = 0; i < N; i++) {
			if (i == idx) continue;
			if (arr[idx][i] < cost) continue;
			if ((flag&1<<i) != 0) continue;
			
			int nextFlag = flag|1<<i;
			if (visited[i][nextFlag] <= arr[idx][i]) continue;
			visited[i][nextFlag] = arr[idx][i];
			
			dfs(i, arr[idx][i], dist+1, nextFlag);
		}
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		
		N = Integer.parseInt(strs[0]);
		max = 0;
		arr = new int[N][N];
		visited = new int[N][1<<N];
		for (int i = 0; i < N; i++) {
		    Arrays.fill(visited[i], 10);
		}
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
	}
}