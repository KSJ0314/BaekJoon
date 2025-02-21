import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, min;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		init(br);
		subset(0,1,0, true);
		
		System.out.println(min);
	}

	
	public static void subset(int depth, int mul, int tot, boolean nothing) {
		if (depth == N) {
			if (nothing) return;
			min = Math.min(min, Math.abs(mul-tot));
			return;
		}
		
		subset(depth+1, mul, tot, nothing);
		
		nothing = false;
		subset(depth+1, mul*arr[depth][0], tot+arr[depth][1], nothing);
	}


	public static void init(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			String[] strs = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(strs[0]);
			arr[i][1] = Integer.parseInt(strs[1]);
		}
	}
	
}