import java.io.*;

public class Solution {
	static class Thing{		// 가독성을 위해 물건을 class로 저장
		int weight, value;
		public Thing(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
	
	static Thing[] things;
	static int N, K;
	static int[] dp;	// 공간 복잡도 압축을 위해 1차원 배열로 생성

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#"+t+" ");
			
			init(br);
			makeDp();
			sb.append(dp[K]);
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void makeDp() {
		for (Thing thing : things) {
			int w = thing.weight;
			int v = thing.value;
			
			// 중복 저장이 안되므로 뒤에서부터 저장
			// w 이상만 체크
			for (int j = K; j >= w; j--) {
				dp[j] = Math.max(dp[j], dp[j-w] + v);
			}
		}
	}

	public static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		
		things = new Thing[N];
		dp = new int[K+1];
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			int weight = Integer.parseInt(strs[0]);
			int value = Integer.parseInt(strs[1]);
			things[i] = new Thing(weight, value);
		}
	}
	
}