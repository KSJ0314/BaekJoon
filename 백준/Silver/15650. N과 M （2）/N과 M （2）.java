import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		nums = new int[M];
		
		combi(0,0);
		System.out.println(sb.toString());
	}

	public static void combi(int depth, int start) {
		if (depth == M) {
			sbAppend();
			return;
		}
		
		for (int i = start; i < N; i++) {
			nums[depth] = i+1;
			combi(depth+1, i+1);
		}
	}

	// 숫자를 다 뽑았을 때 수행할 로직, 결과 값을 StringBuilder에 출력 형식에 맞게 저장
	public static void sbAppend() {
		for (int i = 0; i < M; i++) {
			sb.append(nums[i]+" ");
		}
		sb.append("\n");
	}
}