import java.io.*;

// 2차원 배열 사용과 비교했을 때 메모리 차이 큼
// 53792KB / 14612KB (1차원)
public class Main {
	static class Thing{		// 가독성을 위해 물건을 class로 저장
		int w, v;
		public Thing(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
	
	static Thing[] things;
	static int N, K;
	static int[] dp;	// 공간 복잡도 압축을 위해 1차원 배열로 생성

	public static void main(String[] args) throws IOException {
		init();
		makeDp();
		System.out.println(dp[K]);
	}
	
	public static void makeDp() {
		for (Thing thing : things) {
			// 중복 저장이 안되므로 뒤에서부터 저장
			// w 이상만 체크
			for (int j = K; j >= thing.w; j--) {
				dp[j] = Math.max(dp[j], dp[j-thing.w] + thing.v);
			}
		}
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		
		things = new Thing[N];
		dp = new int[K+1];
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			things[i] = new Thing(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
		}
	}
	
}