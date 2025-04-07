import java.io.*;
import java.util.*;

public class Main {
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
		init();
		
		makeDp();
		
		System.out.println(dp[K]);
	}
	
	public static void makeDp() {
		for (int i = 1; i <= N; i++) {
			int w = things[i].weight;
			int v = things[i].value;
			
			// 중복 저장이 안되므로 뒤에서부터 저장
			// w 이상만 체크
			for (int j = K; j >= w; j--) {
				dp[j] = Math.max(dp[j], dp[j-w] + v);
			}
		}
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		
		things = new Thing[N+1];
		dp = new int[K+1];
		
		for (int i = 1; i <= N; i++) {
			strs = br.readLine().split(" ");
			int weight = Integer.parseInt(strs[0]);
			int value = Integer.parseInt(strs[1]);
			things[i] = new Thing(weight, value);
		}
	}
	
}