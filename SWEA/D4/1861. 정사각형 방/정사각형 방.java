import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static final int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};	// 상 하 좌 우
	static int N, cnt, start, max;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			init(br);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i,j,1);
					if (max <= cnt) {
						if (max < cnt) {
							start = arr[i][j];
						} else {
							start = Math.min(start ,arr[i][j]);
						}
						max = cnt;
					}
				}
			}
			sb.append("#"+test_case+" ").append(start+" "+max).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	static void dfs(int y, int x, int depth) {
		
		boolean isEnd = true;
		for (int[] del : dels) {
			int ny = y+del[0];
			int nx = x+del[1];
			
			if (!isIn(ny, nx)) continue;
			
			if (arr[y][x]+1 != arr[ny][nx]) continue;
			
			isEnd = false;
			dfs(ny, nx, depth+1);
		}
		
		if (isEnd) cnt = depth;
	}
	
	public static boolean isIn(int y, int x) {
		return y>=0 && y<N && x>=0 && x<N;
	}

	static void init(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		max = Integer.MIN_VALUE;
		start = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			String[] strs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(strs[j]);
				arr[i][j] = num;
			}
		}
	}

}