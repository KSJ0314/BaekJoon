import java.io.*;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		per(0);
		print();
	}

	static boolean per(int depth) {
		if (isBad(depth)) return false;
		if (depth == N) {
			return true;
		}
		
		for (int i = 1; i <= 3; i++) {
			nums[depth]=i;
			if (per(depth+1)) return true;
		}
		
		return false;
	}

	static boolean isBad(int depth) {
		int a,b;
		for (int i = 1; i <= depth/2; i++) {	// 부분 수열 크기
			for (int j = 0; j <= depth-(i*2); j++) {	// 부분 수열 시작 index
				for (int k = j; k <= depth-(i*2); k+=i) {
					a = numsToInt(k, i-1);
					b = numsToInt(k+i, i-1);
					if (a==b) return true;
				}
			}
		}
		return false;
	}
	
	static int numsToInt(int s, int e) {
		int num = 0;
		for (int i = s; i <= s+e; i++) {
			num += nums[i];
			if (i != s+e) num*=10;
		}
		return num;
	}

	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(nums[i]);
		}
		System.out.println(sb);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
	}
}