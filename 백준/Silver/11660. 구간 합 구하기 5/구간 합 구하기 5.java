import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N,M;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		init(br);
		
		while (M-- >0) {
			String[] strs = br.readLine().split(" ");
			int x1 = Integer.parseInt(strs[0]);
			int y1 = Integer.parseInt(strs[1]);
			int x2 = Integer.parseInt(strs[2]);
			int y2 = Integer.parseInt(strs[3]);
			
			int prefixSum = arr[x2][y2]
					- arr[x2][y1-1]
					- arr[x1-1][y2]
					+ arr[x1-1][y1-1];
			sb.append(prefixSum).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	
	public static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		arr = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			strs = br.readLine().split(" ");
			for (int j = 1; j<= N; j++) {
				arr[i][j] = Integer.parseInt(strs[j-1]);
				arr[i][j] += arr[i-1][j];
				arr[i][j] += arr[i][j-1];
				arr[i][j] -= arr[i-1][j-1];
			}
		}
	}
	
}
