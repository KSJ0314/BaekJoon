import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		
		int[] arr = new int[N];
		int[] countArr = new int[10001];
		for (int i = 0; i < N; i++) {
			int num = Integer.valueOf(br.readLine());
			arr[i] = num;
			countArr[num]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= 10000; i++) {
			for (int k = 0; k < countArr[i]; k++) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb.toString());
		
	}

}