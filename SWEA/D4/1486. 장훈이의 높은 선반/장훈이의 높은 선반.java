import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N,B, min;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			init(br);
			subset(0, 0);
			sb.append("#"+ test_case + " " + min + "\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void subset(int depth, int tot) {
		if (depth == N) {
			if (tot>=B) {
				min = Math.min(min, tot-B);
			}
			return;
		}
		
		subset(depth+1, tot);
		subset(depth+1, tot+arr[depth]);
	}

	public static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		B = Integer.parseInt(strs[1]);
		min = Integer.MAX_VALUE;
		arr = new int[N];
		
		strs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
	}
}