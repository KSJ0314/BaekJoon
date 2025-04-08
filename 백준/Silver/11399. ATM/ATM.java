import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs;
		
		int N = Integer.parseInt(br.readLine());
		
		strs = br.readLine().split(" ");
		
		int[] arr = new int[N];
		int[] sum = new int[N];
		int[] sum2 = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(arr);
		
		sum[0] = arr[0];
		sum2[0] = arr[0];
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i-1]+arr[i];
			sum2[i] = sum2[i-1]+sum[i];
		}
		
		System.out.println(sum2[N-1]);
	}
}
