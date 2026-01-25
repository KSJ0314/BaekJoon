import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strs = br.readLine();
		
		int T = Integer.parseInt(strs);
		int[] inputs = new int[T];
		for (int i = 0; i < T; i++) {
			inputs[i] = Integer.parseInt(br.readLine());
		}
		
		long[][] ress = new long[65][10];
		long[] cnts = new long[65];
		for (int i = 0; i < 10; i++) {
			ress[1][i] = 1;
		}
		cnts[1] = 10;
		for (int i = 2; i < 65; i++) {
			long cnt = 0;
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					ress[i][j] += ress[i-1][k];
				}
				cnt += ress[i][j];
			}
			cnts[i] = cnt;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int n : inputs) {
			sb.append(cnts[n]).append("\n");
		}
		System.out.println(sb);
	}
}