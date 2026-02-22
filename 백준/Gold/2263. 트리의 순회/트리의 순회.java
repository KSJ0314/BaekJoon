import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] inOrdersIdx, postOrders;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		init();
		recursion(0, n-1, n-1);
		System.out.println(sb.toString().trim());
	}

	private static void recursion(int s, int e, int r) {
		if (s > e) return;
		
		int root = postOrders[r];
		sb.append(root).append(" ");
		
		int idx = inOrdersIdx[root];
		recursion(s, idx-1, r-(e-idx)-1);
		recursion(idx+1, e, r-1);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] strs;
		
		strs = br.readLine().split(" ");
		n = Integer.parseInt(strs[0]);
		
		inOrdersIdx = new int[n+1];
		postOrders = new int[n];

		strs = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			int n = Integer.parseInt(strs[i]);
			inOrdersIdx[n] = i;
		}
		strs = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			postOrders[i] = Integer.parseInt(strs[i]);
		}
	}
}