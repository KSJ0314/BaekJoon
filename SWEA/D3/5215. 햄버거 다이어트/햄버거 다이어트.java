import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N,L,sum;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			init(br);
			
			subset(0, 0, 0);
			
			sb.append("#"+ test_case + " " + sum + "\n");
		}
		System.out.println(sb.toString());
	}
	
	
	public static void subset(int depth, int tSum, int kSum) {
		if (kSum > L) return;
		
		if (depth == N) {
			sum = Math.max(sum, tSum);
			return;
		}
			
		subset(depth+1, tSum+arr[depth][0], kSum+arr[depth][1]);
		subset(depth+1, tSum, kSum);
		
	}
	
	public static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		L = Integer.parseInt(strs[1]);
		arr = new int[N][2];
		sum = 0;
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(strs[0]);
			arr[i][1] = Integer.parseInt(strs[1]);
		}
	}
}