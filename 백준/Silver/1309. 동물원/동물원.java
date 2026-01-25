import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		final int MOD = 9901;
		
		long times3 = 1;
		long times2 = 2;
		for (int i = 1; i < N; i++) {
			long temp = (times3 + times2) % MOD;
			times2 = (times3*2 + times2) % MOD;
			times3 = temp;
		}
		System.out.println((times3+times2) % MOD);
	}
}