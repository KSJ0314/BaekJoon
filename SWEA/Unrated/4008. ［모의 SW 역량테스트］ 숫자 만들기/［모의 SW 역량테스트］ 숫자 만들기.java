import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N, max, min;
	static int[] operArr, numArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			init(br);
			
			bitPerm(1, numArr[0], 0);
			
			sb.append("#"+ test_case + " " + (max-min) + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void bitPerm(int depth, int sum, int flag) {
		if (depth == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		int operFlag = 0;
		
		for (int i = 0; i < N-1; i++) {
			if ((flag & 1<<i) != 0) continue;
			if (((int)Math.pow(2, operArr[i]) & operFlag) != 0) continue;
			operFlag |= 1<<operArr[i];
			bitPerm(depth+1, cal(sum, numArr[depth], operArr[i]),flag | 1<<i);
		}
	}
	
	public static int cal(int num, int num2, int operIdx) {
		int result = 0;
		switch (operIdx) {
			case 0: {
				result = num + num2;
				break;
			}
			case 1: {
				result = num - num2;
				break;
			}
			case 2: {
				result = num * num2;
				break;
			}
			case 3: {
				result = num / num2;
				break;
			}
		}
		return result;
	}
	
	public static void init(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		operArr = new int[N-1];
		numArr = new int[N];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		String[] strs = br.readLine().split(" ");
		for (int i = 0, k = 0; i < 4; i++) {
			for (int j = 0; j < Integer.parseInt(strs[i]); j++, k++) {
				operArr[k] = i;
			}
		}
		strs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(strs[i]);
		}
	}
}