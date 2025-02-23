import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			String[] strs = br.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			int c = Integer.parseInt(strs[2]);
			int result = ((c-1)%a+1)*100 + ((c-1)/a)+1;
			
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
	
}