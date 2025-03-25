import java.io.*;

public class Main {
	static int N, min;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		init();
		combi(1, 0, 0, 1);
		System.out.println(min);
	}

	static void combi(int depth, int tot, int num,int flag) {
		if (tot > min) return;
		if (depth == N) {
			if (arr[num][0] != 0) min = Math.min(min, tot+arr[num][0]);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1<<i) != 0) continue;
			if (arr[num][i] == 0) continue;
			combi(depth+1, tot+arr[num][i], i, flag|1<<i);
		}
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		min = Integer.MAX_VALUE;
		
		String[] strs;
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
	}
}