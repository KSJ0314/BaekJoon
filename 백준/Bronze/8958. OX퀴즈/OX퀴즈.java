import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			String str = br.readLine();
			
			int sum = 0;
			int cnt = 1;
			for (char ch : str.toCharArray()) {
				if (ch == 'O') {
					sum+=cnt;
					cnt++;
				} else {
					cnt = 1;
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
	
}