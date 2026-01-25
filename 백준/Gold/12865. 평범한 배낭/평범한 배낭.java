import java.io.*;

// 2차원 배열 사용과 비교했을 때 메모리 차이 큼
// 53792KB / 14612KB (1차원)
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int K = Integer.parseInt(strs[1]);
		
		int[] dp = new int[K+1];
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
            int w = Integer.parseInt(strs[0]);
            int v = Integer.parseInt(strs[1]);
            
			// 1차원 배열로, 중복 저장이 안되므로 뒤에서부터 저장
			// w 이상만 체크
			for (int j = K; j >= w; j--) {
				dp[j] = Math.max(dp[j], dp[j-w] + v);
			}
		}
		System.out.println(dp[K]);
	}
}