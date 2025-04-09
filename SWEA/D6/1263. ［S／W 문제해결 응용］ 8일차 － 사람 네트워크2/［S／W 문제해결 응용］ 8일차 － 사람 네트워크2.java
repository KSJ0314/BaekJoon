import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	static final int INF = 10000;
	static int N;
	static int[][] adjArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#"+t+" ");
			
			init(br);
			floyd();
			sb.append(minDis());
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void floyd() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjArr[i][j] = Math.min(adjArr[i][j], adjArr[i][k]+ adjArr[k][j]);
				}
			}
		}
	}

	static int minDis() {
		int min = INF;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if (adjArr[i][j] != INF) sum += adjArr[i][j];
			}
			min = Math.min(min, sum);
		}
		return min;
	}

	static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		adjArr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(adjArr[i], INF);
			for (int j = 0; j < N; j++) {
				if (i == j) {
					adjArr[i][j] = 0;
					continue;
				}
				int num = Integer.parseInt(strs[i*N+j+1]);
				if (num == 1) adjArr[i][j] = 1;
			}
		}
	}
}