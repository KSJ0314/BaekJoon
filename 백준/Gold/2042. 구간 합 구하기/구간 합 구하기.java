import java.io.*;
import java.util.*;

public class Main {
	static int N, MK;
	static long[] arr, tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		init(br);
		initTree(0,N-1,1);
		
		while (MK-- >0) {
			String[] strs = br.readLine().split(" ");
			int flag = Integer.parseInt(strs[0]);
			int a = Integer.parseInt(strs[1]);
			long b = Long.parseLong(strs[2]);
			
			if (flag == 1) {
				int idx = a-1;
				long diff = b - arr[idx];
				updateTree(0, N-1, 1, idx, diff);
				arr[idx] = b;
			} else {
				int l = a-1;
				int r = (int) (b-1);
				long sum = sumTree(0, N-1, 1, l, r);
				sb.append(sum).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static long initTree(int s, int e, int node) {
		if (s == e) return tree[node] = arr[s];
		int mid = (s+e)/2;
		return tree[node] = initTree(s, mid, node*2) + initTree(mid+1, e, node*2+1);
	}

	private static long sumTree(int s, int e, int node, int l, int r) {
		if (r < s || e < l) return 0;
		if (l <= s && e <= r) return tree[node];
		
		int mid = (s+e)/2;
		
		return sumTree(s, mid, node*2, l, r) + sumTree(mid+1, e, node*2+1, l, r);
	}
	
	private static void updateTree(int s, int e, int node, int idx, long diff) {
		if (s <= idx && idx <= e) {
			tree[node] += diff;
		} else return;
		
		if (s == e) return;
		
		int mid = (s+e)/2;
		updateTree(s, mid, node*2, idx, diff);
		updateTree(mid+1, e, node*2+1, idx, diff);
	}

	public static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		MK = Integer.parseInt(strs[1]);
		MK += Integer.parseInt(strs[2]);
		arr = new long[N];
		tree = new long[4*N+1];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
	}
	
}