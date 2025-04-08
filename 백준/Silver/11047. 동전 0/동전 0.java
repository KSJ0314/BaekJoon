import java.io.*;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs;
		
		strs = br.readLine().split(" ");
		
		int N = Integer.parseInt(strs[0]);
		int K = Integer.parseInt(strs[1]);
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for (int i = N-1; i >= 0 && K > 0; i--) {
			if (arr[i] > K) continue;
			cnt += K/arr[i];
			K %= arr[i];
		}
		
		System.out.println(cnt);
	}
}
