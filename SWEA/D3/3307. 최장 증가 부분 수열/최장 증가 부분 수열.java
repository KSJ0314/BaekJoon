import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	static int N;
	static int[] arr, lis;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#"+t+" ");
			
			init(br);
			sb.append(lis());
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int lis() {
		int size = 0;
		for (int i = 0; i < N; i++) {
			int p = Math.abs(Arrays.binarySearch(lis, 0, size, arr[i])) -1;
			lis[p] = arr[i];
			if (p == size) size++;
		}
		return size;
	}

	static void init(BufferedReader br) throws IOException {
		String[] strs;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		lis = new int[N];
		
		strs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
	}
}