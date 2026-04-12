import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int K = Integer.parseInt(strs[1]);
		int D = Integer.parseInt(strs[2]);
		
		ArrayDeque<int[]> rules = new ArrayDeque<>();
		for (int i = 0; i < K; i++) {
			strs = br.readLine().split(" ");
			int A = Integer.parseInt(strs[0]);
			int B = Integer.parseInt(strs[1]);
			int C = Integer.parseInt(strs[2]);
			
			rules.addLast(new int[] {A, B, C});
		}
		
		int left = 1, right = N, ans = 0;
		while (left <= right) {
			int mid = (left + right ) / 2;
			
			long cnt = 0;
			for (int[] rule : rules) {
				if (mid < rule[0]) continue;
				int end = Math.min(rule[1], mid);
				cnt += (end-rule[0])/rule[2] +1;
                if (cnt >= D) break;
			}
			
			if (cnt >= D) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid +1;
			}
		}
		
		System.out.println(ans);
	}
}