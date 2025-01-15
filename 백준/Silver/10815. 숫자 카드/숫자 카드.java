import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] N = new boolean[20000001];
		StringBuilder sb = new StringBuilder();
		
		int inputInt = Integer.parseInt(br.readLine());
		for (String str : br.readLine().split(" ")) {
			int num = Integer.parseInt(str);
			if (num < 0) {
				num = num*(-1) +10000000;
			}
			N[num] = true;
		}
		
		inputInt = Integer.parseInt(br.readLine());
		for (String str : br.readLine().split(" ")) {
			int num = Integer.parseInt(str);
			if (num < 0) {
				num = num*(-1) +10000000;
			}
			sb.append(N[num]?"1 ":"0 ");
		}
		
		System.out.println(sb.toString().trim());
		
	}
}
