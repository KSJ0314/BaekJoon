import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int N, M, min;
	static int[] tikets, plans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			init(br);
			backtrack(0, 0);
			sb.append("#"+test_case+" ").append(min).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	

	static void backtrack(int depth, int tot) {
		if (tot > min) {
			return;
		}
		if (depth >= 12) {
			min = tot;
			return;
		}
		
		int plan = plans[depth];
		if (plan == 0) {
			backtrack(depth+1, tot);
			return;
		}
		
		int cost1Month = Math.min(tot + tikets[0]*plan, tot + tikets[1]);
		backtrack(depth+1, cost1Month);
		backtrack(depth+3, tot + tikets[2]);
	}


	static void init(BufferedReader br) throws IOException {
		tikets = new int[3];
		plans = new int[12];
		
		String[] strs = br.readLine().split(" ");
		for (int i = 0; i < 3; i++) {
			tikets[i] = Integer.parseInt(strs[i]);
		}
		min = Integer.parseInt(strs[3]);
		
		strs = br.readLine().split(" ");
		for (int i = 0; i < 12; i++) {
			plans[i] = Integer.parseInt(strs[i]);
		}
	}

}