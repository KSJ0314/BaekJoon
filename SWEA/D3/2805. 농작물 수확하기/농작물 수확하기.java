import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			init(br);
			int sum = calSum();
			sb.append("#"+test_case+" ").append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static int calSum() {
		int h = N/2;
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			int d = Math.abs(h-i);
			for (int j = h-Math.abs(h-d); j <= h+Math.abs(h-d); j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}

	static void init(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] strs = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
	}

}