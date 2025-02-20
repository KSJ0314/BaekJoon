import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N,M;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		init(br);
		
		for (int i = 0; i < M; i++) {
			String[] strs = br.readLine().split(" ");
			int s = Integer.parseInt(strs[0]);
			int e = Integer.parseInt(strs[1]);
			int sum = nums[e] - nums[s-1];
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	
	public static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		nums = new int[N+1];
		
		strs = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(strs[i-1]) + nums[i-1];
		}
	}
	
}