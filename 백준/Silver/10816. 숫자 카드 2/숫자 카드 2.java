import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int N = Integer.parseInt(br.readLine());
		int[] numArr = new int[20000001];
		
		br.readLine();
		String[] inputStrArr = br.readLine().split(" ");
		
		for (String str : inputStrArr) {
			int i = Integer.parseInt(str);
			if (i < 0) {
				i= i*(-1)+10000000;
			}
			numArr[i]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		br.readLine();
		inputStrArr = br.readLine().split(" ");
		for (String str : inputStrArr) {
			int i = Integer.parseInt(str);
			if (i < 0) {
				i= i*(-1)+10000000;
			}
			sb.append(numArr[i]+" ");
		}
		System.out.println(sb.toString());
	}
}
