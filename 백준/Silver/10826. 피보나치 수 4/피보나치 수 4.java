import java.io.*;
import java.math.BigInteger;

public class Main {
	static BigInteger[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new BigInteger[10001];
		arr[0] = BigInteger.valueOf(0);
		arr[1] = BigInteger.valueOf(1);
		
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i-1].add(arr[i-2]);
		}
		
		System.out.println(arr[N]);
	}
}